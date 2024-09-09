package org.example.view;

import javax.swing.*;
import java.awt.*;

public class FileTablePanel extends JPanel {
    private JTable fileTable;
    private JButton uploadButton;

    public FileTablePanel() {
        setLayout(new BorderLayout());

        // Crear la tabla de archivos
        fileTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(fileTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Crear el botón de subida de archivos
        uploadButton = new JButton("Upload File");
        add(uploadButton, BorderLayout.SOUTH);
    }

    public JTable getFileTable() {
        return fileTable;
    }

    public JButton getUploadButton() {
        return uploadButton;
    }
}
