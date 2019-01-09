/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conectar;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JULIO
 */
public class Usuario {

    private String Usuario;
    private String Nombre;
    private boolean Existe;
    
    /**
     *Constructor de un usuario basico administrado del sistema
     * @param Usuario
     * @param Contra
     */
    public Usuario(String Usuario, String Contra) {
        try {
            llamarUsuarioDataBase(Usuario, Contra);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Conectar.IsServerCaido = true;
        }
    }

    /**
     *Funcion que devuelve el nombre de usuario del administrador 
     * @return
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     *Funcion que devuelve el nombre del usuario 
     * @return
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     *Funcion que retorna verdadero si el usuario existe
     * @return
     */
    public Boolean ExisteUsuario() {
        return Existe;
    }

    private void llamarUsuarioDataBase(String Usuario, String Contra) throws SQLException {
        ResultSet res = Conectar.Consulta("Select Usuario, Nombre from Administrador where Usuario = '" + Usuario + "' and Clave = '" + Contra + "';");
        try {
            while (res.next()) {
                this.Usuario = res.getString(1);
                this.Nombre = res.getString(2);
                Existe = this.Usuario != null;
            }
        } catch (NullPointerException e) {
        }

    }

}
