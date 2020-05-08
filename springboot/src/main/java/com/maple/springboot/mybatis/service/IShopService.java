package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.domain.Shop;

import java.util.List;

public interface IShopService {

    int insert(Shop person);

    List<Shop> selectAll();

}
