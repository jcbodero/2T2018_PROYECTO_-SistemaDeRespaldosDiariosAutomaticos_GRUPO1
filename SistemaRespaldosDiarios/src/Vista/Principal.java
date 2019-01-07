/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Archivos;
import Controlador.Conectar;
import Controlador.SSH;
import Modelo.Fecha;
import Modelo.HiloDispositivoEncendido;
import Modelo.HiloNombreDispositivo;
import Modelo.Usuario;
import com.jcraft.jsch.JSchException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * Esta clase contiene la interfaz gráfica de la pantalla principal
 * de nuestra aplicación. Permite escoger el tipo de dispositivo del que
 * se desea hacer respaldo
 * @author Luis Macas, Christin Ochoa, Martin Herrera
 * @version:5/8/2018
 */
public class Principal extends javax.swing.JFrame{
    
    private HiloDispositivoEncendido h1;
    private HiloNombreDispositivo h2;
    
    public Principal(){
        initComponents();
        iniciarHilos();
        this.setLocationRelativeTo(null);
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contenedorVentana = new org.edisoncor.gui.panel.Panel();
        jLabel4 = new javax.swing.JLabel();
        contenedorLogin = new org.edisoncor.gui.panel.PanelTranslucido();
        ListaDispositivos = new javax.swing.JComboBox<>();
        labelUsuario = new javax.swing.JLabel();
        labelContra = new javax.swing.JLabel();
        labelDispositivo = new javax.swing.JLabel();
        txtContra = new org.edisoncor.gui.passwordField.PasswordField();
        txtUsuario = new org.edisoncor.gui.textField.TextField();
        btnLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        imgLogin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        estadoDispositivo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        contenedorVentana.setColorPrimario(new java.awt.Color(102, 102, 255));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sistemas Respaldos Diarios Automatico");

        contenedorLogin.setColorPrimario(new java.awt.Color(153, 153, 255));

        ListaDispositivos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ListaDispositivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[Seleccione Dispositivo]", "SW-GYE", "ROU-GYE", "ROU-UIO" }));

        labelUsuario.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuario");

        labelContra.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        labelContra.setForeground(new java.awt.Color(255, 255, 255));
        labelContra.setText("Contraseña");

        labelDispositivo.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        labelDispositivo.setForeground(new java.awt.Color(255, 255, 255));
        labelDispositivo.setText("DISPOSITIVOS");

        txtContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContra.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(204, 204, 255));
        btnLogin.setFont(new java.awt.Font("Gill Sans MT", 1, 16)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/entrar.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setDefaultCapable(false);
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        imgLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/login.png"))); // NOI18N
        imgLogin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        estadoDispositivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dispositivo", "Estado"
            }
        ));
        jScrollPane2.setViewportView(estadoDispositivo);

        javax.swing.GroupLayout contenedorLoginLayout = new javax.swing.GroupLayout(contenedorLogin);
        contenedorLogin.setLayout(contenedorLoginLayout);
        contenedorLoginLayout.setHorizontalGroup(
            contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLoginLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorLoginLayout.createSequentialGroup()
                                .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(contenedorLoginLayout.createSequentialGroup()
                                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                                        .addComponent(labelDispositivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ListaDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                                        .addComponent(labelContra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(632, 632, 632))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLoginLayout.createSequentialGroup()
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(imgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin)))
                .addGap(679, 679, 679))
        );
        contenedorLoginLayout.setVerticalGroup(
            contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLoginLayout.createSequentialGroup()
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(imgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLoginLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(labelContra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(contenedorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListaDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenedorVentanaLayout = new javax.swing.GroupLayout(contenedorVentana);
        contenedorVentana.setLayout(contenedorVentanaLayout);
        contenedorVentanaLayout.setHorizontalGroup(
            contenedorVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorVentanaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenedorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(contenedorVentanaLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel4)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        contenedorVentanaLayout.setVerticalGroup(
            contenedorVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorVentanaLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(contenedorVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contenedorVentana.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       if (!IngresoValido()){ 
           return;
       }
        Usuario us = new Usuario(txtUsuario.getText(), txtContra.getText());
        if (us.ExisteUsuario()) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + us.getNombre());
            
            try {
                try {
                    String resultado = SSH.ConectarSSh("admin","admin","192.168.1.1", 22, "show ip int bri");
                    String seleccion = ListaDispositivos.getSelectedItem().toString();
                    this.guardarHistorialEvento(us.getUsuario(), (new Fecha()).imprimirFecha(),seleccion, "S-Correcto");
                    Reestablecer();
                    Menu m1 = new Menu();
                    m1.show();
                   
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JSchException ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
        } else if( Conectar.IsServerCaido){
            JOptionPane.showMessageDialog(null, "SERVIDOR CAIDO !!!",
            "Error",JOptionPane.ERROR_MESSAGE);
            Reestablecer();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos");
            Reestablecer();
        }

    }//GEN-LAST:event_btnLoginActionPerformed
    private boolean IngresoValido(){
         if (txtUsuario.getText().length() == 0 && txtContra.getText().length() == 0 && ListaDispositivos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario, Contraseña Y seleccione Dispositivo");
              Archivos.escribirDatos(txtUsuario.getText()+";"+ListaDispositivos.getSelectedItem()+";"+
                        "Falta Informacion"+";"+(new Fecha()).imprimirFecha(), "src/DocumentosGenerados/logs");
              if(ListaDispositivos.getSelectedItem() == "ROU_GYE"){
                  System.out.println("Igual");
              }else{
                  System.out.println("No igual");
              }
            return false;
        } else {
            if (txtUsuario.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese Usuario");
                return false;
            }
            if (txtContra.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese Contraseña");
                return false;
            }
            if (ListaDispositivos.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Dispositivo");
                 Archivos.escribirDatos(txtUsuario.getText()+";"+ListaDispositivos.getSelectedItem()+";"+
                        "Falta Informacion"+";"+(new Fecha()).imprimirFecha(), "src/DocumentosGenerados/logs");
                return false;
            }
        }
        
        return true;
    }
    private void Reestablecer(){
        txtContra.setText(null);
        txtUsuario.setText(null);
        ListaDispositivos.setSelectedIndex(0);
    }
    
    private void guardarHistorialEvento(String Usuario, String fecha, String Dispositivo, String Accion){
        Conectar.ejecutarTransaccion("INSERT INTO `Evento`(`Administrador`, `Dispositivo`, `Accion`, `Fecha`, `NombreArchivoRespaldo`) "
                +"VALUES ('"+Usuario+"',(SELECT `Serie`FROM `Dispositivo` WHERE NombreDispositivo='"+Dispositivo+"'),'"+Accion+"','"+fecha+"','');");
    }
    
    private void llenarTablaEncendidos(){
        if(!exiteFila(h2.getListaDispositivo().getFirst())){
            DefaultTableModel modelo = (DefaultTableModel) estadoDispositivo.getModel();
            modelo.addRow(new Object[]{h2.getListaDispositivo().getFirst(),h1.getEstado()});
        }
    }
        
    private void iniciarHilos(){
        this.h1 = new HiloDispositivoEncendido("192.168.1.1");
        this.h2 = new HiloNombreDispositivo();
        this.h1.start();
        this.h2.start();
    }
    
    private void actualizarTabla() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            if(!this.h2.getListaDispositivo().isEmpty())
             llenarTablaEncendidos();
        });
        timer.start();
    }
    private Boolean exiteFila(String dato){
        if(dato==null){
            return false;
        }
        for (int i = 0; i < estadoDispositivo.getRowCount(); i++) {
            String valor  = estadoDispositivo.getValueAt(i, 0).toString().trim();
            if(valor.equals(dato)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {

            new Principal().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaDispositivos;
    private javax.swing.JButton btnLogin;
    private org.edisoncor.gui.panel.PanelTranslucido contenedorLogin;
    private org.edisoncor.gui.panel.Panel contenedorVentana;
    private javax.swing.JTable estadoDispositivo;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelContra;
    private javax.swing.JLabel labelDispositivo;
    private javax.swing.JLabel labelUsuario;
    private org.edisoncor.gui.passwordField.PasswordField txtContra;
    private org.edisoncor.gui.textField.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    
}
