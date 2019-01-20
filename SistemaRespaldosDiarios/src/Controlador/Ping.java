/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/*
*Esta clase se encarga de realizar un ping a los dispositivos
*de la red y comprueba si
*están o no conectados
*@author Luis Macas, Christin Ochoa, Martin Herrera
*@version:17/7/2018
*/

/**
 *Funcion que realiza ping a una direccion ip especifica
 * @author JULIO
 */

public class Ping {
    private final String address;

/*
*Constructor de la clase
*@param address Direccion ip del equipo
*/    

    /**
     *
     * @param address
     */
    
    public Ping(String address) {
        this.address = address;
    }
 /*Esta funcion ejecuta el comando 
  *"ping + ipAddress" y muestra por pantalla los resultados 
  * que se obtienen al correr el comando.
  * @param command Comando que se desea que se ejecute (ping + direccion_ip)
  */

    /**
     *
     * @param command
     */

    public  void runSystemCommand(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
            String s = "";
            // reading output stream of the command}
            while ((s = inputStream.readLine()) != null) {
                System.out.println(s);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
	}
    /*Esta funcion determina si una direccion ip es alcanzable
    @return Un valor booleno, yes si el dispositivo fue alcanzado, no
    si no se pudo alcanzar*/

    /**
     *
     * @return
     */

    public boolean isReachable() {
        boolean isReachable = true;  
        try {
            InetAddress inetAddress = InetAddress.getByName(address);
             isReachable = inetAddress.isReachable(5000);
            //System.out.printf("Is the address [%s] reachable? -%s\n", address, isReachable ? "Yes" : "No");
        } catch (IOException e) {
            e.printStackTrace();
        }
      return isReachable;
    }
}