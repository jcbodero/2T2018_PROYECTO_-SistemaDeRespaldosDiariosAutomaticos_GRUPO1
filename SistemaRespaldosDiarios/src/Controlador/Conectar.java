package Controlador;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conectar {
    
    static Connection contacto = null;
    private static String usuario = "Noc";
    private static String password = "administrador";
    
    
    public static Connection getConexion(){
       
        String url = "jdbc:sqlserver://DESKTOP-CHRINL5:1433;databaseName=RespaldosDiarios";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try{
            contacto = DriverManager.getConnection(url, Conectar.usuario, Conectar.password);
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    
  
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
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
    public static void main (String[]args) throws SQLException{
        ResultSet res = Conectar.Consulta("Select * from Pedidos");
        
        while (res.next()){
            System.out.print(res.getString(1) + " ");
            System.out.print(res.getString(2)+" ");
            System.out.print(res.getString(3)+" ");
            System.out.println(res.getString(4));
        }
    }
}
