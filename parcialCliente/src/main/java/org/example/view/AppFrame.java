package org.example.view;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel  container = new JPanel(cardLayout);
    private LoginView loginView;
    private MainView mainView;
    private FileUploadPanel fileUploadPanel;

    public AppFrame() {
        loginView = new LoginView();
        mainView = new MainView();
        fileUploadPanel = new FileUploadPanel();

        container.add(loginView, "login");
        container.add(mainView, "main");
        container.add(fileUploadPanel, "upload");

        this.add(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
    }

    public void showLogin() {
        cardLayout.show(container, "login");
    }

    public void showMain() {
        cardLayout.show(container, "main");
    }

    public void showFileUpload() {
        cardLayout.show(container, "upload");
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public MainView getMainView() {
        return mainView;
    }

    public FileUploadPanel getFileUploadPanel() {
        return fileUploadPanel;
    }
}
