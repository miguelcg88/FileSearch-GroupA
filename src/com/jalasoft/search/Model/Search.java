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

public class Search {
    private String folderPath;
    private String fileNameToSearch;
    private Boolean isFound=Boolean.FALSE;
    private Boolean isHidden;
    private String extensionFile;
    private SearchCriteria searchCriteria;
    private ArrayList<File> shortList = new ArrayList<>();

    public Search() {
//          this.folderPath = ();
//        this.fileNameToSearch = searchCriteria.getFileName();
//        this.isHidden = searchCriteria.getHiddenFlag();
//        this.extensionFile = searchCriteria.getExtension();
    }
    public void setSearchCriteria(SearchCriteria sc) {
        this.searchCriteria = sc;
    }

    private String getFilePath() {
        return folderPath;
    }

    /**
     * This method is used to get a list of all files according  to a path and the hidden parameter.
     * If hidden is set as True, get all files that were hidden.
     * If hidden is set as False, get all files that were not hidden.
     * @param //folderPath this is the first parameter to show all files that are into this folder.
     * @param// isHiddem this is   the second parameter to show all files that are hidden.
     *                 By default it is as not checked.
     */
    public void searchByHiddenAttribute(){

        //Read file //folderPath
        File file = new File(this.searchCriteria.getFilePath());

        // clean list to new search
        shortList.clear();
        //doListFiles
        File list[]=file.listFiles();
        for(int i=0;i<list.length;i++){
            System.out.println(list[i].getName());
            //Show only not hidden files
            if (!this.searchCriteria.getHiddenFlag() && !list[i].isHidden()) {
                shortList.add(list[i]);
            }
            //Show only hidden files
            if (this.searchCriteria.getHiddenFlag() && list[i].isHidden()){
                shortList.add(list[i]);
            }
        }

        //Show short list
        System.out.println("*****SHORT LIST BY ATTRIBUTE HIDDEN->"+ this.searchCriteria.getHiddenFlag() +"********" );
        for (File temp : shortList) {
            System.out.println(temp.getName());
        }
        System.out.println("*****************SEARCH RESULT******************************");
        searchByName(shortList);
        System.out.println("*********************Extension " + "." + this.searchCriteria.getExtension() + " List******************");
        searchByExtension(shortList);
    }

    /**
     * This method is used to get all files that did match by a nameFile.
     * @param //fileNameToSearch this is the first parameter to search into a list of files.
     * @return  shortList This list to show only the files that are the same that the name file.
     */
    private void searchByName(ArrayList<File> shortList) {
        //SearchByName
        for(int j=0;j<shortList.size();j++){
            if (shortList.get(j).getName().equals(this.searchCriteria.getFileName() + "." + this.searchCriteria.getExtension())){
                System.out.println("The file-> "+shortList.get(j).getName()+" was found!");
                isFound = Boolean.TRUE;
                break;
            }
        }
        if(isFound == Boolean.FALSE){
            System.out.println("The file->"+ this.searchCriteria.getFileName() +" was not found!");
        }
    }

    public ArrayList<File> setResults(){
        return shortList;
    }

    /**
     * This method is used to get all files that did match by an extension.
     * @param //extensionFile this is the first parameter to search into a list of files.
     * @return  shortList This list to show only the files that are the same that the extension.
     */
    private void searchByExtension(ArrayList<File> shortList) {
        //SearchByExtension
        for(int j=0;j<shortList.size();j++){
            if (shortList.get(j).getName().endsWith("." + this.searchCriteria.getExtension())){
                System.out.println(shortList.get(j).getName());
            }
        }
    }

    //Only for testing purposes
   /* public  static void main(String args[]){
        System.out.println("*****************LIST OF FILES******************************");
        SearchCriteria sc = new SearchCriteria();
        sc.setFolderPath("\\Test");
        sc.setFileName("file8");
        sc.setExtension("jonas");
        sc.setHiddenFlag(false);

        Search search = new Search();
        search.setSearchCriteria(sc);
        search.searchByHiddenAttribute();
    }*/
}
