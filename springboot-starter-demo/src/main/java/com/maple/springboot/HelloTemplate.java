package com.maple.springboot;

import com.maple.springboot.formatter.ICustomFormatter;

public class HelloTemplate {

    private ICustomFormatter customFormatter;

    public HelloTemplate(ICustomFormatter customFormatter) {
        this.customFormatter = customFormatter;
    }

    public <T> String format(T object) {
        return "Execute format:" + "\n" +
                "format result: " + customFormatter.format(object);
    }
}
