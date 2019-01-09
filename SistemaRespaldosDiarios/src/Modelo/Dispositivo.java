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

    /**
     *
     * @param dirip
     * @param nombre
     */
    public Dispositivo(String dirip, String nombre) {
        this.dirip = dirip;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getDirip() {
        return dirip;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
