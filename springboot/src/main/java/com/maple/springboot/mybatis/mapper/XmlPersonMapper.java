package com.maple.springboot.mybatis.mapper;

import com.maple.springboot.mybatis.domain.XmlPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XmlPersonMapper {
    int insert(XmlPerson person);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(XmlPerson person);

    XmlPerson selectById(@Param("id") Integer id);

    List<XmlPerson> selectAll();

    List<XmlPerson> testTypeHandler();
}
