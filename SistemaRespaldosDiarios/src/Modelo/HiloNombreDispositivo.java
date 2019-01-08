/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Ping;
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
    private LinkedList<Dispositivo> listaDispositivo;
    private LinkedList<String> direccionesIp;
    public HiloNombreDispositivo() {
        this.listaDispositivo = new LinkedList<>();
        this.direccionesIp = new LinkedList<>();
        this.direccionesIp.add("192.168.1.1");
        this.direccionesIp.add("192.168.2.1");
        this.direccionesIp.add("192.168.3.1");
    }
    
    @Override
    public void run(){
        while (true){
            try {
                for (String dirip : direccionesIp) {
                    String resultado = SSH.ConectarSSh("admin", "admin", dirip, 22, "show run | include hostname");
                    resultado.replace("!n","\n");
                    System.out.println(resultado);
                    if (resultado != null) {
                        if (!containsResultado(resultado)) {
                            this.listaDispositivo.add(new Dispositivo(dirip,resultado));
                            
                        }
                    }

                }
              
                for (Dispositivo dispositivo : listaDispositivo) {
                    Ping p1 = new Ping(dispositivo.getDirip());
                    if (p1.isReachable()) {
                        dispositivo.setEstado("On");
                    } else {
                        dispositivo.setEstado("Off");
                    }
                }

            } catch (JSchException | IllegalAccessException | IOException ex) {
                Logger.getLogger(HiloNombreDispositivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LinkedList<Dispositivo> getListaDispositivo() {
        return listaDispositivo;
    }
    
    public Boolean containsResultado(String resultado){
        for (Dispositivo dispositivo : listaDispositivo) {
            if(dispositivo.getNombre().equals(resultado)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
