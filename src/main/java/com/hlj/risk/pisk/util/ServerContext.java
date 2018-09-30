package com.hlj.risk.pisk.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SuppressWarnings("static-access")
public class ServerContext {
    private static ApplicationContext ctx;
    private static ServerContext instance = null;

    public synchronized static ServerContext getInstance(){
        if(instance==null){
            instance = new ServerContext();
        }
        return instance;
    }

    private ServerContext() {
        initCtx();
    }
    private void initCtx(){
        try{
            if(ctx == null) {
                String location = "conf/applicationContext.xml";
                ctx = new FileSystemXmlApplicationContext(location);
            }
        }catch(Exception e){
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    public ApplicationContext getApplicationContext(){
        return this.ctx;
    }

    public Object getBean(String name) throws BeansException {
        return ctx.getBean(name);
    }

    public <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }

    public <T> T getBean(Class<T> clazz, String name) {
        return ctx.getBean(name, clazz);
    }

    public String getProperty(String key){
        String propertyValue = null;

        try {
            AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext)ctx;
            propertyValue=abstractApplicationContext.getBeanFactory().resolveEmbeddedValue("${"+key+"}");
        } catch (Exception e) {
        }

        return propertyValue;
    }

}
