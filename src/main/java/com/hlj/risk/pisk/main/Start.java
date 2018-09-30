package com.hlj.risk.pisk.main;

import com.hlj.risk.pisk.service.ReadUserService;
import com.hlj.risk.pisk.util.LoggerUtil;
import com.hlj.risk.pisk.util.ServerContext;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Start {

    private static final Logger logger = LoggerFactory.getLogger(Start.class);

    public static void main(String args[]){
        try {
            PropertyConfigurator.configure("conf/log4j.properties");
            String param = "hlj_test.log";
            LoggerUtil.setFileName(param);

            LoggerUtil.getProTest().info("start");
            ReadUserService readUserService = ServerContext.getInstance().getBean(ReadUserService.class);
            readUserService.readFile();
        }catch (Exception e){
            logger.error("初始化失败", e);
        }
    }

}
