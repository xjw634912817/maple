package com.maple.springboot.mybatis.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CommaTypeHandler extends BaseTypeHandler<List<Integer>> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        // 设置List类型的参数的时候调用，Java类型到JDBC类型
        // 注意只有在字段上添加typeHandler属性才会生效
        System.out.println("自定义CommaTypeHandler");
        String result = null;
        if (!CollectionUtils.isEmpty(parameter)) {
            result = Joiner.on(",").join(parameter);
        }
        ps.setString(i, result);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据列名获取String类型的参数的时候调用，JDBC类型到Java类型
        System.out.println("自定义CommaTypeHandler getNullableResult 1 : " + columnName);
        return convert(rs.getString(columnName));
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据下标获取String类型的参数的时候调用
        System.out.println("自定义CommaTypeHandler getNullableResult 2 : " + columnIndex);
        return convert(rs.getString(columnIndex));
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("自定义CommaTypeHandler getNullableResult 3 : " + columnIndex);
        return convert(cs.getString(columnIndex));
    }

    private List<Integer> convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return Lists.newArrayList();
        }

        return Splitter.on(",").omitEmptyStrings().splitToList(value)
                .stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
