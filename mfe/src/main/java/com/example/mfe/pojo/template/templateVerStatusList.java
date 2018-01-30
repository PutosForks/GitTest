package com.example.mfe.pojo.template;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;
import lombok.Data;

public class templateVerStatusList {

    private Long id;

    MfeStatusEnum mfeStatus;
    MfeStatusEnum testStatus;
    MfeStatusEnum liveStatus;

    EnvironmentEnum mfeEnvironment;
    EnvironmentEnum testEnvironment;
    EnvironmentEnum liveEnvironment;



    public templateVerStatusList(Long id, MfeStatusEnum mfeStatus, MfeStatusEnum testStatus, MfeStatusEnum liveStatus, EnvironmentEnum mfeEnvironment, EnvironmentEnum testEnvironment, EnvironmentEnum liveEnvironment) {
        this.id = id;
        this.mfeStatus = mfeStatus;
        this.testStatus = testStatus;
        this.liveStatus = liveStatus;
        this.mfeEnvironment = mfeEnvironment;
        this.testEnvironment = testEnvironment;
        this.liveEnvironment = liveEnvironment;
    }

    public EnvironmentEnum getMfeEnvironment() {
        return mfeEnvironment;
    }

    public void setMfeEnvironment(EnvironmentEnum mfeEnvironment) {
        this.mfeEnvironment = mfeEnvironment;
    }

    public EnvironmentEnum getTestEnvironment() {
        return testEnvironment;
    }

    public void setTestEnvironment(EnvironmentEnum testEnvironment) {
        this.testEnvironment = testEnvironment;
    }

    public EnvironmentEnum getLiveEnvironment() {
        return liveEnvironment;
    }

    public void setLiveEnvironment(EnvironmentEnum liveEnvironment) {
        this.liveEnvironment = liveEnvironment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MfeStatusEnum getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(MfeStatusEnum testStatus) {
        this.testStatus = testStatus;
    }

    public MfeStatusEnum getMfeStatus() {
        return mfeStatus;
    }

    public void setMfeStatus(MfeStatusEnum mfeStatus) {
        this.mfeStatus = mfeStatus;
    }

    public MfeStatusEnum getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(MfeStatusEnum liveStatus) {
        this.liveStatus = liveStatus;
    }
}
