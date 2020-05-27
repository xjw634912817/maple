package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.domain.Shop;
import com.maple.springboot.mybatis.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    private ShopMapper shopMapper;


    @Override
    public int insert(Shop shop) {
        return shopMapper.insert(shop);
    }

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }


}
