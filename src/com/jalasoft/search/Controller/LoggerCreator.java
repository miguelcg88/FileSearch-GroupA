package src.com.jalasoft.search.Controller;

import java.util.logging.Logger;

public class LoggerCreator {
    private static LoggerCreator logCreator;
    private static Logger LOGGER;

    private LoggerCreator() {
        //readConfig();
    }

    public static LoggerCreator getInstance(){
        if(logCreator == null){
            logCreator = new LoggerCreator();
        }
        return logCreator;
    }
    /*
    private readConfig(){
      //log new logging("../../../../config/config.txt");
    }
    */
}
