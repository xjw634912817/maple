package com.maple.springboot.springbootdemo.importannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(OtherConfiguration.class)
public class ImportConfiguration {
}
