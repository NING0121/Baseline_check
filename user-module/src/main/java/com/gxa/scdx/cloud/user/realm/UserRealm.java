package com.gxa.scdx.cloud.user.realm;

import com.gxa.scdx.cloud.user.pojo.Admin;
import com.gxa.scdx.cloud.user.service.impl.AdminServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Map;


/**
 * reaml逻辑编写
 *
 * @author 代宇盛
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

public class UserRealm extends AuthorizingRealm {

    @Resource
    private AdminServiceImpl adminService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Object principal = principals.getPrimaryPrincipal();            //获取登录的用户pojo对象
        Admin admin = (Admin)principal;
        Integer role = admin.getRoleId();
        System.out.println("here i am !"+role);
        if(role==1){
            System.out.println("here i am !"+role);
            info.addRole("1");//超级管理员
        }
        if(role==0){
            info.addRole("0");//普通用户
        }

//        String auth = admin.getAuth();
//        System.out.println("AuthorizationInfo principal=" + principal + " user.getAuth()=" + admin.getAuth());
        /*
           根据不同的权限判断可访问的资源
           info.addRole("1")中的形参值，在spring_database.xml中shiroFilter进行配置
        */
//        if("1".equals(auth)){
//            info.addRole("1");
//        }
//        if("2".equals(auth)){
//            info.addRole("2");
//        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Admin admin = null;
        // 把AuthenticationToken实质为UsernamePasswordToken，直接转换即可
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        // 通过service查询用户名是否存在,如果存在把admin封装好
        String username = usernamePasswordToken.getUsername();
        Map<Object,Object> map = this.redisTemplate.opsForHash().entries(username);
        if (map.isEmpty()){
            throw new UnknownAccountException("用户不存在！");
        }
        Map.Entry<Object,Object> entry = map.entrySet().iterator().next();
        String password = (String)entry.getKey();
        Integer roleId = (Integer)entry.getValue();
        admin = new Admin(usernamePasswordToken.getUsername(),password,roleId);


        System.out.println("doGetAuthenticationInfo username=" + admin.getAdminName());
        System.out.println("doGetAuthenticationInfo password=" + admin.getAdminPwd());
        System.out.println("doGetAuthenticationInfo roleId=" + admin.getRoleId());


        //  spring_database.xml文件中已经对此UserRealm bean对象设置了加密方式和次数，固这里无需重复配置，如果xml文件中没有配置，则需要代码配置
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");                      // 加密方式，与注册一致
        hashedCredentialsMatcher.setHashIterations(11);                            // 加密次数，与注册一致
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);           // true是默认值，代表16机制值，如果设置false则为base64
        setCredentialsMatcher(hashedCredentialsMatcher);                           // 保存加密设置
        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminName());    // 以用户名为加密盐值
        String realmName = getName();                                              // 当前realm对象的name，调用父类的getName()方法即可
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getAdminPwd(), credentialsSalt, realmName);
        // 在没有加盐的情况下，三个参数就可以进行初步的简单认证信息对象的包装
//        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
        Admin hh = (Admin) info.getPrincipals().getPrimaryPrincipal();
        return info;
    }
}