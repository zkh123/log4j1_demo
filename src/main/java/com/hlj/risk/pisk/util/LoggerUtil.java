package com.hlj.risk.pisk.util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;


public class LoggerUtil {

    private static Logger logFile = null;
    private static String fileName = "";

    public static void setFileName(String name){
        fileName = "file_" + name;
    }

    public static synchronized Logger getProTest(){
        if (logFile == null){
            logFile = Logger.getLogger("proTest");
            FileAppender fileAppender1 = (FileAppender) logFile.getAppender("file");
            String param = "/data/test/" + fileName + ".log";
            logFile.info(param);
            fileAppender1.setFile(param);
            fileAppender1.activateOptions();
        }
        return logFile;

    }
}
