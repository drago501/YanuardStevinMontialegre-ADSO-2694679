/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import ConexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author david
 */
public class Registro {
    Conexion con= new Conexion();
    Connection cn = con.conectar();
    
    public void registrarbd(Usuario p ){
        try{
            
            
        // Verificar que los campos obligatorios no estén vacíos
        if (p.getNombre().isEmpty() || p.getDocumento().isEmpty() || p.getTelefono().isEmpty() || p.getColor().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // No continuar con la inserción si faltan campos
        }
            PreparedStatement ps=cn.prepareStatement("INSERT INTO usuarios(nombre, color, telefono, documento)VALUES(?,?,?,?)");
            ps.setString(1, p.getNombre());
            ps.setString(4, p.getDocumento());
            ps.setString(3, p.getTelefono());
            ps.setString(2, p.getColor());
            ps.executeUpdate();
      
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "EROR"+e);
        }
    }    

        
        
    
        public void registrarCanciones(Canciones s) {
        try {
            
              // Verificar que los campos de Canciones no estén vacíos
        if (s.getNombreC1().isEmpty() || s.getNombreC2().isEmpty() || s.getNombreC3().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos de canciones son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // No continuar con la inserción si faltan campos
        }
            String nombreCancion1 = s.getNombreC1();
            String nombreCancion2 = s.getNombreC2();
            String nombreCancion3 = s.getNombreC3();
            
            registrarCancion(nombreCancion1);
            registrarCancion(nombreCancion2);
            registrarCancion(nombreCancion3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la canción: " + e.getMessage());
        }
    }

    private void registrarCancion(String nombreCancion) {
        try {
            String selectQuery = "SELECT id_canciones, NroCanciones FROM canciones WHERE nombre = ?";
            String insertQuery = "INSERT INTO canciones (nombre, NroCanciones) VALUES (?, 1) ON DUPLICATE KEY UPDATE NroCanciones = NroCanciones + 1";

            try (PreparedStatement selectStatement = cn.prepareStatement(selectQuery)) {
                selectStatement.setString(1, nombreCancion);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    int idCancion = resultSet.getInt("id_canciones");
                    int nroCanciones = resultSet.getInt("NroCanciones");

                    String updateQuery = "UPDATE canciones SET NroCanciones = ? WHERE id_canciones = ?";
                    try (PreparedStatement updateStatement = cn.prepareStatement(updateQuery)) {
                        updateStatement.setInt(1, nroCanciones + 1);
                        updateStatement.setInt(2, idCancion);
                        updateStatement.executeUpdate();
                    }

                } else {
                    try (PreparedStatement insertStatement = cn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                        insertStatement.setString(1, nombreCancion);
                        insertStatement.executeUpdate();

                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    
    
    public void registrarArtista(Artistas a) {
        try {
              // Verificar que el campo de artista no esté vacío
        if (a.getAutor().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de artista es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // No continuar con la inserción si falta el campo
        }
            String nombreArtista = a.getAutor();
           
            registrarArtista(nombreArtista);
           
        } catch (Exception e) {
        }
    }

    private void registrarArtista(String nombreArtista) {
        try {
            
            
            String selectQuery = "SELECT id_artista, NroArtista FROM artista WHERE nombre = ?";
            String insertQuery = "INSERT INTO artista (nombre, NroArtista) VALUES (?, 1) ON DUPLICATE KEY UPDATE NroArtista = NroArtista + 1";

            try (PreparedStatement selectStatement = cn.prepareStatement(selectQuery)) {
                selectStatement.setString(1, nombreArtista);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    int idArtista = resultSet.getInt("id_artista");
                    int NroArtista = resultSet.getInt("NroArtista");

                    String updateQuery = "UPDATE artista SET NroArtista = ? WHERE id_artista = ?";
                    try (PreparedStatement updateStatement = cn.prepareStatement(updateQuery)) {
                        updateStatement.setInt(1, NroArtista + 1);
                        updateStatement.setInt(2, idArtista);
                        updateStatement.executeUpdate();
                    }

                } else {
                    try (PreparedStatement insertStatement = cn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                        insertStatement.setString(1, nombreArtista);
                        insertStatement.executeUpdate();

                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la canción: " + e.getMessage());
        }
    }
}
    

    

   
     
