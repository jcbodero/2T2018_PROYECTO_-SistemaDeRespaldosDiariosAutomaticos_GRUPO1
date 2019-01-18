/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PruebaObtenerSerie {
    
    public PruebaObtenerSerie() {
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
    public void pruebaIngreo(){
        String resutado = obtenerSerie("PID: CISCO7206VXR      , VID:    , SN: 4279256517\n" +
"PID: NPE-400           , VID:    , SN: 11111111\n" +
"PID: C7200-I/O-2FE/E   , VID:    , SN: 00000000\n" +
"PID: PA-8T-X21=        , VID:    , SN: 4294967295\n" +
"PID: PA-8T-X21=        , VID:    , SN: 4294967295\n" +
"PID: PWR-7200-AC       , VID:    , SN:\n" +
"PID: PWR-7200-AC       , VID:    , SN:");
        Assert.assertEquals("4279256517", resutado);
    }
    
    private String obtenerSerie(String cadena){
        String[] linea  = cadena.split("\n");
        String[] linea2 = linea[0].split(",");
        String[] linea3 = linea2[2].split(":");
        return linea3[1].trim();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
