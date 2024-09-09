package org.example.view;

import javax.swing.*;
import java.awt.*;

public class DirectoryTreePanel extends JPanel {
    private JTree directoryTree;

    public DirectoryTreePanel() {
        this.setLayout(new BorderLayout());
        directoryTree = new JTree();
        JScrollPane treeScrollPane = new JScrollPane(directoryTree);
        this.add(treeScrollPane, BorderLayout.CENTER);
    }

    public JTree getDirectoryTree() {
        return directoryTree;
    }
}
