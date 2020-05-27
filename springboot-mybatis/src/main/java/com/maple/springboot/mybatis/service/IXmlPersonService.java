package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.domain.XmlPerson;

import java.util.List;

public interface IXmlPersonService {
    int insertXml(XmlPerson person);

    int deleteById(Integer id);

    int updateById(XmlPerson person);

    XmlPerson selectById(Integer id);

    List<XmlPerson> selectAllXml();

    List<XmlPerson> testTypeHandler();

}
