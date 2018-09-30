package com.hlj.risk.pisk.util;

import org.apache.log4j.PatternLayout;

/**
 * Created by huanglijun on 2018/8/29.
 */
public class CSVLayout extends PatternLayout {

    private static final String HEADER = "operationTime,functionName,userid,bizid,data";

    @Override
    public String getHeader() {
        return HEADER + System.getProperty("line.separator");
    }

    private String operationTime;
    private String functionName;
    private String userid;
    private String bizid;
    private String data;

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
