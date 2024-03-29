package com.gxa.scdx.cloud.user.filter;

import com.gxa.scdx.cloud.user.service.AdminService;
import com.gxa.scdx.cloud.user.service.impl.AdminServiceImpl;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * (ResultDTO) dto对象
 *
 * @author all;
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */


public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    @Resource
    private AdminServiceImpl adminService;
    /**
     * 这个方法决定了是否需要用户登录
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        System.out.println("MyFormAuthenticationFilter  -------------------------  isAccessAllowed isRemembered=" + subject.isRemembered());
        System.out.println("MyFormAuthenticationFilter  -------------------------  isAccessAllowed isAuthenticated=" + subject.isAuthenticated());
        /*
        如果isAuthenticated 为 true 代表用户手动输入用户名和密码登录
        如果isRemembered 为 true 代表用户直接通过RemenberMe功能登录
        按照官方说明isAuthenticated和isRememberd是互斥的，即任中一个为true，另外一个必为false
        如果希望在用户两种情况添加额外处理，可以写在下面if else中
         */
        if(subject.isAuthenticated()) {
            // do work...
        }
        else if(subject.isRemembered()) {
            // do work...
        }
        //这个方法默认只返回 subject.isAuthenticated()   加上 subject.isRemembered() 目的是让它同时也兼容remember这种情况
        return subject.isAuthenticated() || subject.isRemembered();
    }

    @Bean
    public FilterRegistrationBean registration(MyFormAuthenticationFilter myFormAuthenticationFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(myFormAuthenticationFilter);
        registration.setEnabled(false);
        return registration;
    }
}
