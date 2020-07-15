package com.maple.springboot.springbootdemo.qualify;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class QualifyConfiguration {

    @Qualifier
    @Autowired(required = false)
    private List<Person5> person5List;

    @Bean
    @Qualifier
    public Person5 person5() {
        return new Person5("person5");
    }

    @Bean
    public Person5 person51() {
        return new Person5("person51");
    }

    @PostConstruct
    public void sout() {
        System.out.println(JSON.toJSON(person5List));
    }

}
