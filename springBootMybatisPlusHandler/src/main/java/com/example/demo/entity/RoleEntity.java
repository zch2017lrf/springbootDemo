package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_role")
public class RoleEntity {
    private int id;
    private String roleName;
    private String note;
    @TableField(value = "is_girl",el = "isGirl,typeHandler=com.example.demo.typehandler.BooleanTypeHandler")
    private Boolean isGirl;
}
