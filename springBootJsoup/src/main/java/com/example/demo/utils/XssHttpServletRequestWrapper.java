package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Jsoup过滤http请求，防止Xss攻击
 *
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤如果需要获得原始的值，则通过super.getParameterValues(name)来获取
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        if (("content".equals(name) || name.endsWith("WithHtml")) && !isIncludeRichText) {
            return super.getParameter(name);
        }
        name = JsoupUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            value = JsoupUtil.clean(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = JsoupUtil.clean(arr[i]);
            }
        }
        return arr;
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤如果需要获得原始的值，则通过super.getHeaders(name)来获取
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        name = JsoupUtil.clean(name);
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)) {
            value = JsoupUtil.clean(value);
        }
        return value;
    }

    /**
     * 获取原始的request
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取原始的request的静态方法
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }

}
