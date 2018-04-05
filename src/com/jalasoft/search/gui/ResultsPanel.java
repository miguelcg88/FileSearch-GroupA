package src.com.jalasoft.search.gui;

import javafx.scene.control.TableColumn;
import oracle.jrockit.jfr.JFR;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

//Class that creates results panel
public class ResultsPanel extends JPanel {

    private JTable resultsTable = new  JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private String data[][];
    private DefaultTableModel tableModel;

    public ResultsPanel()
    {
        initTableComponent();
    }

    // Initializes result panel
    public void initTableComponent() {
        String column[]={"FILE NAME","PATH","HIDDEN?","EXTENSION","SIZE MB"};
        tableModel= new DefaultTableModel(data, column);
        resultsTable = new JTable(tableModel);
        resultsTable.setBounds(30,40,200,300);
        scrollPane=new JScrollPane(resultsTable);
        setLayout(new BorderLayout());
        add(scrollPane);
        setBackground(Color.darkGray);
    }

    //Returns results table, this table is composed of 2 lists of stings
    public DefaultTableModel getResultsTable(){
        return tableModel;
    }
}

