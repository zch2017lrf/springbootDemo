package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = -6309732882044872298L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String operation;

    private Date time;

    private String method;

    private String params;

    private String ip;

    private Date createTime;
}
