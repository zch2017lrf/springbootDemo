package com.yxkj.aha.config.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Auther: zch
 * @Date: 2018/12/5 10:48
 * @Description:
 */

/**
 * getAuthorities获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象；

 getPassword和getUsername用于获取密码和用户名；

 isAccountNonExpired方法返回boolean类型，用于判断账户是否未过期，未过期返回true反之返回false；

 isAccountNonLocked方法用于判断账户是否未锁定；

 isCredentialsNonExpired用于判断用户凭证是否没过期，即密码是否未过期；

 isEnabled方法用于判断用户是否可用。
 */
public interface UserDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getUsername();
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
}
