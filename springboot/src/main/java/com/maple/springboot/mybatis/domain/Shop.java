package com.maple.springboot.mybatis.domain;

import java.util.List;

public class Shop {
    private Integer id;
    private List<Integer> range;

    public Shop() {
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }
}
