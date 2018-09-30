package com.hlj.risk.pisk.entity;

/**
 * Created by wuxiao on 2017/11/17.
 */
public class UserModel {

    private String userId;
    private Double creditScore;
    private int filterType;
    private int userType;
    private String modelVer;
    private String ModelLabel;
    private String score;

    public UserModel(){}

    public UserModel(String userId, String score, int filterType, int userType) {
        this.userId = userId;
        this.score = score;
        this.filterType = filterType;
        this.userType = userType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    public int getFilterType() {
        return filterType;
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getModelVer() {
        return modelVer;
    }

    public void setModelVer(String modelVer) {
        this.modelVer = modelVer;
    }

    public String getModelLabel() {
        return ModelLabel;
    }

    public void setModelLabel(String modelLabel) {
        ModelLabel = modelLabel;
    }
}
