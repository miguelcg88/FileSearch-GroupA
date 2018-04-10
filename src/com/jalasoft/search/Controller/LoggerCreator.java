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
package src.com.jalasoft.search.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
/**
 * Implements the log creation
 * @author Gabriel Rendon
 * @version 0.1
 * @since 04/8/2018
 */
public class LoggerCreator {
    private static LoggerCreator logCreator;
    public static Logger logger;


    private LoggerCreator() {
        try (FileInputStream configFile = new FileInputStream("./logger.properties")) {
            //readConfig(configFile);
            LogManager.getLogManager().readConfiguration(configFile);
            logger = LogManager.getLogManager().getLogger("MyLog");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to return instance of the logger
     * @return an instance of LoggerCreator
     */
    public static LoggerCreator getInstance(){
        if(logCreator == null){
            logCreator = new LoggerCreator();
        }
        return logCreator;
    }

    private void readConfig(FileInputStream configFile){

    }
}
