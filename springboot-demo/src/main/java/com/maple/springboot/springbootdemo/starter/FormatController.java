package com.maple.springboot.springbootdemo.starter;

import com.maple.springboot.HelloTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatController {

    @Autowired
    private HelloTemplate helloTemplate;

    @GetMapping("/format")
    public String format() {
        Person person = new Person("maple", 18);
        return helloTemplate.format(person);
    }

}
