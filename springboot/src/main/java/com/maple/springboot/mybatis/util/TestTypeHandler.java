package com.maple.springboot.mybatis.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        // 设置String类型的参数的时候调用，Java类型到JDBC类型
        // 注意只有在字段上添加typeHandler属性才会生效
        System.out.println("自定义JsonTypeHandler");
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据列名获取String类型的参数的时候调用，JDBC类型到Java类型
        System.out.println("自定义JsonTypeHandler getNullableResult 1 : " + columnName);
        return rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据下标获取String类型的参数的时候调用
        System.out.println("自定义JsonTypeHandler getNullableResult 2 : " + columnIndex);
        return rs.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("自定义JsonTypeHandler getNullableResult 3 : " + columnIndex);
        return cs.getString(columnIndex);
    }
}
