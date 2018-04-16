/*
 * Search .java *
 * Copyright (c) 2018 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package src.com.jalasoft.search.model;

import java.io.File;
import java.util.ArrayList;
import src.com.jalasoft.search.model.SearchCriteria;

/*
 *Description, the search.java class will search a specific file and then list all files/folders
 * This class can search by four fields:
 * 1. PATH
 * 2. FILE NAME
 * 3. EXTENSION
 * 4. HIDDEN
 * @version 1.0
 * @author Jonas Aramayo
 */

public class SearchModel {
    private String folderPath;
    private String fileNameToSearch;
    private Boolean isFound=Boolean.FALSE;
    private Boolean isHidden;
    private String extensionFile;
    private SearchCriteria searchCriteria;
    private ArrayList<File> shortList = new ArrayList<>();
    private ArrayList<FileSearch> LongList = new ArrayList<>();

    public void setSearchCriteria(SearchCriteria sc) {
        this.searchCriteria = sc;
    }

    private String getFilePath() {
        String path = (this.searchCriteria.getFilePath()==null || this.searchCriteria.getFilePath()==""
        )? "C:\\Test" : this.searchCriteria.getFilePath() ;
        return path;
    }

    public Boolean searchByHiddenAttribute(File file){
        if (this.searchCriteria.getHiddenFlag() == true) {
            return true;
        }
        else{
            if(this.searchCriteria.getHiddenFlag() == file.isHidden()) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    //searchByName
    public Boolean searchByName(File file){
        String nameText = file.getName().replaceFirst("[.][^.]+$", "");
        if (this.searchCriteria.getFileName() == null || this.searchCriteria.getFileName() == "") {
            return true;
        }
        else{
            if(nameText.startsWith(this.searchCriteria.getFileName())){
                return true;
            }
            else{
                return false;
            }
        }
    }

    //searchByExtension
    public Boolean searchByExtension(File file){
        String compuseExtension = file.getName().substring(file.getName().lastIndexOf(".")+1);
        System.out.println(compuseExtension+"="+this.searchCriteria.getExtension());
        if (this.searchCriteria.getExtension() == null || this.searchCriteria.getExtension() == "All") {
            return true;
        }
        else{
            if(this.searchCriteria.getExtension().startsWith(compuseExtension)){
                return true;
            }
            else{
                return false;
            }
        }
    }

    //Search By All Filters
    public void searchByFilters(){
        //Read file //folderPath
        File file = new File(getFilePath());
        //FileSearch fileSearch = new FileSearch(getFilePath());

        // clean list to new search
        shortList.clear();
        LongList.clear();

        //doListFiles
        File list[]=file.listFiles();
        for(int i=0;i<list.length;i++) {
            System.out.println(list[i].getName());
            System.out.println(searchByHiddenAttribute(list[i])+"/"+searchByName(list[i])+"/"+searchByExtension(list[i])+"**");
            if(searchByHiddenAttribute(list[i])==true && searchByName(list[i])==true
                    && searchByExtension(list[i])==true){
                shortList.add(list[i]);
            }
        }
    }

    public ArrayList<File> setResults(){
        return shortList;
    }
}