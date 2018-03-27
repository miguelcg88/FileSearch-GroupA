/*
* Search .java *
* Copyright (c) 2018 Jalasoft.
* This software is the confidential and proprietary information of Jalasoft.
* ("Confidential Information"). You shall not
* disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Jalasoft.
*/

package com.jalasoft.search.Model;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/*
*Description, the search.java class will search a specific file and then list all files/folders
* @version 1.0
* @author Jonas Aramayo
 */

public class Search {
    private String folderPath;
    private String fileNameToSearch;
    private Boolean isFound=Boolean.FALSE;
    private Boolean isHidden;
    private String extensionFile;

    public Search(String path, String fileName, Boolean hidden, String extension) {
        this.folderPath = path;
        this.fileNameToSearch = fileName + "." + extension;
        this.isHidden = hidden;
        this.extensionFile = extension;
    }

    private String getFilePath() {
        return folderPath;
    }

    public void doListFiles(){
        ArrayList<String> shortList = new ArrayList<>();
                //Read file
        File file = new File(folderPath);

        //doListFiles
        File list[]=file.listFiles();
        for(int i=0;i<list.length;i++){
            System.out.println(list[i].getName());
            //Show only not hidden files
            if (this.isHidden.equals(false) && !list[i].isHidden()) {
                if (getFileExtension(list[i]).equals(extensionFile)) {
                    shortList.add(list[i].getName());
                }
            }
            //Show only hidden files
            if (this.isHidden.equals(true) && list[i].isHidden()){
                if (getFileExtension(list[i]).equals(extensionFile)) {
                    shortList.add(list[i].getName());
                }
            }
        }

        //Show short list
        /*System.out.println("*****SHORT LIST********");
        for (String temp : shortList) {
            System.out.println(temp);
        }*/
        System.out.println("*****************SEARCH RESULT******************************");
        searchByName(shortList);
    }

    private void searchByName(ArrayList<String> shortList) {
        //SearchByName
        for(int j=0;j<shortList.size();j++){
            if (shortList.get(j).equals(fileNameToSearch)){
                System.out.println("The file-> "+shortList.get(j)+" was found!");
                isFound = Boolean.TRUE;
                break;
            }
        }

        if(isFound == Boolean.FALSE){
            System.out.println("The file->"+ fileNameToSearch +" was not found!");
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    //Only for testing purposes
    public  static void main(String args[]){
        Search search = new Search("\\Test", "file8", false, "jonas");
        System.out.println("*****************LIST OF FILES******************************");
        search.doListFiles();
    }
}
