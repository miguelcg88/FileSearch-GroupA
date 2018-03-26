package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;


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
    private JComboBox extensionComboBox;
    private JComboBox sizeComboBox;

    public void makeFileNamePanel(){
        fileNamePanel =new JPanel();
        fileNameLabel = new JLabel("File Name");
        fileNameField = new JTextField(10);
        fileNamePanel.setLayout(new BoxLayout(fileNamePanel, BoxLayout.X_AXIS));
        fileNamePanel.add(fileNameLabel);
        fileNamePanel.add(fileNameField);

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
        hiddenPanel.setLayout(new BoxLayout(hiddenPanel, BoxLayout.X_AXIS));
        hiddenPanel.add(hiddenLabel);
        hiddenPanel.add(hiddenCheckbox);

    }

    public void makeExtensionPanel(){
        extensionPanel =new JPanel();
        extensionLabel = new JLabel("Select extension");
        extensionComboBox = new JComboBox<>();
        extensionPanel.setLayout(new BoxLayout(extensionPanel, BoxLayout.X_AXIS));
        extensionPanel.add(extensionLabel);
        extensionPanel.add(extensionComboBox);

    }

    public void makeSizePanel(){
        sizePanel =new JPanel();
        sizeLabel = new JLabel("Select size range");
        extensionComboBox = new JComboBox<>();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.add(sizeLabel);
        sizePanel.add(extensionComboBox);

    }


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
        simpleSearchPrincipalPanel.add(Box.createRigidArea(new Dimension(0,6)));
        simpleSearchPrincipalPanel.add(sizePanel);

    }

    public SimpleSearchPanel(){
        makeFileNamePanel();
        makePathPanel();
        makeHiddenPanel();
        makeExtensionPanel();
        makeSizePanel();
        makePrincipalSimpleSearchPanel();

    }

    public  JPanel getSimpleSearchPrincipalPanel() {
        return simpleSearchPrincipalPanel;
    }

}