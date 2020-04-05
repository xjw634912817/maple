package com.maple.springboot.mybatis.controller;

import com.maple.springboot.mybatis.bean.XmlPerson;
import com.maple.springboot.mybatis.service.IXmlPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xmlPerson")
public class XmlPersonController {
    @Autowired
    private IXmlPersonService xmlService;

    @RequestMapping("/insert")
    public int insert(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        return xmlService.insertXml(new XmlPerson(id, name, age));
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam Integer id) {
        return xmlService.deleteById(id);
    }

    @RequestMapping("/update")
    public int update(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        return xmlService.updateById(new XmlPerson(id, name, age));
    }

    @RequestMapping("/get")
    public XmlPerson get(@RequestParam Integer id) {
        return xmlService.selectById(id);
    }

    @RequestMapping("/findAll")
    public List<XmlPerson> findAll() {
        return xmlService.selectAllXml();
    }
}
