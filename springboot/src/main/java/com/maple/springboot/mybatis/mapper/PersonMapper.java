package com.maple.springboot.mybatis.mapper;

import com.maple.springboot.mybatis.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {
    @Insert("insert into person(id, name, age) values (#{id}, #{name}, #{age})")
    int insert(Person person);

    @Delete("delete from person where id = #{id}")
    int deleteByPrimaryKey(Integer id);

    @Update("update person set name = #{name}, age = #{age} where id = #{id}")
    int updateByPrimaryKey(Person person);

    @Select("select * from person where id = #{id}")
    Person selectByPrimaryKey(Integer id);

    @Select("select * from person")
    List<Person> selectAll();
}
