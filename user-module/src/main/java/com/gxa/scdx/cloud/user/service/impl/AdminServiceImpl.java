package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.pojo.Admin;
import com.gxa.scdx.cloud.user.mapper.AdminMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Pattern;


/**
 * (Admin)表服务实现类
 *
 * @author 代宇盛
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service("adminService")
public class AdminServiceImpl {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public AdminServiceImpl() {
    }

    public Admin getUser(String username) {
        return this.adminMapper.getUser(username);
    }

    public Map<String, Object> registerUser(String username, String password, String phone) {
        Map<String, Object> map = this.checkForm(username, password, phone);
        if ((Integer)map.get("code") == 200){
            try {
                Timestamp createTime = new Timestamp(System.currentTimeMillis());
                adminMapper.registerUser(username, password, createTime, phone);
                // 当mysql插入成功之后，那么紧接着就要插入redis，完成读写分离的第一步
                redisTemplate.opsForHash().put(username, password, 0);
                map.put("code", 200);
                map.put("msg", "注册成功");
            } catch (Exception e) {
                map.put("code", 500);
                map.put("msg", "用户已存在！");
            }
        }
        return map;
    }

    private Map<String, Object> checkForm(String username, String password, String phone){
        Map<String, Object> map = new HashMap<>();
        String npattern = "^[a-zA-Z]\\w{2,21}$*";
        String ppattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{5,21}";
        String phpattern = "[0-9]{11}";
        if (!Pattern.matches(npattern, username)){
            map.put("code", 200);
            map.put("msg", "用户名请以字母开头,长度为3-20个字符");
        }
        else if (!Pattern.matches(ppattern, password)){
            map.put("code", 200);
            map.put("msg", "密码长度为6-20个字符，必须同时包含大小写字母以及至少 1 个数字和特殊字符");
        }
        else if (!Pattern.matches(phpattern, phone)){
            map.put("code", 200);
            map.put("msg", "电话号码格式错误");
        }
        else{
            map.put("code", 200);
            map.put("msg", "校验通过");
        }
        return map;
    }

    public Map<String, Object> selectForCount(String search_username, String search_phone, String search_start_time, String search_end_time) {
        Map<String, Object> map = new HashMap();
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.adminMapper.selectForCount(search_username, search_phone, search_start_time, search_end_time));
        return map;
    }

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    public Map<String, Object> selectAll() {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.adminMapper.selectAll());
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Map<String, Object> selectById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("obj", this.adminMapper.selectById(id));
        return map;
    }

    /**
     * 查询分页数据
     *
     /**
     * 通过主键查询单条数据
     * @param index  需要查询起始页面
     * @param search_username 模糊查询用户名称
     * @param search_phone     模糊查询手机号
     * @param search_start_time     模糊查询手机号
     * @param search_end_time     模糊查询手机号
     * @return 单条数据
     */
    public Map<String, Object> selectForPage(int index, String search_username, String search_phone, String search_start_time, String search_end_time) {

        // 获取页面数据
        int tableCount = this.adminMapper.selectForCount(search_username, search_phone, search_start_time, search_end_time);
        int pageCount = (tableCount - 1) / 10 + 1;
        index = (index - 1) * 10;
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("pageCount", pageCount);
        map.put("count", tableCount);
        map.put("data", this.adminMapper.selectForPage(index, search_username, search_phone, search_start_time, search_end_time));
        return map;
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Map<String, Object> insert(Admin admin) {
        // UUID.randomUUID()  返回内容：asd21321-ewrewrew213213-123213zsad-123asdasd这样的形态
        this.redisTemplate.opsForHash().put(admin.getAdminName(),admin.getAdminPwd(), 0);
        this.adminMapper.insert(admin);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "新增成功");
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Map<String, Object> updateById(Admin admin) {
        System.out.println(admin);
        if (admin.getAdminPwd() != null) {
            Map<String, Object> map = this.selectById(admin.getId());
            System.out.println(map);
            Admin checkedadmin = (Admin)map.get("obj");
            String password = this.md5(admin.getAdminName(), admin.getAdminPwd());
            admin.setAdminPwd((String)null);
            if (checkedadmin.getAdminPwd() != password) {
                admin.setAdminPwd(password);
                this.redisTemplate.opsForHash().put(admin.getAdminName(), password,0);
            }
        }

        //校验权限是否改变，这里认为前端之后在该role权限的时候才会改权限,改密码的时候不会改权限
        if (admin.getRoleId() != null){
            this.redisTemplate.opsForHash().put(admin.getAdminName(),  admin.getAdminPwd(),admin.getRoleId());
        }

        this.adminMapper.updateById(admin);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "更新成功");
        return map;
    }

    private String md5(String username, String password) {
        String hashAlgorithmName = "MD5";
        ByteSource salt = ByteSource.Util.bytes(username);
        int hashIterations = 11;
        return (new SimpleHash(hashAlgorithmName, password, salt, hashIterations)).toString();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public Map<String, Object> deleteById(Integer id) {
        //radis删除,先查后删
        Admin admin = this.adminMapper.selectById(id);
        this.redisTemplate.opsForHash().delete(admin.getAdminName(), admin.getAdminPwd());
        this.adminMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "删除成功");
        return map;
    }

    public Map<String, Object> updateByName(Admin admin) {

        this.adminMapper.updateByName(admin);
        System.out.println(admin.getRoleId());

        if(admin.getRoleId()!=null){
            Map<Object,Object> map_k = this.redisTemplate.opsForHash().entries(admin.getAdminName());
            System.out.println(map_k);
            Set set = map_k.keySet();
            List list=new ArrayList(set);
            System.out.println(list.get(0));
            this.redisTemplate.opsForHash().delete(admin.getAdminName(), list.get(0));
            this.redisTemplate.opsForHash().put(admin.getAdminName(), list.get(0), 1);
        }


        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "更新成功");
        return map;

    }
}
