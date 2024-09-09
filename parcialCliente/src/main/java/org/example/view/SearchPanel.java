package org.example.view;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private JTextField searchBar;
    private JMenuBar menuBar;

    public SearchPanel() {
        this.setLayout(new BorderLayout());

        searchBar = new JTextField(20);
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Search: "), BorderLayout.WEST);
        topPanel.add(searchBar, BorderLayout.CENTER);
        topPanel.add(menuBar, BorderLayout.NORTH);

        this.add(topPanel, BorderLayout.NORTH);
    }

    public JTextField getSearchBar() {
        return searchBar;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
