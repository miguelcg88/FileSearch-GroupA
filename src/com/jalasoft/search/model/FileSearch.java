/*
 * @(#)FileSearch.java        1.00 4/3/18
 *
 * Copyright (c) Jalasoft
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package src.com.jalasoft.search.model;

import com.jalasoft.search.Model.Asset;

/**
 * FileSearch
 *
 * @version 1.00 3 Apr 2018
 * @author Gabriel Rendon  */
public class FileSearch extends Asset{
    private String extension;
    public FileSearch(String path){
        super(path);
    }

//    /**
//     * Set folder/file path
//     * @param folderPath
//     */
//    public void setFolderPath(String folderPath) {
//        //this.asset.folderPath = folderPath;
//    }
//
//    /**
//     * Get folder/file path
//     * @return folderPath
//     */
//    private String getFilePath() {
//        return folderPath;
//    }
//
//    /**
//     * Set file name
//     * @param name
//     */
//    public void setFileName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * Get file name
//     * @return name
//     */
//    private String getFileName() {
//        return name;
//    }
//
//    /**
//     * Set hidden flag
//     * @param hidden
//     */
//    public void setHiddenFlag(boolean hidden) {
//        this.hidden = hidden;
//    }
//
//    /**
//     * Get hidden flag
//     * @return hidden
//     */
//    private boolean getHiddenFlag() {
//        return hidden;
//    }

    /**
     * Set file extension
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get file extension
     * @return extension
     */
    private String getExtension() {
        return extension;
    }

    /**
     * Set file extension
     * @param //extension
     */
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }
//
//    /**
//     * Get file extension
//     * @return owner
//     */
//    private String getOwner() {
//        return owner;
//    }
}
