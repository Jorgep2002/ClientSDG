package org.example;

import org.example.controller.FileController;
import org.example.controller.LoginController;
import org.example.model.FileModel;
import org.example.model.UserModel;
import org.example.shared.RMIInterfaces.AuthService;
import org.example.shared.RMIInterfaces.FileService;
import org.example.view.AppFrame;
import org.example.view.LoginView;
import org.example.view.MainView;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class Main {
    public static void main(String[] args) {
        AppFrame appFrame = new AppFrame();

        LoginView loginView = appFrame.getLoginView();
        MainView mainView = appFrame.getMainView();

        UserModel userModel = new UserModel("", "");
        FileModel fileModel = null;

        AuthService authService = null;
        FileService fileService = null;

        try {
            String authServiceUri = "//localhost:6803/authService";
            authService = (AuthService) Naming.lookup(authServiceUri);

            String fileServiceUri = "//localhost:6802/fileService";
            fileService = (FileService) Naming.lookup(fileServiceUri);

            fileModel = new FileModel(fileService);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        LoginController loginController = new LoginController(userModel, loginView, appFrame);
        if (fileModel != null) {
            new FileController(fileModel, mainView);
        }

        appFrame.showLogin();
        appFrame.setVisible(true);
    }
}
