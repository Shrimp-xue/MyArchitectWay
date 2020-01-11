package com.shrimp.util.web;

import com.shrimp.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * @description: 预防XSS攻击 Filter
 * @author: shrimp
 * @date: Created in 2020-01-11 18:20
 * @version: 1.0
 */
public class XssFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(Object.class);

    private boolean ISDEBUG = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ISDEBUG = Boolean.valueOf(filterConfig.getInitParameter("debug"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if(ISDEBUG){
            logger.debug("before xss filter paramter:"+ JacksonUtil.toJson(request.getParameterMap()));
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        if(ISDEBUG){
            logger.debug("after xss filter paramter:"+ JacksonUtil.toJson(xssRequest.getParameterMap()));
        }
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {

    }
}
