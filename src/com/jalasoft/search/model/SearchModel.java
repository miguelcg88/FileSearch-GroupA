package com.jalasoft.search.model;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchModel {
    public void ListFileByPath(String path){ //inputs path, file name, etc
        File files = new File(path);
        File[] listOfFiles = files.listFiles();
        for (File file : listOfFiles){
            if(file.isFile()) {
                //Variables
                SimpleDateFormat lastModifiedDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Long space = file.getTotalSpace();
                double spaceMb = space/1000000;
                double bytes = file.length();
                double fileLength = ((bytes / 1024) / 1024);


                //Print file
                System.out.println("Name: " + file.getName());
                System.out.println("Total Space (Mb):" + spaceMb);
                System.out.println("Is Directory?: " + file.isDirectory());
                System.out.println("Last Modified Date: " + lastModifiedDateFormat.format(file.lastModified()));
                System.out.println("Length (Mb): " + fileLength);
                System.out.println("Extension: " + getFileExtension(file));
                System.out.println("-------------------");
            }
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
