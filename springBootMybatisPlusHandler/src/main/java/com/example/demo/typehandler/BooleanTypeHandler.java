package com.example.demo.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Boolean.class)
public class BooleanTypeHandler implements TypeHandler<Boolean> {

    @Override
    public Boolean getResult(ResultSet arg0, String arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean flag = Boolean.FALSE;
        if(str.equalsIgnoreCase("Y")){
            flag = Boolean.TRUE;
        }
        return flag;
    }

    @Override
    public Boolean getResult(ResultSet arg0, int arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean flag = Boolean.FALSE;
        if(str.equalsIgnoreCase("Y")){
            flag = Boolean.TRUE;
        }
        return flag;
    }

    @Override
    public Boolean getResult(CallableStatement arg0, int arg1)
            throws SQLException {
        String str = arg0.getString(arg1);
        Boolean flag = Boolean.FALSE;
        if(str.equalsIgnoreCase("Y")){
            flag = Boolean.TRUE;
        }
        return flag;
    }

    @Override
    public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2,
                             JdbcType arg3) throws SQLException {
        Boolean flag = (Boolean) arg2;
        String value = flag == true ? "Y" : "N";
        arg0.setString(arg1, value);
    }
}
