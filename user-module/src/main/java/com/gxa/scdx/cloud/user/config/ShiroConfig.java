package com.gxa.scdx.cloud.user.config;

import com.gxa.scdx.cloud.user.filter.MyFormAuthenticationFilter;
import com.gxa.scdx.cloud.user.filter.MyLogoutFilter;
import com.gxa.scdx.cloud.user.filter.MyRolesAuthorizationFilter;
import com.gxa.scdx.cloud.user.realm.UserRealm;
import com.gxa.scdx.cloud.user.socket.ServerThread;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 代宇盛 shiro全部控制
 * @version 1.0
 * @since 2021-06-25 11:06:05
 */
@Configuration
public class ShiroConfig {
    //将自己的验证方式加入容器
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * cookie对象;
     * @return
     */
    public SimpleCookie rememberMeCookie(){
        System.out.println("ShiroConfiguration rememberMeCookie--------------------------------------------");
        //这个参数是cookie的名称
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(30 * 24 * 60 * 60);
        return simpleCookie;
    }

    /**
     * cookie管理对象;记住我功能
     * @return
     */
    public CookieRememberMeManager rememberMeManager(){
        System.out.println("ShiroConfiguration rememberMeManager--------------------------------------------");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("4KaYtkFJPs0KSA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置自定义验证规则
        securityManager.setRealm(userRealm());
        // 设置自定义rememeberMe
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters = new LinkedHashMap<>();
        // 自定义退出LogoutFilter
        MyLogoutFilter myLogoutFilter = new MyLogoutFilter();
        myLogoutFilter.setRedirectUrl("/login.html");
        // 自定义登录处理
        filters.put("authc", new MyFormAuthenticationFilter());
        // 自定义权限处理   权限拦截之后。返回的是json格式数据
        filters.put("roles", new MyRolesAuthorizationFilter());
        // 自定义退出处理
        filters.put("logout", myLogoutFilter);
        shiroFilterFactoryBean.setFilters(filters);//加入把filter加入filter列表

        Map<String, String> map = new LinkedHashMap<>();
        // anon 放行   roles 权限控制   authc 认证   logout 退出
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/register/**","anon");
        map.put("/img/**","anon");
        map.put("/login.html","anon");
        map.put("/login/**","anon");
        map.put("/check","anon");
        map.put("/shiro/login","anon");
        map.put("/register.html","anon");
        map.put("/shiro/register","anon");
        map.put("/autherror.html","anon");
        map.put("/jquery/**","anon");
        map.put("/layui/**","anon");
        map.put("/swagger-resources/**","anon");
        map.put("/webjars/**","anon");
        map.put("/v2/**","anon");
        map.put("/swagger-ui.html/**","anon");
        map.put("/logout","logout");
//        map.put("/index.html","roles[1]");
//        map.put("/index.html","roles[0]");
        map.put("/admin/**","roles[1]");
        map.put("/department/selectForPage","roles[1]");
//        map.put("/admin/updateById","roles[1]");
        map.put("/upgrade/insert", "roles[0]");
        map.put("/upgrade/selectAll","roles[1]");
        map.put("/upgrade/update","roles[1]");
        map.put("/scan/**","anon");
        map.put("/authManage.html","roles[1]");
        //对所有用户认证
        map.put("/**","authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/autherror.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}