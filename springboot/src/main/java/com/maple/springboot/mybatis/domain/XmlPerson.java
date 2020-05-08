package com.maple.springboot.mybatis.domain;

public class XmlPerson {
    private Integer id;
    private String name;
    private Integer age;
    private String myTest;

    public XmlPerson() {
    }

    public XmlPerson(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMyTest() {
        return myTest;
    }

    public void setMyTest(String myTest) {
        this.myTest = myTest;
    }
}
