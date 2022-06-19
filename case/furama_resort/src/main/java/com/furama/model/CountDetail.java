package com.furama.model;

public class CountDetail {

    private Integer count = 0 ;

    public CountDetail(Integer count) {
        this.count = count;
    }

    public CountDetail() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountDeatil() {
        return count++;
    }
}
