package com.maple.springboot.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = HelloProperties.HELLO_PROPERTIES_PREFIX)
public class HelloProperties {

    static final String HELLO_PROPERTIES_PREFIX = "maple.hello";
    private Map<String, Object> info;
    private Long timeout;
    private String name;

    public static String getHelloPropertiesPrefix() {
        return HELLO_PROPERTIES_PREFIX;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
