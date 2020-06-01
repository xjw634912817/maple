package com.maple.springboot.autoconfiguration;

import com.maple.springboot.formatter.ICustomFormatter;
import com.maple.springboot.formatter.JsonFormatter;
import com.maple.springboot.formatter.StringFormatter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FormatterAutoConfiguration {

    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    @Primary
    @Bean
    public ICustomFormatter stringFormat() {
        return new StringFormatter();
    }

    @ConditionalOnClass(name={"com.alibaba.fastjson.JSON"})
    @Bean
    public ICustomFormatter jsonFormatter() {
        return new JsonFormatter();
    }

}
