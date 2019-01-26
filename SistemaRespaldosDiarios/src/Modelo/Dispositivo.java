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

    /**
     * Variable de direccion ip
     *
     * @author JULIO
     */
    private String dirip;
    /**
     * Variable estado Dispositivo
     *
     * @author JULIO
     */
    private String nombre;
    /**
     * Variable estado Dispositivo
     *
     * @author JULIO
     */
    private String estado = "Off";

    /**
     * Constructor con los aributos basicos de un dispositivo de red
     *
     * @author Julio Bodero
     * @param dirip
     * @param nombre
     */
    public Dispositivo(String dirip, String nombre) {
        this.dirip = dirip;
        this.nombre = nombre;
    }

    /**
     * Se obtiene la direccion ip del dispositivo.
     *
     * @return
     */
    public String getDirip() {
        return dirip;
    }

    /**
     * Se obtiene el nombre del dispositivo
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Se obtiene el estado del dispositivo por defecto se encuentra apagado.
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Funcion que cambia el estado segun el ping realizado al dispositivo
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
