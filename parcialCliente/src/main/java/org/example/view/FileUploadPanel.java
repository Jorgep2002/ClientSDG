package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class FileUploadPanel extends JPanel {
    private JButton selectFileButton;
    private JButton uploadButton;
    private JFileChooser fileChooser;
    private File selectedFile;

    public FileUploadPanel() {
        this.setLayout(new FlowLayout());

        selectFileButton = new JButton("Select File");
        uploadButton = new JButton("Upload");
        fileChooser = new JFileChooser();

        this.add(selectFileButton);
        this.add(uploadButton);

        // Inicializar la selección de archivo
        selectFileButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
        });
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void addSelectFileListener(ActionListener listener) {
        selectFileButton.addActionListener(listener);
    }

    public void addUploadListener(ActionListener listener) {
        uploadButton.addActionListener(listener);
    }
}
