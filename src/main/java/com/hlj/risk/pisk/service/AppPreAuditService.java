package com.hlj.risk.pisk.service;

import com.alibaba.fastjson.JSONObject;
import com.hlj.risk.pisk.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppPreAuditService implements Runnable{
    private AtomicInteger preAudtiAtomic;
    private Integer temp;

    private static final Logger logger = LoggerFactory.getLogger(AppPreAuditService.class);

    public AppPreAuditService(AtomicInteger preAudtiAtomic,Integer temp){
        this.preAudtiAtomic = preAudtiAtomic;
        this.temp = temp;
    }

    @Override
    public void run(){
        try {
            ConcurrentMap<Integer,Object> map = new ConcurrentHashMap<>();
            for (int i = 0 ; i < 2000; i++){
                map.put(i,i);
                LoggerUtil.getProTest().info(temp + "  ----  " + i);
            }
            LoggerUtil.getProTest().info(JSONObject.toJSONString(map));
            String tName = Thread.currentThread().getName();
            long beginTime = System.currentTimeMillis();
            long readTime = System.currentTimeMillis();
            long execTime = System.currentTimeMillis();
            long adjTime = System.currentTimeMillis();
            LoggerUtil.getProTest().info(tName+" finish. read db time:"+(readTime-beginTime)+"ms, execute cmds time:"+(execTime-readTime)+"ms, adj time:"+(adjTime-execTime)+"ms");
            preAudtiAtomic.incrementAndGet();
        }catch (Exception e){
            logger.error("APP拟审批 exception", e);
        }
    }

}
