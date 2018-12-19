/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/*
*Esta clase permite obtener la fecha: dia, mes y año 
*Fue creada para poder asignar un formato al nombre con el *
*que se guardan los archivos de configuracion en el server.
*@author Luis Macas, Christin Ochoa, Martin Herrera
*@version:17/7/2018
*/
public class Fecha { //declaracion de clase Fecha
    private int dia; //atributo para dia
    private int mes; //atributo para mes
    private int anio; //atributo para anio
    private int hora; 
    private int minutos;
    private int segundos; 
    
    /*
    *contructor para establecer la fecha
    */
    public Fecha() {  //contructor fecha
    Calendar calendario = Calendar.getInstance();  //Instanciamos un objeto
    this.anio = calendario.get(Calendar.YEAR);     // obtenemos el año actual
    this.mes = calendario.get(Calendar.MONTH) + 1;
    this.dia = calendario.get(Calendar.DAY_OF_MONTH); //obtenemos el dia del mes
    this.hora =calendario.get(Calendar.HOUR_OF_DAY);
    this.minutos = calendario.get(Calendar.MINUTE);
    this.segundos = calendario.get(Calendar.SECOND);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    /*
     * funciones Get y Set del atributo dia
    */
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    /*
    *funciones Get y Set del atributo mes
    */
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    /*
    *funciones Get y Set del atributo año
    */
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    /*
    *Devuelve un String con el siguiente formato: dia_mes_año
    *@return formato cadena de caracteres que indica la fecha
    */
    public String imprimirFecha() {
        String formato;
        formato = this.dia + "_" + this.mes + "_" + this.anio;
        return formato;
    }  
}
