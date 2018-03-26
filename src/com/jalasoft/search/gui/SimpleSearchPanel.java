package com.jalasoft.search.gui;

import javax.swing.*;


public class SimpleSearchPanel extends JPanel {


    private  JPanel FileNamePanel;
    private  JPanel pathPanel;
    private  JPanel hiddenPanel;
    private  JPanel principalPanel;
    private JLabel simpleSearchPanelLabel;
    private JLabel fileNameLabel;
    private JLabel pathLabel;
    private JLabel hiddenLabel;
    private JTextField fileNameField;
    private JTextField pathNameField;
    private JCheckBox hiddenCheckbox ;

    public void makeFileNamePanel(){
        FileNamePanel =new JPanel();
        fileNameLabel = new JLabel("File Name");
        fileNameField = new JTextField(10);
        FileNamePanel.setLayout(new BoxLayout(FileNamePanel, BoxLayout.X_AXIS));
        FileNamePanel.add(fileNameLabel);
        FileNamePanel.add(fileNameField);

    }

    public void makePathPanel(){
        pathPanel =new JPanel();
        pathLabel = new JLabel("Path");
        pathNameField = new JTextField (10);
        pathPanel.setLayout(new BoxLayout(pathPanel, BoxLayout.X_AXIS));
        pathPanel.add(pathLabel);
        pathPanel.add(pathNameField);


    }

    public void makeHiddenPanel(){
        hiddenPanel =new JPanel();
        hiddenLabel = new JLabel("Show Hidden");
        hiddenCheckbox = new JCheckBox();
        hiddenPanel.setLayout(new BoxLayout(hiddenLabel, BoxLayout.X_AXIS));
        hiddenPanel.add(hiddenLabel);
        hiddenPanel.add(hiddenCheckbox);

    }


    public void makePrincipalSimpleSearchPanel(){
        principalPanel  = new JPanel();
        simpleSearchPanelLabel = new JLabel("Enter your search criteria");
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.Y_AXIS) );
        principalPanel.add(simpleSearchPanelLabel);
        principalPanel.add(FileNamePanel);
        principalPanel.add(pathPanel);
        principalPanel.add(hiddenPanel);

    }

    public SimpleSearchPanel(){
        makeFileNamePanel();
        makePathPanel();
        makeHiddenPanel();
        makePrincipalSimpleSearchPanel();

    }

    public  JPanel getPrincipalPanel() {
        return principalPanel;
    }

}