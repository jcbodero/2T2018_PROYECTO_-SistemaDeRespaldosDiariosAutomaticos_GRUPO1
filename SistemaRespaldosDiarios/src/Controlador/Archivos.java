/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JULIO
 */
public class Archivos {
    
    public static void leerDatos() throws FileNotFoundException, IOException {
        File archivo = new File("src/documentoComasInventario.csv");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] lin = linea.split(";");
        }
    }
    
    public static void escribirDatos(String cadena,String archivo) {
        String sFichero = archivo;
        File fichero = new File(sFichero);
        FileWriter fstream;
        try {
            fstream = new FileWriter(sFichero, true);
            BufferedWriter bw = new BufferedWriter(fstream);
            bw.write(cadena+"\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
