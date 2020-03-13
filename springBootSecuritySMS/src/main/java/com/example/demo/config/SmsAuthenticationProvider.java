package com.example.demo.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 在创建完SmsAuthenticationFilter后，我们需要创建一个支持处理该类型Token的类，即SmsAuthenticationProvider，该类需要实现AuthenticationProvider的两个抽象方法
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {

    private MyUserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;
        UserDetails userDetails = userDetailService.loadUserByUsername((String) authenticationToken.getPrincipal());

        if (userDetails == null)
            throw new InternalAuthenticationServiceException("未找到与该手机号对应的用户");

        SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(userDetails, userDetails.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SmsAuthenticationToken.class.isAssignableFrom(aClass);
    }

    public MyUserDetailService getUserDetailService() {
        return userDetailService;
    }

    public void setUserDetailService(MyUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
}
