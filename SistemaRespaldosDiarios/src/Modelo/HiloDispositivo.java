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
 *En esta clase al iniciar el hilo se obtendra el nombre de los dispositivos y sus estados. 
 * @author JULIO
 */
public class HiloDispositivo extends Thread{
    private LinkedList<Dispositivo> listaDispositivo;
    private LinkedList<String> direccionesIp;

    /**
     *Constructor del hilo de un dispositivo, se inicializa la lista de direcciones ip y se almacena los dispositivos. 
     */
    public HiloDispositivo() {
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
                Logger.getLogger(HiloDispositivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *Funcion que devuelve la lista de dispositivos creados en la ejecucion del hilo
     * @return
     */
    public LinkedList<Dispositivo> getListaDispositivo() {
        return listaDispositivo;
    }
    
    /**
     *Funcion que verifica si la lista de dispositivos contiene el resultado de la consulta ssh 
     * @param resultado
     * @return
     */
    public Boolean containsResultado(String resultado){
        for (Dispositivo dispositivo : listaDispositivo) {
            if(dispositivo.getNombre().equals(resultado)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
