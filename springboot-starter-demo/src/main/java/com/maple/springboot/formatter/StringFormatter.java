package com.maple.springboot.formatter;

import java.util.Objects;

public class StringFormatter implements ICustomFormatter {
    @Override
    public <T> String format(T object) {
        return "StringFormatter : " + Objects.toString(object);
    }
}
