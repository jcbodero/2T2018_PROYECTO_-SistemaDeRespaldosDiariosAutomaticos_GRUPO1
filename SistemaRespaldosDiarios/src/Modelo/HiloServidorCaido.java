/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Ping;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author JULIO
 */
public class HiloServidorCaido extends Thread{

    /**
     *Variable que inicia hilos de verificacion al servidor
     */
    public static boolean ServerBaseDatosCaido;

    /**
     *Variable que inicializa la verificacion del servidor caido
     */
    public static boolean ServerFTPCaido;
    
    @Override
    public void run(){
        while(true){
            this.ServerBaseDatosCaido = !new Ping("192.168.3.3").isReachable();   
            this.ServerFTPCaido = !new Ping("192.168.4.3").isReachable(); 
        }
    }  
}
