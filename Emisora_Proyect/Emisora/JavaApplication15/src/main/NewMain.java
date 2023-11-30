/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMain extends JFrame implements ActionListener {
    private JLabel userLabel, passwordLabel, messageLabel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public NewMain() {
        setTitle("Inicio de Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Usuario:");
        passwordLabel = new JLabel("Contraseña:");
        userField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Iniciar Sesión");
        messageLabel = new JLabel("");

        loginButton.addActionListener(this);

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(messageLabel);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        // Aquí puedes verificar las credenciales (por ejemplo, en una base de datos)
        // En este ejemplo, simplemente comparamos con valores fijos.
        if (username.equals("usuario") && password.equals("contraseña")) {
            messageLabel.setText("Inicio de sesión exitoso");
        } else {
            messageLabel.setText("Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NewMain loginForm = new NewMain();
                loginForm.setVisible(true);
            }
        });
    }
}

