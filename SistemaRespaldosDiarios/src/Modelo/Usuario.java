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
    

    public Usuario(String Usuario, String Contra) {
        try {
            llamarUsuarioDataBase(Usuario, Contra);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Conectar.IsServerCaido = true;
        }
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

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
