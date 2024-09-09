package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");

    public LoginView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Username: "), gbc);

        gbc.gridx = 1;
        this.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        this.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(loginButton, gbc);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
