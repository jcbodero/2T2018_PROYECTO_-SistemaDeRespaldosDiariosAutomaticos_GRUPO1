/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Fecha;
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
public class ClaseFecha {
    Fecha fecha;
    public ClaseFecha() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.fecha=new Fecha();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pruebaIngreso(){
        String resutado = fecha.imprimirFecha();
        Assert.assertEquals("2019-01-16 3:21", resutado);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
