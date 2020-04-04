package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.bean.Person;

import java.util.List;

public interface IPersonService {
    int insertPerson(Person person);

    int deleteById(Integer id);

    int updateById(Person person);

    Person selectById(Integer id);

    List<Person> selectAllPerson();
}
