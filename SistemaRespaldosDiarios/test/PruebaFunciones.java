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
public class PruebaFunciones {
    String cadena;
    public PruebaFunciones() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.cadena=this.separaString("hostname ROUTER_GYE");
    }
    
    @After
    public void tearDown() {
    }

    private String separaString(String cadena){
        String lista[] = cadena.split(" ");
        for (int i = 0; i < lista.length ; i++) {
            lista[i] = lista[i].replace(" ", "");
            lista[i] = lista[i].replace("\n", "");
            
        }
        return lista[1];
    }
    @Test
    public void pruebaIngreo(){
        String resutado = this.cadena;
        Assert.assertEquals("ROUTER_GYE", resutado);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
