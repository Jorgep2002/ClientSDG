package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    private DirectoryTreePanel directoryTreePanel;
    private FileTablePanel fileTablePanel;
    private SearchPanel searchPanel;

    public MainView() {
        this.setLayout(new BorderLayout());

        directoryTreePanel = new DirectoryTreePanel();
        fileTablePanel = new FileTablePanel();
        searchPanel = new SearchPanel();

        this.add(directoryTreePanel, BorderLayout.WEST);
        this.add(fileTablePanel, BorderLayout.CENTER);
        this.add(searchPanel, BorderLayout.NORTH);
    }

    // Método para obtener el panel de la tabla de archivos
    public FileTablePanel getFileTablePanel() {
        return fileTablePanel;
    }

    // Otros métodos de la vista
    public JTree getDirectoryTree() {
        return directoryTreePanel.getDirectoryTree();
    }

    public JTable getFileTable() {
        return fileTablePanel.getFileTable();
    }

    public JTextField getSearchBar() {
        return searchPanel.getSearchBar();
    }

    public JMenuBar getMenuBar() {
        return searchPanel.getMenuBar();
    }
}
