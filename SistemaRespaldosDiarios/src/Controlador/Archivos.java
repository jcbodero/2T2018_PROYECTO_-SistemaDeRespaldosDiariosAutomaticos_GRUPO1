/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JULIO
 */
public class Archivos {

    /**
     * Funcion Que Lee Datos de un Archivo.
     *
     * @param listaDirecciones
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void leerDatos(LinkedList<String> listaDirecciones){
        try{
            File archivo = new File("src/Recursos/direccionesIp.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                listaDirecciones.add(linea);

            }
        }catch(Exception ex){
            
        }
           
    }

    /**
     * Funcion que escribe un archivo recibe una variable cadena, el nombre del
     * archivo y se indica si sobreescribir o crear nueva linea en el archivo.
     *
     * @author Julio Bodero
     * @param cadena
     * @param archivo
     * @param sobreescribir
     */
    public static void escribirDatos(String cadena, String archivo, Boolean sobreescribir) {
        String sFichero = archivo;
        FileWriter fstream;
        try {
            fstream = new FileWriter(sFichero, sobreescribir);
            BufferedWriter bw = new BufferedWriter(fstream);
            bw.write(cadena + "\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Funcion que realiza la transaccion de un Evento sin el nombre de un
     * archivo
     *
     * @author Julio Bodero
     * @param Usuario
     * @param fecha
     * @param Dispositivo
     * @param Accion
     */
    public static void guardarHistorialEvento(String Usuario, String fecha, String Dispositivo, String Accion) {
        Conectar.ejecutarTransaccion("INSERT INTO `Evento`(`Administrador`, `Dispositivo`, `Accion`, `Fecha`) "
                + "VALUES ('" + Usuario + "',(SELECT `Serie`FROM `Dispositivo` WHERE NombreDispositivo='" + Dispositivo + "'),'" + Accion + "','" + fecha + "');");
    }

    /**
     * Funcion que realiza la transaccion de un Evento con el nombre de un
     * archivo
     *
     * @author Julio Bodero
     * @param Usuario
     * @param fecha
     * @param Dispositivo
     * @param Accion
     * @param NombreArchivo
     */
    public static void guardarHistorialEvento(String Usuario, String fecha, String Dispositivo, String Accion, String NombreArchivo) {
        Conectar.ejecutarTransaccion("INSERT INTO `Evento`(`Administrador`, `Dispositivo`, `Accion`, `Fecha`, `NombreArchivoRespaldo`) "
                + "VALUES ('" + Usuario + "',(SELECT `Serie`FROM `Dispositivo` WHERE NombreDispositivo='" + Dispositivo + "'),'" + Accion + "','" + fecha + "','" + NombreArchivo + "');");

    }
    
    public static void guardarDispositivo(String serie, String nombre, String ip) {
        Conectar.ejecutarTransaccion("INSERT INTO Dispositivo(Serie, NombreDispositivo, DireccionIp, Mask) VALUES "
                + "('"+serie+"','"+nombre+"','"+ip+"','255.255.255.0');");

    }
    public static Boolean existeDispositivo(String ip) {
        ResultSet res = Conectar.Consulta("select DireccionIp from Dispositivo;");
        try {
            while (res.next()) {
                String texto = res.getString(1);
                if (texto.equals(ip)){
                    return true;
                }
            }
        } catch (SQLException ex) {
           
        }
        return false;
    }
    
}
