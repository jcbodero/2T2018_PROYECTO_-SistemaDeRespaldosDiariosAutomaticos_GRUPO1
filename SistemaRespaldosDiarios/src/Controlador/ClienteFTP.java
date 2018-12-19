/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor FTPFile.
 */
package Controlador;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


/*
 * ClienteFTP se encarga de establecer una conexión con un servidor FTP
 * y permite la trasnferencia de archivos que se encuentran en sus directorios
 * @author Luis Macas, Christin Ochoa, Martin Herrera
 * @version:17/7/2018
 */  
public class ClienteFTP {
/* campos de la clase */
    private String user; //Nombre del usuario del server FTP
    private String password; //Contraseña del servidor FTP
    private String ftp; 
    private String url;
    private String directorio;
    private boolean login;
    private FTPClient ftpCliente; //Instancia de objeto clienteFTP
    private FileOutputStream fileOut;

/*
 * Constructor que inicializa la sesion FTP
 * los atributos user,password,y ftp se los inicializa
 * ademas se instancia una clase FTPClient y un file vacio en un principio.
*/
    public ClienteFTP() {
        this.user = "usuarioFTP";
        this.password = "usuarioftp";
        this.ftp = "192.168.2.20";
        ftpCliente = new FTPClient();
        this.fileOut = null;
        try {
            //Se realiza la conexión con el usuario y contraseña
            ftpCliente.connect(ftp);
            this.login = ftpCliente.login(this.user, this.password);
            if (this.login) {
                System.out.println("Login success...");
            } else {
                System.out.println("Failure success...");
            }
            /* Cerrando sesión
            this.ftpCliente.logout();
            Desconectandose con el servidor
            This.ftpCliente.disconnect();*/
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }//cierre del constructor    
   /*
    * Metodo que crea una lista con todos los archivos 
    * que contiene un directorio
    * @return una lista que contiene archivos
    */
    public FTPFile[]  listar() throws IOException {
        FTPFile[] ftpFiles = null;
        if(this.login){// si es true
            int j;  
            j = 1;
            ftpFiles = ftpCliente.listFiles();
            for (FTPFile ftpFile1 : ftpFiles) {
                FTPFile ftpFile = new FTPFile();
                ftpFile = ftpFile1;
                System.out.println(j + "." + ftpFile.getName());
                j++;
            }
            }else {
               System.out.println("No logeado...");
            }
        return ftpFiles;
    }
    /*
     * Metodo que muestra por pantalla la lista de archivos 
     * que se encuentran almacenados en una lista
     */
    public void  imprimirLista() throws IOException {
        FTPFile[] ftpFiles = null;
        if(this.login) { // si es true
            int j = 1;  
            ftpFiles = this.listar(); 
            for (FTPFile ftpFile1 : ftpFiles) {
                FTPFile ftpFile = new FTPFile();
                ftpFile = ftpFile1;
                System.out.println(j + "." + ftpFile.getName());
                j++ ;
            }
            } else {
               System.out.println("No logeado...");
            }
    }
     
    /*
     * Este metodo permite llenar un objeto tipo DefaultLisModel, el cual se
     * lo implementa en el menu de los dispositivos para mostrar los archivos por 
     * pantalla
     */
    public void  llenarLista(DefaultListModel lista1) {
        FTPFile[] ftpFiles = null;
        if(this.login) {
            try {
                // si es true
                ftpFiles = this.listar();
         
                for (FTPFile ftpFile1 : ftpFiles) {
                    FTPFile ftpFile = new FTPFile();
                    ftpFile = ftpFile1;
                    lista1.addElement(ftpFile.getName()); //añade un elementos a la lista
                }
            } catch(IOException ex) {
                Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else {
                System.out.println("No logeado...");
            }
    }
    
     public void  llenarListaxFecha(DefaultListModel lista1,String fecha) {
        FTPFile[] ftpFiles = null;
        if(this.login) {
            try {
                // si es true
                ftpFiles = this.listar();
         
                for (FTPFile ftpFile1 : ftpFiles) {
                    FTPFile ftpFile = new FTPFile();
                    ftpFile = ftpFile1;
                    if(ftpFile.getName().contains(fecha)){//si en el nombre del archivo contine la fecha indicada
                        lista1.addElement(ftpFile.getName()); //añade un elementos a la lista
                    }
                }
            } catch(IOException ex) {
                Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else {
                System.out.println("No logeado...");
            }
    }
    /*
     * Este metodo permite mostar el directorio 
     * actual en el nos encontramos dentro 
     * del servidor FTP
     */
    public void showDirectorio() {
        try {
            System.out.println("Directorio Actual:" + ftpCliente.printWorkingDirectory());
        } catch (IOException ex) {
        Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
   /*
    * Metodo que dado el nombre de una nueva ruta Permite cambiarnos a otro 
    * directorio dentro del servidor
    * @param ruta es la nueva ruta del drectorio
    */
    public void changeDirectorio(String ruta) {
        try {
            ftpCliente.changeWorkingDirectory(ruta);
            //this.showDirectorio();
            this.imprimirLista();
        } catch (IOException ex) {
            Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    * Metodo que permite descargarlo desde del servidor
    * @param new_file nombre del archivo que sera descargado
    */
    public void descargarArchivoFTP(String newFile) {
        try {
        //Se crea un carpeta en el Disco Local
            File carpeta = new File("C:/Users/CRISTIN/Desktop/RespaldosDispositivos");
            carpeta.mkdir();
            File downloadFile = new File(carpeta.getAbsolutePath() + "/" + newFile);
            fileOut = new FileOutputStream(downloadFile);
            if(ftpCliente.retrieveFile(newFile, fileOut)){
                System.out.println("Descarga correcta");
            }else{
                System.out.println("Error Descarga");
            }
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cierre de funcion
   
   
    /*
    * Esta funcion permite escoger un archivo de un diretorio dado una opcion
    *@return nombre es el nombre del archivo 
    */
    public String escogerArchivo() {
        String nombre = "";
        FTPFile[] fileArray = null;
        try {
            fileArray = this.listar();
            for (FTPFile fileArray1 : fileArray) {
                FTPFile ftpFile = new FTPFile();
                ftpFile = fileArray1;
                nombre = ftpFile.getName();
                System.out.println("\nSe descargará el archivo " + nombre);
            }
        } catch (IOException ex) {
        Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    } 
}
    

