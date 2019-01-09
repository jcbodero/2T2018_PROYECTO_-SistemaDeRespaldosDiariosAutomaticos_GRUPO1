package Controlador;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *Clase que realiza la conexion y las transacciones en la base de datos
 * @author JULIO
 */
public class Conectar {
    
    static Connection contacto = null;
    private static String usuario = "estudiante";
    private static String password = "estudiante";
    public static  boolean IsServerCaido = false;
    
    /**
     *Funcion que realiza la conexion a la base de datos y verifica que no este caido el servidor
     * @author Julio Bodero
     * @return
     */
    public static Connection getConexion(){
       
        //String url = "jdbc:sqlserver://DESKTOP-CHRINL5:1433;databaseName=RespaldosDiarios";
        String url = "jdbc:mysql://192.168.3.3:3306/RespaldosDiarios?zeroDateTimeBehavior=convertToNull";
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.gjt.mm.mysql.Driver");
            
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver.\n" + e.getMessage(),
            ".\nError de Conexion.\n",JOptionPane.ERROR_MESSAGE);
        }
        try{
            contacto = DriverManager.getConnection(url, Conectar.usuario, Conectar.password);
        }catch (SQLException e){
             
             Conectar.IsServerCaido  =true;
        }
        return contacto;
    }
    
    /**
     * Funcion que consulta a la base de datos ingresando una consulta, 
     * retorna un arreglo con la respuesta a la consulta.  
     *@author Julio Bodero
     * @param consulta
     * @return
     */
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            Conectar.IsServerCaido  = true;
        }
        return null;
    }

    /**
     *Funcion que ejecuta transacciones de UPDATE o INSERT 
     * @param Sql
     */
    public static void ejecutarTransaccion(String Sql){
       Connection pConectar= getConexion();
       CallableStatement statement = null;
       
       try {
            statement = pConectar.prepareCall(Sql);
            try {
                 statement.execute();
            } catch (SQLException e) {
                 e.printStackTrace();
            }
          } catch (SQLException e){
             e.printStackTrace();
        }
    }
//    public static void main (String[]args) throws SQLException{
//        ResultSet res = Conectar.Consulta("Select * from Pedidos");
//        
//        while (res.next()){
//            System.out.print(res.getString(1) + " ");
//            System.out.print(res.getString(2)+" ");
//            System.out.print(res.getString(3)+" ");
//            System.out.println(res.getString(4));
//        }
//    }
}
