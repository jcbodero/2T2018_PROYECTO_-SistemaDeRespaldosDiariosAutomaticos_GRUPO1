/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
 
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
/**
 * Clase encargada de establecer conexión y ejecutar comandos SSH.
 */
public class SSH {
 
    /**
     * Constante que representa un enter.
     */
    private static final String ENTER_KEY = "\n";
    /**
     * Sesión SSH establecida.
     */
    private Session session;
 
    /**
     * Establece una conexión SSH.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param host     Host a conectar.
     * @param port     Puerto del Host.
     *
     * @throws JSchException          Cualquier error al establecer
     *                                conexión SSH.
     * @throws IllegalAccessException Indica que ya existe una conexión
     *                                SSH establecida.
     */
    public void connect(String username, String password, String host, int port)
            throws JSchException, IllegalAccessException {
        if (this.session == null || !this.session.isConnected()) {
            JSch jsch = new JSch();

            this.session = jsch.getSession(username, host, port);
            this.session.setPassword(password);

            // Parametro para no validar key de conexion.
            //this.session.setConfig(null);//("StrictHostKeyChecking", "no");
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            this.session.connect();
        } else {
            throw new IllegalAccessException("Sesion SSH ya iniciada.");
        }
    }
 
    /**
     * Ejecuta un comando SSH.
     *
     * @param command Comando SSH a ejecutar.
     *
     * @return
     *
     * @throws IllegalAccessException Excepción lanzada cuando no hay
     *                                conexión establecida.
     * @throws JSchException          Excepción lanzada por algún
     *                                error en la ejecución del comando
     *                                SSH.
     * @throws IOException            Excepción al leer el texto arrojado
     *                                luego de la ejecución del comando
     *                                SSH.
     */
    public final String executeCommand(String command)
        throws IllegalAccessException, JSchException, IOException {
        if (this.session != null && this.session.isConnected()) {
 
            // Abrimos un canal SSH. Es como abrir una consola.
            ChannelExec channelExec = (ChannelExec) this.session.
                openChannel("exec");
 
            InputStream in = channelExec.getInputStream();
 
            // Ejecutamos el comando.
            channelExec.setCommand(command);
            channelExec.connect();
 
            // Obtenemos el texto impreso en la consola.
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String linea;
 
            while ((linea = reader.readLine()) != null) {
                builder.append(linea);
                builder.append(ENTER_KEY);
            }
 
            // Cerramos el canal SSH.
            channelExec.disconnect();
 
            // Retornamos el texto impreso en la consola.
            return builder.toString();
        } else {
            throw new IllegalAccessException("No existe sesion SSH iniciada.");
        }
    }
 
    /**
     * Cierra la sesión SSH.
     */
    public final void disconnect() {
        this.session.disconnect();
    }
    
    /**
     * Funcion que realiza la conexion, desconexion y ejecuta comandos en los dispositivos 
     * mediante conexion SSH
     *@author Julio Bodero
     * @param User
     * @param Pass
     * @param DirIp
     * @param port
     * @param Comamnd
     * @return
     * @throws JSchException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public static String ConectarSSh(String User, String Pass, String DirIp, int port, String Comamnd) throws JSchException, IllegalAccessException, IOException {
        try {
            SSH sshConnector = new SSH();
            sshConnector.connect(User, Pass, DirIp,port);
            String result = sshConnector.executeCommand(Comamnd);
            sshConnector.disconnect();
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;    
    }
    
}


