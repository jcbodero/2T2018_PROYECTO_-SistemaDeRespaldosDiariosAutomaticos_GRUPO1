/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.SSH;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JULIO
 */
public class HiloNombreDispositivo extends Thread{
    private LinkedList<String> listaDispositivo;
    private LinkedList<String> direccionesIp;

    public HiloNombreDispositivo() {
        this.listaDispositivo = new LinkedList<>();
        this.direccionesIp = new LinkedList<>();
        this.direccionesIp.add("192.168.1.1");
    }
    
    @Override
    public void run(){
        while (true){
            try {
                String resultado = SSH.ConectarSSh("admin","admin","192.168.1.1", 22, "show run | include hostname");
                if(!this.listaDispositivo.contains(resultado))
                    this.listaDispositivo.add(resultado);
            } catch (JSchException | IllegalAccessException | IOException ex) {
                Logger.getLogger(HiloNombreDispositivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LinkedList<String> getListaDispositivo() {
        return listaDispositivo;
    }
    
    
    
}
