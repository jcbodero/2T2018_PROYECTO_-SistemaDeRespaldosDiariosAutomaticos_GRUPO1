/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JULIO
 */
public class PruebaDescarga {
    
    public PruebaDescarga() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pruebaIngreso(){
        Boolean resutado = this.descargar("ROUTER_UIO-15_01_2019-16%52%54.cfg");
        Assert.assertEquals(true, resutado);
    }
    private boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                // We use a buffer for the copy (Usamos un buffer para la copia).
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    private Boolean descargar(String Archivo){
        String fromFile = "C:\\Users\\JULIO\\Documents\\NetBeansProjects\\2T2018_PROYECTO_SistemaDeRespaldosDiariosAutomaticos_GRUPO1\\SistemaRespaldosDiarios\\src\\DocumentosGenerados\\"+Archivo;
        String toFile = "C:\\Users\\JULIO\\Downloads\\"+Archivo;
        boolean result = copyFile(fromFile, toFile);
        return result;
    }
}
