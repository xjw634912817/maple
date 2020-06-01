package com.maple.springboot.autoconfiguration;

import com.maple.springboot.HelloTemplate;
import com.maple.springboot.formatter.ICustomFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatterAutoConfiguration.class)
@Configuration
public class HelloAutoConfiguration {

    @Bean
    public HelloTemplate helloTemplate(ICustomFormatter customFormatter) {
        return new HelloTemplate(customFormatter);
    }

}
