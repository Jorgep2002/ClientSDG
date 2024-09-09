package org.example.controller;

import org.example.model.FileModel;
import org.example.view.MainView;
import org.example.view.FileTablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileController {
    private FileModel fileModel;
    private MainView mainView;

    public FileController(FileModel fileModel, MainView mainView) {
        this.fileModel = fileModel;
        this.mainView = mainView;

        // Obtener el panel de la tabla de archivos que ya contiene el botón
        FileTablePanel fileTablePanel = mainView.getFileTablePanel();
        JButton uploadButton = fileTablePanel.getUploadButton();

        // Agregar listener al botón existente de subida de archivos
        uploadButton.addActionListener(new UploadListener());
    }

    class UploadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                boolean success = fileModel.uploadFile(file);
                if (success) {
                    JOptionPane.showMessageDialog(mainView, "File uploaded successfully!");
                } else {
                    JOptionPane.showMessageDialog(mainView, "Failed to upload file.");
                }
            }
        }
    }
}
