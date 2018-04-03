package com.jalasoft.search.gui;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
//Class that creates results panel
public class ResultsPanel extends JPanel {

    private JTable resultsTable = new  JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private String data[][];


    public ResultsPanel(){
        makeResultsPanel();
    }
    // Initializes result panel
    public void makeResultsPanel() {

        //String data[][]={ {"101","Amit","670000","zip","32"},
                //{"102","Jai","780000","exe","3"},
                //{"101","Sachin","700000","xls","12"}};
        String column[]={"FILE NAME","PATH","HIDDEN?","EXTENSION","SIZE MB"};
        resultsTable = new JTable(data,column);
        resultsTable.setBounds(30,40,200,300);
        scrollPane=new JScrollPane(resultsTable);
        setLayout(new BorderLayout());
        add(scrollPane);
        setBackground(Color.darkGray);
    }
    //Returns results table, this table is composed of 2 lists of stings
    public JTable getResultsTable(){
        return resultsTable;
    }

    public void setResults(String data[][]) {
     this.data = data;
    }

}

