/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PruebaSql {
    
    /**
     *
     */
    public PruebaSql() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void pruebaIngreo(){
        Boolean resutado = this.existeDispositivo("192.168.2.1");
        Assert.assertEquals(true, resutado);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private static Boolean existeDispositivo(String ip) {
        ResultSet res = Conectar.Consulta("select DireccionIp from Dispositivo;");
        try {
            while (res.next()) {
                String texto = res.getString(1);
                System.out.println(texto);
                if (texto.equals(ip)){
                    return true;
                }
            }
        } catch (SQLException ex) {
           
        }
        return false;
    }
    
}
