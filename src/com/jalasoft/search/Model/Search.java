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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.jalasoft.search.Model.Asset;
import com.jalasoft.search.Model.FactoryAsset;
import src.com.jalasoft.search.model.SearchCriteria;

import javax.tools.FileObject;

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
    private SearchCriteria searchCriteria;
    private ArrayList<Asset> shortList = new ArrayList<Asset>();
    private Asset asset;

    public Search() {

    }
    public void setSearchCriteria(SearchCriteria sc) {
        this.searchCriteria = sc;
    }

    /**
     * This method is used to get a list of all files according  to a path and the hidden parameter.
     * If hidden is set as True, get all files that were hidden.
     * If hidden is set as False, get all files that were not hidden.
     * @param folderPath this is the first parameter to show all files that are into this folder.
     * @param isHiddem this is   the second parameter to show all files that are hidden.
     *                 By default it is as not checked.
     */
    private ArrayList<Asset> searchByHiddenAttributeSetAsFalse(ArrayList<Asset> shortList){
        //Search all no hidden files
        ArrayList<Asset>  listByHiddenAttributeSetAsFalse = new ArrayList<>();
        for(Asset f: shortList){
            if (!f.getHiddenFlag()){
                System.out.println(f.getFileName() + "FOUND NOT HIDDEN FILEs");
                listByHiddenAttributeSetAsFalse.add(f);
            }
        }
        return listByHiddenAttributeSetAsFalse;
    }

    private ArrayList<Asset> searchByHiddenAttributeSetAsTrue(ArrayList<Asset> shortList){
        //Search all no hidden files
        ArrayList<Asset>  listByHiddenAttributeSetAsTrue = new ArrayList<>();
        for(Asset f: shortList){
            if (f.getHiddenFlag()){
                System.out.println(f.getFileName() + "FOUND HIDDEN FILEs");
                listByHiddenAttributeSetAsTrue.add(f);
            }
        }
        return listByHiddenAttributeSetAsTrue;
    }

    /**
     * This method is used to get all files that did match by a nameFile.
     */
    private ArrayList<Asset> searchByName(String fileName, ArrayList<Asset> shortList) {
        //SearchByName
        ArrayList<Asset>  listByName = new ArrayList<>();
        for(Asset f: shortList){
            System.out.println(f.getFileName() +"-----");
            if (f.getFileName().contains(fileName)){
                System.out.println(f.getFileName() + "FOUND");
                listByName.add(f);
            }
        }
        return listByName;
    }

    /**
     * This method is used to get all files that did match by an extension.
     * @param //extensionFile this is the first parameter to search into a list of files.
     * @return  shortList This list to show only the files that are the same that the extension.
     */
    private ArrayList<Asset> searchByExtension(String extension, ArrayList<Asset> shortList) {
        //SearchByExtension
        ArrayList<Asset> listByExtension = new ArrayList<>();
        for(Asset f: shortList){
            if (f.getFileName().endsWith("." + this.searchCriteria.getExtension())){
                System.out.println(f.getFileName() + "FOUND EXTENSION");
                listByExtension.add(f);
            }
        }
        return listByExtension;
    }

    /**
     * This method is used to get all files that matched BY filename or extension
     * @return  searchList get all files that matched with the Search Criteria
     */
    public ArrayList<Asset> getResults(){
        ArrayList<Asset> searchResult = getAllFileByPath(searchCriteria.getFilePath());
        if(searchCriteria.getFileName() != null){
            searchResult = searchByName(searchCriteria.getFileName(),searchResult);
        }
        if(searchCriteria.getExtension() != null){
            searchResult = searchByExtension(searchCriteria.getExtension(),searchResult);
        }
        if(!searchCriteria.getHiddenFlag()){
            searchResult = searchByHiddenAttributeSetAsFalse(searchResult);
        } else {
            searchResult = searchByHiddenAttributeSetAsTrue(searchResult);
        }
        if(searchCriteria.getOwner() != null){
            searchResult = searchByOwner(searchCriteria.getOwner(),searchResult);
        }
        if(searchCriteria.getContent() != null){
            searchResult = searchByContent(searchResult, searchCriteria.getContent());
        }
        if(searchCriteria.getCreationDate() != null){
            searchResult = searchByCreationDate(searchCriteria.getCreationDate(),searchResult);
        }
        if(searchCriteria.getModificationDate() != null){
            searchResult = searchByModificationDate(searchCriteria.getModificationDate(),searchResult);
        }
        return searchResult;
    }

    private ArrayList<Asset> getAllFileByPath(String path) {
        ArrayList<Asset> allList = new ArrayList<>();
        File file = new File(path);
        listAllFilesByPath(file, allList);
        return allList;
    }

    public void listAllFilesByPath(File folderPath, ArrayList<Asset> shortList1){

        for(File oneFile: folderPath.listFiles()){
            String owner = "";
            Asset asset;
            try {
                owner = Files.getOwner(oneFile.toPath()).getName();
            } catch (IOException e){
                e.printStackTrace();
            }
            asset = FactoryAsset.createAsset("file",oneFile,owner);
            shortList1.add(asset);
        }
    }

    /**
    * This method is used to get all files that did match by an owner.
    */
    private ArrayList<Asset> searchByOwner(String owner, ArrayList<Asset> shortList) {
        //SearchByOwner
        ArrayList<Asset>  listByOwner = new ArrayList<>();
        for(Asset f: shortList){
            System.out.println(f.getFileName() +"-----");
            if (f.getOwner().contains(owner)){
                System.out.println(f.getFileName() + "FOUND OWNER");
                listByOwner.add(f);
            }
        }
        return listByOwner;
    }

    /**
     * This method is used to get all files that did match by content.
     */
    private ArrayList<Asset> searchByContent(ArrayList<Asset> shortList, String content) {
        //SearchByOwner
        ArrayList<Asset>  listByContent = new ArrayList<>();
        for(Asset f: shortList){
            System.out.println(f.getFileName() +"-----");
            System.out.println(f.getFilePath());
            try {
                File Archivo = new File(f.getFilePath());
                FileReader fr = new FileReader(Archivo);
                BufferedReader br = new BufferedReader(fr);
                //Read File
                String line="";
                while((line=br.readLine())!=null) {
                    if (line.indexOf(content)!= -1) {
                        System.out.println(line+ "FOUND line");
                        listByContent.add(f);
                    }
                }br.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return listByContent;
    }
    /**
     * This method is used to get all files that did match by content.
     */
    private ArrayList<Asset> searchByCreationDate(String creationDate, ArrayList<Asset> shortList) {
        //SearchByCreateDate
        ArrayList<Asset>  listByCreationDate = new ArrayList<>();
        for(Asset f: shortList){
            try {
                BasicFileAttributes bfa = Files.readAttributes(Paths.get(f.getFilePath()), BasicFileAttributes.class);
                FileTime ft = bfa.creationTime();
                System.out.println(f.getFileName() + "-----");
                String date = dateToString(ft);
                System.out.println(date + " -DATE");
                if (date.equals(creationDate)) {
                    System.out.println(f.getFileName() + "FOUND BY CREATION DATE");
                    listByCreationDate.add(f);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return listByCreationDate;
    }

    /**
     * This method is used to get all files that did match by modificationDate .
     */
    private ArrayList<Asset> searchByModificationDate(String modificationDate, ArrayList<Asset> shortList) {
        //SearchByCreateDate
        ArrayList<Asset>  listByModificationDate = new ArrayList<>();
        for(Asset f: shortList){
            try {
                BasicFileAttributes bfa = Files.readAttributes(Paths.get(f.getFilePath()), BasicFileAttributes.class);
                FileTime ft = bfa.lastModifiedTime();
                System.out.println(f.getFileName() + "-----");
                String date = dateToString(ft);
                System.out.println(date + " - DATE");
                if (date.equals(modificationDate)) {
                    System.out.println(f.getFileName() + "FOUND BY MODIFICATION DATE");
                    listByModificationDate.add(f);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return listByModificationDate;
    }

    private String dateToString(FileTime ft) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        String dateToCompare = dateFormat.format(ft.toMillis());
        return dateToCompare;
    }


    //Only for testing purposes
    public  static void main(String args[]){
        SearchCriteria sc = new SearchCriteria();
        sc.setFolderPath("\\Test");
        sc.setFileName("file8");
        sc.setExtension("jonas");
        sc.setHiddenFlag(false);
        sc.setOwner("WIN-IT92TJKOQE6\\Guest");
        sc.setContent("como");
        sc.setCreationDate("2018-16-04");
        sc.setModificationDate("2018-16-04");

        Search search = new Search();
        search.setSearchCriteria(sc);

        ArrayList<Asset> searchResult = search.getAllFileByPath(search.searchCriteria.getFilePath());


        search.searchByName(search.searchCriteria.getFileName(),searchResult);
        search.searchByExtension(search.searchCriteria.getExtension(),searchResult);
        search.searchByHiddenAttributeSetAsFalse(searchResult);
        search.searchByHiddenAttributeSetAsTrue(searchResult);
        search.searchByOwner(search.searchCriteria.getOwner(), searchResult);
        search.searchByContent(searchResult, search.searchCriteria.getContent());
        search.searchByCreationDate(search.searchCriteria.getCreationDate(), searchResult);
        search.searchByModificationDate(search.searchCriteria.getModificationDate(), searchResult);

    }

 }
