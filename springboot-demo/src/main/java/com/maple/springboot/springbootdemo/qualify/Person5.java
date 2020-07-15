package com.maple.springboot.springbootdemo.qualify;

public class Person5 {

    private String name;

    public Person5(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                '}';
    }
}
