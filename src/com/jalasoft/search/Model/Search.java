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

    public Search(String path) {
        this.folderPath = path;
    }

    private String getFilePath() {
        return folderPath;
    }

    void doListFiles(){
         //Read file
        File file = new File(folderPath);

        //folderExist
        if (file.exists() == true) {
            //isDirectory
            if (file.isDirectory()==true){

                //doListFiles
                File list[]=file.listFiles();
                for(int i=0;i<list.length;i++){
                    System.out.println(list[i]);
                }
            }

        } else {
            System.out.println("the folder does not exist");
        }


    }

    //Only for testing purposes
    public  static void main(String args[]){
        Search search = new Search("C:\\Test");
        search.doListFiles();
    }
}
