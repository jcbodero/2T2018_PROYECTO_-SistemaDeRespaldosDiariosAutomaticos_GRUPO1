/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JULIO
 */
public class Dispositivo {
    private String dirip;
    private String nombre;
    private String estado = "Off";

    public Dispositivo(String dirip, String nombre) {
        this.dirip = dirip;
        this.nombre = nombre;
    }

    public String getDirip() {
        return dirip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
