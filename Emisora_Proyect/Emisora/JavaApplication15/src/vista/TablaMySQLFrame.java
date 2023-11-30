/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class TablaMySQLFrame extends JFrame {

    private JTable tabla;

    public TablaMySQLFrame() {
        setTitle("Tabla de MySQL en Java");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabla = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosMySQL();
    }

    private void cargarDatosMySQL() {
        DefaultTableModel model = new DefaultTableModel();

        // Configura las columnas de la tabla
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("num");

        // Conecta a la base de datos MySQL
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emisora", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ganadores");

            // Agrega filas a la tabla
            while (rs.next()) {
                int id = rs.getInt("id_ganadores");
                String nombre = rs.getString("g_numero");
                String apellido = rs.getString("g_color");
                String user = rs.getString("id_usuarios");
                model.addRow(new Object[]{id, nombre, apellido});
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tabla.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TablaMySQLFrame frame = new TablaMySQLFrame();
            frame.setVisible(true);
        });
    }
}
