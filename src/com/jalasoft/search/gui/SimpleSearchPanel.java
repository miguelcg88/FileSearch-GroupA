package com.jalasoft.search.gui;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class SimpleSearchPanel extends JFrame {


    private JPanel panelSuperior, panelMedio;
    private JLabel etiqueta1, pathLabel, etiqueta3;
    private JTextField cajaTexto;
    private JTextField cajaPass;


    public void construyePanelSuperior(){
        panelSuperior =new JPanel();
        pathLabel = new JLabel("Path");
        cajaTexto = new JTextField(10);
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        panelSuperior.add(pathLabel);
        panelSuperior.add(cajaTexto);
    }

    public void construyePanelMedio(){
        panelMedio=new JPanel();
        etiqueta3= new JLabel("File Name");
        cajaPass = new JTextField (10);
        panelMedio.setLayout(new BoxLayout(panelMedio, BoxLayout.X_AXIS));
        panelMedio.add(etiqueta3);
        panelMedio.add(cajaPass);
    }


    public void construyeVentana(){
        SimpleSearchPanel = new JFrame();
        etiqueta1 = new JLabel("Demo por inforux");
        SimpleSearchPanel.setLayout(new BoxLayout(SimpleSearchPanel.getContentPane(), BoxLayout.Y_AXIS) );
        SimpleSearchPanel.add(etiqueta1);
        SimpleSearchPanel.add(panelSuperior);
        SimpleSearchPanel.add(panelMedio);
        SimpleSearchPanel.pack();
        SimpleSearchPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SimpleSearchPanel.setVisible(true);
    }

    public SimpleSearchPanel(){
        construyePanelSuperior();
        construyePanelMedio();
        construyeVentana();
    }

    public static void main (String [] args){
        new SimpleSearchPanel();
    }
}