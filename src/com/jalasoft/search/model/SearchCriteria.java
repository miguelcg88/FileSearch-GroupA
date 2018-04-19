/*
 * @(#)SearchController.java        1.00 3/22/18
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
/**
 * Search Criteria
 *
 * @version 1.00 26 Mar 2018
 * @author Gabriel Rendon  */
public class SearchCriteria {
    /**
     private variables */
    //private Assets asset;
    private String folderPath;
    private String name;
    private boolean hidden;
    private String extension;
    private String owner;
    private String content;

    private String creationDateStart;
    private String creationDateEnd;
    private String modificationDateStart;
    private String modificationDateEnd;



    /**
     * Set folder/file path
     * @param folderPath
     */
    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
        //this.asset.folderPath = folderPath;
    }

    /**
     * Get folder/file path
     * @return folderPath
     */
    public String getFilePath() {
        return folderPath;
    }

    /**
     * Set file name
     * @param name
     */
    public void setFileName(String name) {
        this.name = name;
    }

    /**
     * Get file name
     * @return name
     */
    public String getFileName() {
        return name;
    }

    /**
     * Set hidden flag
     * @param hidden
     */
    public void setHiddenFlag(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Get hidden flag
     * @return hidden
     */
    public boolean getHiddenFlag() {
        return hidden;
    }

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
    public String getExtension() {
        return extension;
    }

    /**
     * Set file owner
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get file owner
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCreationDateFrom(String creaFrom){
        this.creationDateStart = creaFrom;
    }

    public void setCreationDateTo(String creaTo){
        this.creationDateEnd = creaTo;
    }

    public String getCreationDateFrom() {
        return creationDateStart;
    }


    public void setCreationDateEnd(String creationDateEnd) {
        this.creationDateEnd = creationDateEnd;
    }
    public String getCreationDateTo() {
        return creationDateEnd;
    }

    public void setModificationDateFrom(String modFrom){
        this.modificationDateStart = modFrom;

    }

    public void setModificationDateTo(String modTo){
        this.modificationDateEnd = modTo;
    }


    public void setModificationDateStart(String modificationDateStart){
        this.modificationDateStart = modificationDateStart;
    }

    public String getModificationDateStart() {
        return modificationDateStart;
    }

    public void setModificationDateEnd(String modificationDateEnd) {
        this.modificationDateEnd = modificationDateEnd;
    }
    public String getModificationDateFrom() {
        return modificationDateStart;
    }

    public String getModificationDateTo() {
        return modificationDateEnd;

    }

    public String getModificationDateEnd() {
        return modificationDateEnd;
    }


}
