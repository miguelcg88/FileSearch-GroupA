package src.com.jalasoft.search.gui;

import javax.swing.JFileChooser;

public class MyFileChooser {

    private String path;

    public MyFileChooser(){
        makeMyFileChooser();
    }

    public void makeMyFileChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path  = (chooser.getCurrentDirectory()).toString();

        } else {
            path = "Empty";
        }
    }

    public String getPath(){
        return path;
    }
}