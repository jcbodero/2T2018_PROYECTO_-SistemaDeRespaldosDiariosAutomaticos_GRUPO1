/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Usuario;
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
public class ClaseUsuario {
    
    Usuario user;
    public ClaseUsuario() {
        
    }
   
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new Usuario("jcbodero", "1234");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pruebaIngreso(){
        Boolean resutado = user.ExisteUsuario();
        Assert.assertEquals(true, resutado);
    }
}
