/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Conectar;
import Modelo.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class FuncionConsulta {
    Boolean anticipado;
    public FuncionConsulta() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.anticipado = isAnticipado("2018-1-1");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pruebaIngreso(){
        Boolean resutado = this.anticipado;
        Assert.assertEquals(true, resutado);
    }
    private Boolean isAnticipado(String fecha) {
        String actual = new Fecha().imprimirFecha().split(" ")[0];

        try {
            ResultSet menor = Conectar.Consulta("select Min(Fecha) from Evento where NombreArchivoRespaldo is not null;");
            menor.next();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(fecha);
            Date date2 = sdf.parse(menor.getString(1).split(" ")[0]);
            String fechaMenor = menor.getString(1).split(" ")[0];
            //date1 < date2, devuelve un valor mayor que 0
            //date2 > date1, devuelve un valor mayor que 0
            //date1 = date3, se mostrará un 0 en la consola
            return date1.compareTo(date2) < 0;

        } catch (ParseException | SQLException ex) {

        }
        return false;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
