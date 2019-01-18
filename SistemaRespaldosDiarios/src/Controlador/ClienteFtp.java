/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
/**
 *
 * @author JULIO
 */
public class ClienteFtp {
    public static void guardar(String filename , String name){
        FTPClient client = new FTPClient();
        // Datos para conectar al servidor FTP
        String ftp = "192.168.4.3"; // También puede ir la IP
        String user = "julio";
        String password = "1234";
 
        try {
            // Conactando al servidor
            client.connect(ftp);
  
 
            // Logueado un usuario (true = pudo conectarse, false = no pudo
            // conectarse)
            if (client.login(user, password))
            {
                client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
                client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
                client.enterLocalPassiveMode();
                
                FileInputStream fis = new FileInputStream(filename);
                
                // Guardando el archivo en el servidor
               if (client.changeWorkingDirectory("/home/julio"))
                    if (client.storeFile(name, fis))
                        System.out.println("Se ha grabado el fichero");
                    else
                        System.out.println("No se ha grabado el fichero");
     
                // Cerrando sesión
                client.logout();
     
                // Desconectandose con el servidor
                client.disconnect();
            }   
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
   }
 
}
