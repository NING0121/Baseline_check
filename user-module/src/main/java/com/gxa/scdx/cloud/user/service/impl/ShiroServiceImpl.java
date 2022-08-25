package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.mapper.*;
import com.gxa.scdx.cloud.user.pojo.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * (Shiro) 服务实现类
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service
public class ShiroServiceImpl {

    @Resource
    private AdminMapper adminMapper;

    public Map<String, Object> getuser(){
        Map<String, Object> map = new HashMap<>();
        Admin sysUser = (Admin) SecurityUtils.getSubject().getPrincipal();
        String username = sysUser.getAdminName();
        map.put("username",username);
        map.put("userId", sysUser.getRoleId());
        return map;
    }

    public Map<String, Object> selectUser(String username, String password) {
        System.out.println(username);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 506);
        map.put("msg", "用户认证不成功");
        Subject currentUser = SecurityUtils.getSubject();                                     // shiro权限认证主体对象
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);    // shiro权限认证类型
            upToken.setRememberMe(true);                                                     // 用户登录时效性
            try {
                currentUser.login(upToken);    // 调用realm认证用户权限
                Date date = new Date();

                Admin admin = new Admin();

                admin.setAdminName(username);
                admin.setLastLoginTime(date);

                adminMapper.updateByName(admin);
                map.put("code", 200);
                map.put("msg", "登录成功");
                map.put("authority", adminMapper.getUser(username).getRoleId());
            } catch (IncorrectCredentialsException ice) {
                map.put("code", 501);
                map.put("msg", "用户名/密码不匹配！");
                System.out.println("用户名/密码不匹配！");
            } catch (LockedAccountException lae) {
                map.put("code", 501);
                map.put("msg", "账户已被冻结！");
                System.out.println("账户已被冻结！");
            } catch (UnknownAccountException uae) {
                map.put("code", 501);
                map.put("msg", "账户不存在!");
                System.out.println("账户不存在");
            } catch (AuthenticationException ae) {
                map.put("code", 501);
                map.put("msg", "额外的错误");
                System.out.println("额外的错误");
                System.out.println(ae.getMessage());
            }
        }
        return map;
    }

    /**
     * @Author: 王研博
     *
     */
    @Resource
    private BaselineinfoMapper baselineinfoMapper;
    @Resource
    private FirstbootinfoMapper firstbootinfoMapper;
    @Resource
    private PatchinfoMapper patchinfoMapper;
    @Resource
    private ServiceinfoMapper serviceinfoMapper;
    @Resource
    private SysinfoTMapper sysinfoTMapper;
    public Map<String, Object> countById(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.sysinfoTMapper.countById()+this.serviceinfoMapper.countById()+this.patchinfoMapper.countById()
        +this.firstbootinfoMapper.countById()+this.baselineinfoMapper.countById());
        return map;
    };

    /**
     * @Author: 王研博
     *
     */
    public Map<String, Object> getAllCounts(){
        Map<String, Object> map = new HashMap<>();
        List allCounts = new ArrayList();
        allCounts.add(this.sysinfoTMapper.countById());
        allCounts.add(this.serviceinfoMapper.countById());
        allCounts.add(this.patchinfoMapper.countById());
        allCounts.add(this.firstbootinfoMapper.countById());
        allCounts.add(this.baselineinfoMapper.countById());
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", allCounts);
        return map;
    };
}
