package com.gxa.scdx.cloud.user.config;

import com.gxa.scdx.cloud.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author all;
 */

@Configuration
public class SystemConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") //  test springboot2.4之前的设置 允许跨域的域名，可以用*表示允许任何域名使用
//                .allowedOriginPatterns("*") //springboot2.4之后的设置 允许跨域的域名，可以用*表示允许任何域名使用
                .allowedMethods("*") //允许任何方法（post、get等）
                .allowedHeaders("*") //允许任何请求头
                .allowCredentials(true) //带上cookie信息
                .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
    }

    // 将登录拦截器配置到容器中
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())  // 没有被放行的请求，全部调用LoginInterceptor来完成验证
//                .addPathPatterns("/**")         // 所有请求路径，全部被拦截
//                .excludePathPatterns("/",       // 下面配置的请求路径，全部是放行路径
//                        "/login.html",
//                        "/css/**",
//                        "/user/login",
//                        "/admin/test",
//                        "/admin/testJSON",
//                        "/admin/testMap",
//                        "/favicon.ico",
//                        "/login/**",
//                        "/images/**",
//                        "/jquery/**",
//                        "/js/**",
//                        "/layui/**",                // html页面框架
//                        "/swagger-resources/**",    // 接口文档框架
//                        "/webjars/**",              // 接口文档框架
//                        "/v2/**",                   // 接口文档框架
//                        "/swagger-ui.html/**");     // 接口文档框架
//    }


}
