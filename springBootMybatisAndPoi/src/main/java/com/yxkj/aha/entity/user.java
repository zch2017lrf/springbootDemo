package com.yxkj.aha.entity;

import com.yxkj.aha.common.annotation.ExportConfig;

/**
 * @Auther: zch
 * @Date: 2018/12/6 08:38
 * @Description:
 */
public class user {
    @ExportConfig(value = "id")
    private Integer id;
    @ExportConfig(value = "姓名")
    private String username;
    @ExportConfig(value = "密码")
    private String password;
    @ExportConfig(value = "0")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
