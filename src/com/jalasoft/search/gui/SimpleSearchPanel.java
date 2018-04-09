/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */
package src.com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//Class that creates panel for simple search, it contains another panels that shows optoins to set search
public class SimpleSearchPanel extends JPanel {

    private  JPanel fileNamePanel;
    private  JPanel pathPanel;
    private  JPanel hiddenPanel;
    private  JPanel extensionPanel;
    private  JPanel sizePanel;
    private  JPanel simpleSearchPrincipalPanel;
    private JLabel simpleSearchPanelLabel;
    private JLabel fileNameLabel;
    private JLabel pathLabel;
    private JLabel hiddenLabel;
    private JLabel extensionLabel;
    private JLabel sizeLabel;
    private JTextField fileNameField;
    private JTextField pathNameField;
    private JCheckBox hiddenCheckbox ;
    private JComboBox<String> extensionComboBox;
    private JComboBox<String> sizeComboBox;
    private JButton browseButton;
    private MyFileChooser myFileChooser;

    //Class constructor, calls methods to make panels, each panel has a component and label
    public SimpleSearchPanel(){
        makeFileNamePanel();
        makePathPanel();
        makeHiddenPanel();
        makeExtensionPanel();
        //makeSizePanel();
        makePrincipalSimpleSearchPanel();
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

        /*fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }*/


        pathPanel.setLayout(new BoxLayout(pathPanel, BoxLayout.X_AXIS));
        pathPanel.add(pathLabel);
        pathPanel.add(pathNameField);
        pathPanel.add(browseButton);

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
        String[] extensionsList = { "All","txt","exe", "doc", "xls", "png", "zip" };
        extensionComboBox = new JComboBox(extensionsList);
        extensionPanel.setLayout(new BoxLayout(extensionPanel, BoxLayout.X_AXIS));
        extensionPanel.add(extensionLabel);
       extensionPanel.add(extensionComboBox);
    }
    //Panel that contains drop down to indicate  specific range for file size
    /*public void makeSizePanel(){
        sizePanel =new JPanel();
        sizeLabel = new JLabel("Select size range");
        String[] sizeRanges = { "Less than 1 MB", "1MB - 50MB ", "50MB - 500MB", "500MB - 1GB", "More than 1 GB" };
        sizeComboBox = new JComboBox(sizeRanges);
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeComboBox);
    }*/

    //Main Panel that contains all other panels,this will be called from main Frame to display "simple search" panel with all their components
    public void makePrincipalSimpleSearchPanel(){
        simpleSearchPrincipalPanel = new JPanel();
        simpleSearchPanelLabel = new JLabel("Enter your search criteria");
        simpleSearchPrincipalPanel.setLayout(new BoxLayout(simpleSearchPrincipalPanel, BoxLayout.Y_AXIS) );
        simpleSearchPrincipalPanel.add(simpleSearchPanelLabel);
        simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        simpleSearchPrincipalPanel.add(fileNamePanel);
        simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        simpleSearchPrincipalPanel.add(pathPanel);
        simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        simpleSearchPrincipalPanel.add(hiddenPanel);
        simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        simpleSearchPrincipalPanel.add(extensionPanel);
        //simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        //simpleSearchPrincipalPanel.add(sizePanel);
    }

    //get the value in file name field
    public String getFileNameField() {
        return fileNameField.getText();
    }

    //get the value in path name field
    public String getPathNameField() {
        return myFileChooser.getPath();
    }

    //get the value of hidden check box, return true or false
    public boolean getHiddenCheckbox() {
        return hiddenCheckbox.isSelected();
    }

    //get value selected in extension drop down
    public String getExtensionComboBox() {
        return String.valueOf(extensionComboBox.getSelectedItem());
    }

    //get value selected in size drop down
   /*public String getSizeComboBox() {
        return sizeComboBox.getSelectedItem().toString();
    }*/

    //get simple search panel with all components
    public  JPanel getSimpleSearchPrincipalPanel() {
        return simpleSearchPrincipalPanel;
    }
}

