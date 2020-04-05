package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.bean.XmlPerson;
import com.maple.springboot.mybatis.mapper.XmlPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlPersonServiceImpl implements IXmlPersonService {
    @Autowired
    private XmlPersonMapper xmlPersonMapper;

    @Override
    public int insertXml(XmlPerson xmlPerson) {
        return xmlPersonMapper.insert(xmlPerson);
    }

    @Override
    public int deleteById(Integer id) {
        return xmlPersonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(XmlPerson xmlPerson) {
        return xmlPersonMapper.updateByPrimaryKey(xmlPerson);
    }

    @Override
    public XmlPerson selectById(Integer id) {
        return xmlPersonMapper.selectById(id);
    }

    @Override
    public List<XmlPerson> selectAllXml() {
        return xmlPersonMapper.selectAll();
    }
}
