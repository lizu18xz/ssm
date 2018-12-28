package com.fayayo.typehandler;

import com.fayayo.pojo.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
// 指定JdbcType
@MappedJdbcTypes(JdbcType.TINYINT)
// 指定枚举类型
@MappedTypes(SexEnum.class)
public class SexTypeHandler implements TypeHandler<SexEnum>{


    @Override
    public void setParameter(PreparedStatement ps, int index, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        if (sexEnum == null) {
            // 如果不设置，则默认为1（男性）
            ps.setInt(index, 1);
        } else {
            ps.setInt(index, sexEnum.getCode());
        }
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String columnName) throws SQLException {
        int code = resultSet.getInt(columnName);
        return SexEnum.getSexByCode(code);
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int index) throws SQLException {
        int code = resultSet.getInt(index);
        return SexEnum.getSexByCode(code);
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int index) throws SQLException {
        int code = callableStatement.getInt(index);
        return SexEnum.getSexByCode(code);
    }
}
