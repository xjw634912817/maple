package com.maple.springboot.springbootdemo.importannotation;

import com.maple.springboot.springbootdemo.importannotation.internal.Person4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfiguration {

    @Bean
    public Person3 person3() {
        return new Person3();
    }

    @Bean
    public Person4 person4() {
        return new Person4();
    }

}
