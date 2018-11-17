package com.adityak.parser.common.configuration;

import java.util.LinkedList;
import java.util.List;

public class FileConfiguration<T> {


    private Class<T> targetClazz;

    /**
     *
     */
    private int headerLineNo = 1;
    /**
     *
     */
    private int dataLineNo = 2;

    /**
     *
     */
    private List<ItemConfiguration> headerConfiguration;

    /**
     *
     */
    private List<ItemConfiguration> detailConfiguration;


    public Class<T> getTargetClazz() {
        return targetClazz;
    }

    public void setTargetClazz(Class<T> targetClazz) {
        this.targetClazz = targetClazz;
    }

    public int getHeaderLineNo() {
        return headerLineNo;
    }

    public void setHeaderLineNo(int headerLineNo) {
        this.headerLineNo = headerLineNo;
    }

    public int getDataLineNo() {
        return dataLineNo;
    }

    public void setDataLineNo(int dataLineNo) {
        this.dataLineNo = dataLineNo;
    }

    public List<ItemConfiguration> getHeaderConfiguration() {
        return headerConfiguration;
    }

    public void setHeaderConfiguration(List<ItemConfiguration> headerConfiguration) {
        this.headerConfiguration = headerConfiguration;
    }

    public List<ItemConfiguration> getDetailConfiguration() {
        return detailConfiguration;
    }

    public void setDetailConfiguration(List<ItemConfiguration> detailConfiguration) {
        this.detailConfiguration = detailConfiguration;
    }
}
