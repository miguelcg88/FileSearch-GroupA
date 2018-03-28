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
import com.jalasoft.search.Controller.SearchCriteria;

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
    /*public Search(SearchCriteria sc) {
        this.folderPath = sc.path;
        this.fileNameToSearch = sc.fileName + "." + sc.extension;
        this.isHidden = sc.hidden;
        this.extensionFile = sc.extension;
    }*/

    private String getFilePath() {
        return folderPath;
    }

    public void searchByHiddenAttribute(){
        ArrayList<File> shortList = new ArrayList<>();
        //Read file
        File file = new File(folderPath);

        //doListFiles
        File list[]=file.listFiles();
        for(int i=0;i<list.length;i++){
            System.out.println(list[i].getName());
            //Show only not hidden files
            if (this.isHidden.equals(false) && !list[i].isHidden()) {
                shortList.add(list[i]);
            }
            //Show only hidden files
            if (this.isHidden.equals(true) && list[i].isHidden()){
                shortList.add(list[i]);
            }
        }

        //Show short list
        System.out.println("*****SHORT LIST BY ATTRIBUTE HIDDEN->"+ this.isHidden +"********" );
        for (File temp : shortList) {
            System.out.println(temp.getName());
        }
        System.out.println("*****************SEARCH RESULT******************************");
        searchByName(shortList);
        System.out.println("*********************Extension " + "." + this.extensionFile + " List******************");
        searchByExtension(shortList);
    }

    private void searchByName(ArrayList<File> shortList) {
        //SearchByName
        for(int j=0;j<shortList.size();j++){
            if (shortList.get(j).getName().equals(fileNameToSearch)){
                System.out.println("The file-> "+shortList.get(j).getName()+" was found!");
                isFound = Boolean.TRUE;
                break;
            }
        }
        if(isFound == Boolean.FALSE){
            System.out.println("The file->"+ fileNameToSearch +" was not found!");
        }
    }

    private void searchByExtension(ArrayList<File> shortList) {
        //SearchByExtension
        for(int j=0;j<shortList.size();j++){
            if (shortList.get(j).getName().endsWith("." + this.extensionFile)){
                System.out.println(shortList.get(j).getName());
            }
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
        search.searchByHiddenAttribute();
    }

    /*private class SearchCriteria {
        private String path, extension, fileName;
        private Boolean hidden;

        private SearchCriteria(String pPath, String pFileName, Boolean pHidden, String pExtension){
            this.path = pPath;
            this.extension = pExtension;
            this.fileName = pFileName;
            this.hidden = pHidden;
        }
    }*/
}
