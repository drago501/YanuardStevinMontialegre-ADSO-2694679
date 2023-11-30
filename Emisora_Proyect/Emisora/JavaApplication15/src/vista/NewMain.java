package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Menu1; 

public class NewMain extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JTextField colorField;
    private JTextField telefonoField;
    private JTextField documentoField;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton rregresarButton;

  
    private Connection connection;

    public NewMain() {
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel colorLabel = new JLabel("Color:");
        colorField = new JTextField();
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoField = new JTextField();
        JLabel documentoLabel = new JLabel("Documento:");
        documentoField = new JTextField();

        consultarButton = new JButton("Consultar");
        eliminarButton = new JButton("Eliminar");
        modificarButton = new JButton("Modificar");
        rregresarButton = new JButton("rregresar");

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarUsuario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarUsuario();
            }
        });
        
        rregresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rregresar();
            }
        });

        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(colorLabel);
        add(colorField);
        add(telefonoLabel);
        add(telefonoField);
        add(documentoLabel);
        add(documentoField);
        add(consultarButton);
        add(eliminarButton);
        add(modificarButton);
        add(rregresarButton);

        // Establece la conexión a la base de datos
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emisora", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarUsuario() {
        String id = idField.getText();

        try {
            // Realiza la consulta a la base de datos
            String query = "SELECT * FROM usuarios WHERE id_usuarios = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Actualiza los campos correspondientes con los datos del usuario encontrado
                nombreField.setText(resultSet.getString("nombre"));
                colorField.setText(resultSet.getString("color"));
                telefonoField.setText(resultSet.getString("telefono"));
                documentoField.setText(resultSet.getString("documento"));
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarUsuario() {
        String id = idField.getText();

        try {
            // Realiza la eliminación del usuario en la base de datos
            String query = "DELETE FROM usuarios WHERE id_usuarios = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Limpia los campos después de la eliminación
                nombreField.setText("");
                colorField.setText("");
                telefonoField.setText("");
                documentoField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  private void rregresar() {
    // Crea una instancia de la clase "Menu1"
    Menu1 menu = new Menu1();
    // Hace visible la ventana "Menu1"
    menu.setVisible(true);
    // Cierra la ventana actual (NewMain)
    this.dispose();
}


    private void modificarUsuario() {
        String id = idField.getText();
        String nuevoNombre = nombreField.getText();
        String nuevoColor = colorField.getText();
        String nuevoTelefono = telefonoField.getText();
        String nuevoDocumento = documentoField.getText();

        try {
            // Realiza la modificación del usuario en la base de datos
            String query = "UPDATE usuarios SET nombre = ?, color = ?, telefono = ?, documento = ? WHERE id_usuarios = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoColor);
            preparedStatement.setString(3, nuevoTelefono);
            preparedStatement.setString(4, nuevoDocumento);
            preparedStatement.setString(5, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NewMain usuarioManager = new NewMain();
                usuarioManager.setVisible(true);
            }
        });
    }
}
