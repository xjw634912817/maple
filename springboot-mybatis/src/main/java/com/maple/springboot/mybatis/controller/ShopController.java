package com.maple.springboot.mybatis.controller;

import com.google.common.collect.Lists;
import com.maple.springboot.mybatis.domain.Shop;
import com.maple.springboot.mybatis.domain.XmlPerson;
import com.maple.springboot.mybatis.service.IShopService;
import com.maple.springboot.mybatis.service.IXmlPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @RequestMapping("/insert")
    public int insert(@RequestParam Integer id) {
        Shop shop = new Shop();
        shop.setId(id);
        shop.setRange(Lists.newArrayList(1,3,5));
        return shopService.insert(shop);
    }

    @RequestMapping("/findAll")
    public List<Shop> findAll() {
        return shopService.selectAll();
    }

}
