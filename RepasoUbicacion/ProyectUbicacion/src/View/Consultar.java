/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CiudadC;
import Controller.ContinenteC;
import Controller.EstadoC;
import Controller.PaisC;
import Model.Entity.Ciudad;
import Model.Entity.Continente;
import Model.Entity.Estado;
import Model.Entity.Pais;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan
 */
public class Consultar extends javax.swing.JFrame {

    /**
     * Creates new form Consultar
     */
    public Consultar() {
        initComponents();
         this.SelectComboBox();
        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    SelectComboBox();
                }
            }
        });
    }
    private void SelectComboBox() {
        String valorSeleccionado = (String) jComboBox1.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Pais":
                    this.ConsultaPais();
                    break;
                case "Estado":
                    this.ConsultaEstado();
                    break;
                case "Ciudad":
                    this.ConsultaCiudad();
                    break;
                case "Continente":
                    this.ConsultaContinente();
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaContinente() {

        try {
            ContinenteC controlador = new ContinenteC();
            ArrayList<Continente> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);
            
            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion"});

            for (Continente continente : listaDeProductos) {
                Object[] fila = new Object[2]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = continente.getCodigo_postal();
                fila[1] = continente.getDescripcion();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaPais() {

        try {
            PaisC controlador = new PaisC();
            ArrayList<Pais> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            // Limpiar las columnas existentes y establecer nuevas columnas
            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Continente"});

            for (Pais pais : listaDeProductos) {
                Object[] fila = new Object[3];

                fila[0] = pais.getCodigo_postal();
                fila[1] = pais.getDescripcion();
                fila[2] = pais.getDescripcion_continente();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ConsultaEstado() {

        try {
            EstadoC controlador = new EstadoC();
            ArrayList<Estado> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);
            
            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Pais"});

            for (Estado estado : listaDeProductos) {
                Object[] fila = new Object[3]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = estado.getCodigo_postal();
                fila[1] = estado.getDescripcion();
                fila[2] = estado.getDescripcion_pais();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaCiudad() {

        try {
            CiudadC controlador = new CiudadC();
            ArrayList<Ciudad> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Estado"});

            for (Ciudad ciudad : listaDeProductos) {
                Object[] fila = new Object[3]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = ciudad.getCodigo_postal();
                fila[1] = ciudad.getDescripcion();
                fila[2] = ciudad.getDescripcion_estado();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Continente", "Pais", "Estado", "Ciudad" }));

        jLabel1.setText("Qué desea Consultar?");

        TablaConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codico Postal", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(TablaConsultar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConsultar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
