package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;

public class AdvancedSearchPanel extends JPanel {


    private JPanel fileNamePanel;
    private  JPanel pathPanel;
    private  JPanel hiddenPanel;
    private  JPanel extensionPanel;
    private  JPanel sizePanel;
    private  JPanel advancedSearchPrincipalPanel;
    private JLabel advancedSearchLabel;
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

    //Class constructor, calls methods to make panels, each panel has a component and label
    public AdvancedSearchPanel(){
        makeFileNamePanel();
        makePathPanel();
        makeHiddenPanel();
        makeExtensionPanel();
        makeSizePanel();
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
    //Panel that contains textfiled to enter path for search
    public void makePathPanel(){
        pathPanel =new JPanel();
        pathLabel = new JLabel("Path");
        pathNameField = new JTextField (10);
        pathPanel.setLayout(new BoxLayout(pathPanel, BoxLayout.X_AXIS));
        pathPanel.add(pathLabel);
        pathPanel.add(pathNameField);
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
        String[] extensionsList = { "exe", "doc", "xls", "png", "zip" };
        extensionComboBox = new JComboBox(extensionsList);
        extensionPanel.setLayout(new BoxLayout(extensionPanel, BoxLayout.X_AXIS));
        extensionPanel.add(extensionLabel);
        extensionPanel.add(extensionComboBox);
    }
    //Panel that contains drop down to indicate  specific range for file size
    public void makeSizePanel(){
        sizePanel =new JPanel();
        sizeLabel = new JLabel("Select size range");
        String[] sizeRanges = { "Less than 1 MB", "1MB - 50MB ", "50MB - 500MB", "500MB - 1GB", "More than 1 GB" };
        sizeComboBox = new JComboBox(sizeRanges);
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeComboBox);
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
        add(hiddenPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(extensionPanel);
        add(Box.createRigidArea(new Dimension(0,6)));
        add(sizePanel);
    }

    /*public static void main(String[] args) {

        JFrame test = new JFrame();
        JPanel advanced = new AdvancedSearchPanel();
        test.setLayout(new BorderLayout());
        test.setPreferredSize(new Dimension(750,280));
        test.add(advanced,BorderLayout.CENTER);
        test.setVisible(true);
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/


}
