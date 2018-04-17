
package src.com.jalasoft.search.gui;
        /*
        * MainFileSearch.java  1.0  3/16/2018
        * Copyright (c) 2018  Jalasoft
        * All rights reserved.
        *Author : Miguel Calderon
        */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

//Creates panel for advanced search, extend from JPanel

public class AdvancedSearchPanel extends JPanel {


    private JPanel fileNamePanel;
    private  JPanel hiddenPanel;
    private  JPanel extensionPanel;
    private  JPanel containsPanel;
    private  JPanel dateAddedPanel;
    private  JPanel dateModifiedPanel;
    private  JPanel createdByPanel;
    private  JPanel pathPanel;
    private JLabel advancedSearchLabel;
    private JLabel fileNameLabel;
    private JLabel hiddenLabel;
    private JLabel extensionLabel;
    private JLabel containsLabel;
    private JLabel dateAddedFromLabel;
    private JLabel dateAddedToLabel;
    private JLabel dateModifiedFromLabel;
    private JLabel dateModifiedToLabel;
    private JLabel createdByLabel;
    private JLabel pathLabel;
    private JTextField fileNameField;
    private JTextField dateAddedFromField;
    private JTextField dateAddedToField;
    private JTextField dateModifiedFromField;
    private JTextField dateModifiedToField;
    private JTextField containsField;
    private JTextField createdByField;
    private JTextField pathNameField;
    private JCheckBox hiddenCheckbox ;
    private JComboBox extensionComboBox;
    private JButton browseButton;
    private MyFileChooser myFileChooser;





    //Class constructor, calls methods to make panels, each panel has a component and label
    public AdvancedSearchPanel(){
        makeFileNamePanel();
        makePathPanel();
        makeDateAddedPanel();
        makeDateModifiedPanel();
        makeHiddenPanel();
        makeExtensionPanel();
        makeContainsPanel();
        makeCreatedByPanel();
        makePrincipalAdvancedSearchPanel();
    }
    //Panel that contains textfiled to enter file name for search
    public void makeFileNamePanel(){
        fileNamePanel =new JPanel();
        fileNameLabel = new JLabel("File Name");
        fileNameField = new JTextField(10);
        fileNamePanel.setLayout(new BoxLayout(fileNamePanel, BoxLayout.X_AXIS));
        fileNamePanel.add(fileNameLabel);
        fileNamePanel.add(fileNameField);
    }

    //Panel that contains fields to set added dates
    public void makeDateAddedPanel(){
        dateAddedPanel =new JPanel();
        dateAddedFromLabel = new JLabel("Date created from (yyyy-dd-MM):");
        dateAddedFromField = new JTextField (10);
        dateAddedToLabel = new JLabel("To:");
        dateAddedToField = new JTextField (10);
        dateAddedPanel.setLayout(new BoxLayout(dateAddedPanel, BoxLayout.X_AXIS));
        dateAddedPanel.add(dateAddedFromLabel);
        dateAddedPanel.add(dateAddedFromField);
        dateAddedPanel.add(dateAddedToLabel);
        dateAddedPanel.add(dateAddedToField);
    }

    //Panel that contains fields to set modify dates
    public void makeDateModifiedPanel(){
        dateModifiedPanel =new JPanel();
        dateModifiedFromLabel = new JLabel("Date modified from (yyyy-dd-MM):");
        dateModifiedFromField = new JTextField (10);
        dateModifiedToLabel = new JLabel("To:");
        dateModifiedToField = new JTextField (10);
        dateModifiedPanel.setLayout(new BoxLayout(dateModifiedPanel, BoxLayout.X_AXIS));
        dateModifiedPanel.add(dateModifiedFromLabel);
        dateModifiedPanel.add(dateModifiedFromField);
        dateModifiedPanel.add(dateModifiedToLabel);
        dateModifiedPanel.add(dateModifiedToField);
    }


