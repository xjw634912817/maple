package com.maple.springboot.mybatis.mapper;

import com.maple.springboot.mybatis.domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper {
    int insert(Shop shop);

    List<Shop> selectAll();
}
