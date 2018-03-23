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
import java.io.IOException;

/*
*Description, the search.java class will search a specific file and then list all files/folders
* @version 1.0
* @author Jonas Aramayo
 */

public class Search {
    private String folderPath;
    private String fileNameToSearch;
    private Boolean isFound=Boolean.FALSE;


    public Search(String path, String fileName) {
        this.folderPath = path;
        this.fileNameToSearch = fileName;
    }

    private String getFilePath() {
        return folderPath;
    }

    public void doListFiles(){
         //Read file
        File file = new File(folderPath);

        //doListFiles
        File list[]=file.listFiles();
        for(int i=0;i<list.length;i++){
                 System.out.println(list[i].getName());
        }
    }

    public void searchByFileName(){

        File file = new File(folderPath);
        //SearchIntoFolder
        File list[]=file.listFiles();
        for(int j=0;j<list.length;j++){
            if (list[j].getName().equals(fileNameToSearch)){
                System.out.println("The file-> "+list[j].getName()+" was found!");
                isFound = Boolean.TRUE;
                break;
            }
        }
        if(isFound == Boolean.FALSE){
            System.out.println("The file->"+ fileNameToSearch +" was not found!");
        }
    }

    //Only for testing purposes
    public  static void main(String args[]){
        Search search = new Search("\\Test", "test3.txt");
        search.doListFiles();
        search.searchByFileName();
    }
}