    //Panel that contains checbox to indicate if user wants to include hidden files or not in search
    public void makeHiddenPanel(){
        hiddenPanel =new JPanel();
        hiddenLabel = new JLabel("Show Hidden                                         ");
        hiddenCheckbox = new JCheckBox();
        hiddenPanel.setLayout(new BoxLayout(hiddenPanel, BoxLayout.X_AXIS));
        hiddenPanel.add(hiddenLabel);
        hiddenPanel.add(hiddenCheckbox);
    }
    //Panel that contains drop down to indicate  specific file extension in search
    public void makeExtensionPanel(){
        extensionPanel =new JPanel();
        extensionLabel = new JLabel("Select extension");
        String[] extensionsList = { "All","exe", "doc", "xls", "png", "zip" };
        extensionComboBox = new JComboBox(extensionsList);
        extensionPanel.setLayout(new BoxLayout(extensionPanel, BoxLayout.X_AXIS));
        extensionPanel.add(extensionLabel);
        extensionPanel.add(extensionComboBox);
    }


    //Panel that contains textfiled to keywords that contains a text file, to search inside of it
    public void makeContainsPanel(){
        containsPanel = new JPanel();
        containsLabel = new JLabel("Contains");
        containsField = new JTextField(10);
        containsPanel.setLayout(new BoxLayout(containsPanel, BoxLayout.X_AXIS));
        containsPanel.add(containsLabel);
        containsPanel.add(containsField);
    }

    //Panel that contains drop down to indicate  specific  user that created a file
    public void makeCreatedByPanel(){
        createdByPanel = new JPanel();
        createdByLabel = new JLabel("Created by");
        createdByField = new JTextField(10);
        createdByPanel.setLayout(new BoxLayout(createdByPanel, BoxLayout.X_AXIS));
        createdByPanel.add(createdByLabel);
        createdByPanel.add(createdByField);
    }

    //Panel that contains textfiled to enter path for search
    public void makePathPanel(){
        pathPanel =new JPanel();
        pathLabel = new JLabel("Path");
        pathNameField = new JTextField (10);
        browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFileChooser = new MyFileChooser();
                pathNameField.setText(myFileChooser.getPath());
            }
        });
        pathPanel.setLayout(new BoxLayout(pathPanel, BoxLayout.X_AXIS));
        pathPanel.add(pathLabel);
        pathPanel.add(pathNameField);
        pathPanel.add(browseButton);

    }



    //Main Panel that contains all other panels,this will be called from main Frame to display "simple search" panel with all their components
    public void makePrincipalAdvancedSearchPanel(){
        //advancedSearchPrincipalPanel = new JPanel();
        advancedSearchLabel = new JLabel("Enter your search criteria");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS) );
        add(advancedSearchLabel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(fileNamePanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(pathPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(dateAddedPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(dateModifiedPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(hiddenPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(extensionPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(containsPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(createdByPanel);

    }




    //get the value in file name field
    public String getFileNameField() {
        return fileNameField.getText();
    }

   public String getPathNameField() {
       return myFileChooser.getPath();
   }

    //get date created from
    public String getCreatedDateFrom() {
        return dateAddedFromField.getText();
    }
    //get date created to
    public String getCreatedDateTo() {
        return dateAddedToField.getText();
    }

    //get date modified from
    public String getModifiedDateFrom() {
        return dateModifiedFromField.getText();
    }
    //get date modified to
    public String getModifiedDateTo() {
        return dateModifiedToField.getText();
    }
    //get text on contains textfield
    public String getContainsText() {
        return containsField.getText();
    }
    //get text on created by textfield
    public String getCreatedByText() {
        return createdByField.getText();
    }
    //get the value of hidden check box, return true or false
    public boolean getHiddenCheckbox() {
        return hiddenCheckbox.isSelected();
    }

    //get value selected in extension drop down
    public String getExtensionComboBox() {
        return String.valueOf(extensionComboBox.getSelectedItem());
    }


   /* public static void main(String[] args) {


        JFrame test = new JFrame();
        JPanel advanced = new AdvancedSearchPanel();
        test.setLayout(new BorderLayout());
        test.setPreferredSize(new Dimension(750,280));
        test.add(advanced,BorderLayout.CENTER);
        test.pack();

        test.setVisible(true);
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/



}

