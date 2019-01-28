package com.yxkj.aha.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther: zch
 * @Date: 2019/1/28 11:59
 * @Description:
 */

public class Role implements Serializable {
    private static final long serialVersionUID = -7790334862410409053L;
    private Long id;
    private String name;
    private String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
