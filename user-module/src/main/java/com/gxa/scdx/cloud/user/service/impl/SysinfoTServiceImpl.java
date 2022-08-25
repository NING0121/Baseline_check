
package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.mapper.SysinfoTMapper;

import com.gxa.scdx.cloud.user.pojo.Sysinfo_t;
import com.gxa.scdx.cloud.user.service.SysinfoTService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (sysinfo)表服务实现类
 *
 * @author 王研博
 * @author 林佳评 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service("sysinfoTService")
public class SysinfoTServiceImpl implements SysinfoTService {
    @Resource
    private SysinfoTMapper sysinfoTMapper;

    public Map<String, Object> selectAll(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.sysinfoTMapper.selectAll());
        return map;
    };

    public Map<String, Object> countById(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.sysinfoTMapper.countById());
        return map;
    };

    private  String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "Sun", "Mon", "Tue", "Wes", "Thu", "Fri", "Sat" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public Map<String, Object> selectAllTimestamp(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        List<Timestamp> tmplist = this.sysinfoTMapper.selectAllTimestamp();
        Date date;
        ArrayList<String> finaltimeformat = new ArrayList<>();
        for (int i=0; i<tmplist.size();i++)
        {
            date = new Date(tmplist.get(i).getTime());
            SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

            finaltimeformat.add(dateFm.format(date).toString());
        }
        map.put("data", finaltimeformat);
        return map;
    };

    public Map<String, Object> selectForCount(String hostname, String ip, String id) {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.sysinfoTMapper.selectForCount(hostname, ip, id));
        return map;
    }

    public Map<String, Object> selectForPage(int index, String hostname, String ip, String id) {
        // 获取当前表中的总记录
        int tableCount = this.sysinfoTMapper.selectForCount(hostname, ip, id);
        int pageCount = (tableCount - 1) / 10 + 1;
        // 计算每页开始的下标值
        index = (index - 1) * 10;
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "查询成功");
        map.put("pageCount", pageCount);  // 查询的记录总页码
        map.put("count", tableCount);     // 当前表中的总条数
        map.put("data", this.sysinfoTMapper.selectForPage(index, hostname, ip, id));
        return map;
    }

    public Map<String, Object> insert(Sysinfo_t sysinfo_t){
        this.sysinfoTMapper.insert(sysinfo_t);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "新增成功");
        return map;
    };
    public Map<String, Object> updateById(Integer id){
        Map<String, Object> map = new HashMap<>();
        return map;
    };
    public Map<String, Object> deleteById(Integer id){
        this.sysinfoTMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "删除成功");
        return map;
    };
    public Map<String, Object> selectById(Integer id){
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.sysinfoTMapper.selectById(id));
        return map;
    };
}
