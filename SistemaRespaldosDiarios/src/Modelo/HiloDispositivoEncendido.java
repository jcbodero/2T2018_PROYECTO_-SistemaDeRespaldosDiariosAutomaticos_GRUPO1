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
    private String dirip;
    private String estado = "Off";

    public HiloDispositivoEncendido(String dirip) {
        this.dirip = dirip;
    }
    @Override
	public void run() {
            Ping p1 = new Ping(dirip);
            while (p1.isReachable()){
                this.estado ="On";
            }
            this.estado = "Off";
        }

    public String getEstado() {
        return estado;
    }
    
        
    
}
