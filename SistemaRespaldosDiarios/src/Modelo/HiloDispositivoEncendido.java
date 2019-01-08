/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Ping;

/**
 *
 * @author JULIO
 */
public class HiloDispositivoEncendido extends Thread{
    private Dispositivo dispositivo;
    public HiloDispositivoEncendido(String dirip, String nombre) {
        this.dispositivo= new Dispositivo(dirip, nombre);
    }
    @Override
	public void run() {
            
            while (true){
               
            }
                
            
        }

    public String getEstado() {
        return dispositivo.getEstado();
    }
    
        
    
}
