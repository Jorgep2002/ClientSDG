package org.example.controller;

import org.example.model.UserModel;
import org.example.shared.RMIInterfaces.AuthService;
import org.example.view.AppFrame;
import org.example.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class LoginController {
    private UserModel model;
    private LoginView view;
    private AuthService authService;  // Interfaz remota para autenticación
    private AppFrame appFrame;        // Referencia al frame principal

    public LoginController(UserModel model, LoginView view, AppFrame appFrame) {
        this.model = model;
        this.view = view;
        this.appFrame = appFrame;

        // Inicializar conexión RMI
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 6803);
            authService = (AuthService) registry.lookup("authService"); // Servicio de autenticación remoto
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

        // Agregar listener al botón de login
        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            // Lógica de autenticación usando RMI
            try {
                boolean isAuthenticated = authService.login(username, password);
                if (isAuthenticated) {
                    System.out.println("Login successful");

                    // Actualizar el modelo con los datos del usuario autenticado
                    model.setUsername(username);
                    model.setPassword(password);  // En un escenario real, no guardaríamos la contraseña en texto plano

                    // Cambiar a la vista principal
                    appFrame.showMain();
                } else {
                    view.displayErrorMessage("Invalid username or password");
                }
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
                view.displayErrorMessage("Connection error");
            }
        }
    }
}
