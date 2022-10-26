/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package precentacion;

import datos.PeliculaDAOJDBC;
import dominio.PeliculasDTO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robyn
 */
public class Peliculas extends javax.swing.JFrame {

    /**
     * Creates new form Peliculas
     */
    public Peliculas() {
        this.getContentPane().setBackground(new Color(38, 50, 56));
        initComponents();
        CargarTabla();
    }
    private void limpiar(){
        txtNombre.setText("");
        txtLanzamiento.setText("");
        txtId.setText("");
        txtCalificacion.setText("");
    }
    
    private void CargarTabla(){    
        try {
            PeliculaDAOJDBC peliculaJdbc = new PeliculaDAOJDBC();
            List<PeliculasDTO> pelicula = peliculaJdbc.Select();
            DefaultTableModel modeloTabla = (DefaultTableModel) tblPeliculas.getModel();
            modeloTabla.setRowCount(0);
            Object[] fila = new Object[4];    
            for(PeliculasDTO peliculas: pelicula){  
                    fila[0] = peliculas.getID_pelicula();
                    fila[1] = peliculas.getNombre_p();
                    fila[2] = peliculas.getF_produccion();
                    fila[3] = peliculas.getCalificacion_p();
                    modeloTabla.addRow(fila);
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hay un erro en cargar tabla! "+ ex);
        }
    }
    
    
    private void insertar(){
        PeliculaDAOJDBC peliculajdbc = new PeliculaDAOJDBC();
        PeliculasDTO pelicula = new PeliculasDTO();
        try {
            
            pelicula.setNombre_p(txtNombre.getText());
            pelicula.setF_produccion(Integer.parseInt(txtLanzamiento.getText()));
            pelicula.setCalificacion_p(Integer.parseInt(txtCalificacion.getText()));
            peliculajdbc.Insert(pelicula);
            CargarTabla();
            limpiar();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hay un erro en Insertar! "+ex);
        }    
    }
    
    private void actualizar(){
        PeliculaDAOJDBC peliculajdbc = new PeliculaDAOJDBC();
        PeliculasDTO pelicula = new PeliculasDTO();
        try {
            pelicula.setID_pelicula(Integer.parseInt(txtId.getText()));
            pelicula.setNombre_p(txtNombre.getText());
            pelicula.setF_produccion(Integer.parseInt(txtLanzamiento.getText()));
            pelicula.setCalificacion_p(Integer.parseInt(txtCalificacion.getText()));
            peliculajdbc.update(pelicula);
            CargarTabla();
            limpiar();       
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Hay un erro en Actualizar! "+ex); 
        }    
    }
    
    public void eliminar(){
        PeliculaDAOJDBC peliculajdbc = new PeliculaDAOJDBC();
        PeliculasDTO pelicula = new PeliculasDTO();
        
        try {
            pelicula.setID_pelicula(Integer.parseInt(txtId.getText()));
            peliculajdbc.Delete(pelicula);
            CargarTabla();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtLanzamiento = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        btnlimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PELICULAS");

        tblPeliculas.setBackground(new java.awt.Color(255, 193, 7));
        tblPeliculas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblPeliculas.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        tblPeliculas.setForeground(new java.awt.Color(255, 255, 255));
        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Lanzamiento", "Calificacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeliculas);

        jPanel2.setBackground(new java.awt.Color(255, 193, 7));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cascadia Code", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("Datos");
        jPanel2.setFont(new java.awt.Font("Cascadia Code", 0, 12)); // NOI18N
        jPanel2.setName("Datos"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lanzamiento");

        txtNombre.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N

        txtLanzamiento.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N

        btnActualizar.setBackground(new java.awt.Color(49, 27, 146));
        btnActualizar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnInsertar.setBackground(new java.awt.Color(27, 94, 32));
        btnInsertar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar");
        btnInsertar.setBorder(null);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id");

        txtId.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Calificacion");

        txtCalificacion.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N

        btnlimpiar.setBackground(new java.awt.Color(232, 234, 246));
        btnlimpiar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setBorder(null);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLanzamiento)
                                    .addComponent(txtNombre)
                                    .addComponent(txtCalificacion)
                                    .addComponent(txtId)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlimpiar))
                .addGap(16, 16, 16))
        );

        btnRegresar.setBackground(new java.awt.Color(224, 242, 241));
        btnRegresar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        insertar();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeliculasMouseClicked
        DefaultTableModel tabla = (DefaultTableModel) tblPeliculas.getModel();
        int fila = tblPeliculas.getSelectedRow();
        String id = tabla.getValueAt(fila, 0).toString();
        String nombre = tabla.getValueAt(fila, 1).toString();
        String lanzamiento = tabla.getValueAt(fila, 2).toString();
        String calificacion = tabla.getValueAt(fila, 3).toString();
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtLanzamiento.setText(lanzamiento);
        txtCalificacion.setText(calificacion);
    }//GEN-LAST:event_tblPeliculasMouseClicked

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLanzamiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}