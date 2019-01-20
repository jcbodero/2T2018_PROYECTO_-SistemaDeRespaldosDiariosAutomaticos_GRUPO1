/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.ConsultaArchivo;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author JULIO
 */
public class variablesGlobales {

    /**
     *
     */
    public static String USUARIO_ACTIVO;

    /**
     *
     */
    public static String DISPOSITIVO_ACTIVO;

    /**
     *
     */
    public static String DISPOSITIVO_DIRECCIONIP;

    /**
     *
     */
    public static String DISPOSITIVO_ESTADO;
    
    /**
     *Variable que guarda la lista de dispositivos y su estado 
     */
    public static LinkedList<String> dispositivos = new LinkedList<>();
    /**
     *Variable que guarda la ventana de consulta
     */
    public static ConsultaArchivo ventana;
    
}
