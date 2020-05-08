package com.maple.springboot.mybatis.controller;

import com.maple.springboot.mybatis.domain.Person;
import com.maple.springboot.mybatis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping("/insert")
    public int insert(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        return personService.insertPerson(new Person(id, name, age));
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam Integer id) {
        return personService.deleteById(id);
    }

    @RequestMapping("/update")
    public int update(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        return personService.updateById(new Person(id, name, age));
    }

    @RequestMapping("/get")
    public Person get(@RequestParam Integer id) {
        return personService.selectById(id);
    }

    @RequestMapping("/findAll")
    public List<Person> findAll() {
        return personService.selectAllPerson();
    }
}
