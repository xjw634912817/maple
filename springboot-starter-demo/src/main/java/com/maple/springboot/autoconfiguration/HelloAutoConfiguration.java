package com.maple.springboot.autoconfiguration;

import com.maple.springboot.HelloTemplate;
import com.maple.springboot.formatter.ICustomFormatter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatterAutoConfiguration.class)
@EnableConfigurationProperties(HelloProperties.class)
@Configuration
public class HelloAutoConfiguration {

    @Bean
    public HelloTemplate helloTemplate(ICustomFormatter customFormatter, HelloProperties helloProperties) {
        return new HelloTemplate(customFormatter, helloProperties);
    }

}
