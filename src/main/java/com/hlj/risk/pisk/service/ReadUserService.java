package com.hlj.risk.pisk.service;

import com.hlj.risk.pisk.thread.AdjustAmountThreadPool;
import com.hlj.risk.pisk.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class ReadUserService {

    private static final Logger logger = LoggerFactory.getLogger(ReadUserService.class);
    private int threads_adjustAmount = 50;
    private AdjustAmountThreadPool adjustAmountThreadPool;
    public int total = 0;
    private static AtomicInteger preAudtiAtomic = new AtomicInteger(0);

    public void readFile(){
        try {
            adjustAmountThreadPool = AdjustAmountThreadPool.initPool(threads_adjustAmount);
            for(int i=0; i<14000000; i++){
                adjustAmountThreadPool.excute(new AppPreAuditService(preAudtiAtomic,i));
            }
            LoggerUtil.getProTest().info("load patavar end, list size: "+total);
            try {
                adjustAmountThreadPool.shutdown();
                while(true){
                    Thread.sleep(1000);
                }
            }catch (Exception e){
                logger.error("结束拟审批连接池出现异常",e);
                System.exit(1);
            }
        }catch (Exception e){
            logger.error("read file exception", e);
        }
    }
}
