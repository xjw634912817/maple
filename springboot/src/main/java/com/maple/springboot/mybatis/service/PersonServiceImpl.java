package com.maple.springboot.mybatis.service;

import com.maple.springboot.mybatis.domain.Person;
import com.maple.springboot.mybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insertPerson(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public int deleteById(Integer id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(Person person) {
        return personMapper.updateByPrimaryKey(person);
    }

    @Override
    public Person selectById(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Person> selectAllPerson() {
        return personMapper.selectAll();
    }
}
