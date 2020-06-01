package com.maple.springboot;

import com.maple.springboot.autoconfiguration.HelloProperties;
import com.maple.springboot.formatter.ICustomFormatter;

import java.util.Objects;

public class HelloTemplate {

    private ICustomFormatter customFormatter;

    private HelloProperties helloProperties;

    public HelloTemplate(ICustomFormatter customFormatter, HelloProperties helloProperties) {
        this.customFormatter = customFormatter;
        this.helloProperties = helloProperties;
    }

    public <T> String format(T object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Execute format:").append("</br>")
                .append("format result: ").append(customFormatter.format(object)).append("</br>");
        if (Objects.nonNull(helloProperties.getInfo())) {
            stringBuilder.append(helloProperties.getInfo());
        }
        if (Objects.nonNull(helloProperties.getName())) {
            stringBuilder.append(helloProperties.getName());
        }
        if (Objects.nonNull(helloProperties.getTimeout())) {
            stringBuilder.append(helloProperties.getTimeout());
        }
        return stringBuilder.toString();
    }
}
