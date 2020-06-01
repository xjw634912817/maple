package com.maple.springboot.formatter;

import com.alibaba.fastjson.JSON;

public class JsonFormatter implements ICustomFormatter {

    @Override
    public <T> String format(T object) {
        return "JsonFormatter : " + JSON.toJSONString(object);
    }
}
