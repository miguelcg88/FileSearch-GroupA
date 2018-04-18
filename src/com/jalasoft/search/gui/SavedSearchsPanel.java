package src.com.jalasoft.search.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SavedSearchsPanel extends JPanel {

    private JTable savedSearchsTable = new  JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private String data[][];
    private DefaultTableModel tableModel;

    public SavedSearchsPanel()
    {
        initTableComponent();
    }

    // Initializes result panel
    public void initTableComponent() {
        String column[]={"FILE NAME","PATH7887","HIDDEN?","EXTENSION","SIZE MB"};
        tableModel= new DefaultTableModel(data, column);
        savedSearchsTable = new JTable(tableModel);
        savedSearchsTable.setBounds(30,40,200,300);
        scrollPane=new JScrollPane(savedSearchsTable);
        setLayout(new BorderLayout());
        add(scrollPane);
        setBackground(Color.darkGray);
    }

}
