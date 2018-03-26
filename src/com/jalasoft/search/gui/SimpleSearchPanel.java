package com.jalasoft.search.gui;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;

public class SimpleSearchPanel extends JPanel {


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
        JPanel principalPanel  = new JPanel();
        etiqueta1 = new JLabel("Demo por inforux");
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.Y_AXIS) );
        principalPanel.add(etiqueta1);
        principalPanel.add(panelSuperior);
        principalPanel.add(panelMedio);

    }

    public SimpleSearchPanel(){
        construyePanelSuperior();
        construyePanelMedio();
        construyeVentana();

    }



   /* public static void main (String [] args){
        new SimpleSearchPanel();
    } */
     public static void main (String [] args){
       JFrame test = new JFrame();
       JPanel simpleSearchPanel =  new SimpleSearchPanel();
       test.add(simpleSearchPanel);
       test.pack();
       test.setSize(300, 400);
       test.setVisible(true);
       test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}