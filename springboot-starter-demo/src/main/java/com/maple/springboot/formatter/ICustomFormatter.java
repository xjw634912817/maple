package com.maple.springboot.formatter;

public interface ICustomFormatter {

    <T> String format(T object);

}
