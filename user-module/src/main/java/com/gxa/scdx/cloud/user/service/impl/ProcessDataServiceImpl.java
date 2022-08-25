/**
 * @Author: 王研博
 *
 */
package com.gxa.scdx.cloud.user.service.impl;

/**
 * (ProcessData) 服务实现类
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxa.scdx.cloud.user.dto.*;
import com.gxa.scdx.cloud.user.mapper.*;
import com.gxa.scdx.cloud.user.pojo.*;
import com.gxa.scdx.cloud.user.service.ProcessDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service("ProcessDataService")
public class ProcessDataServiceImpl implements ProcessDataService {

    @Resource
    private SysinfoTMapper sysinfoTMapper;
    @Resource
    private BaselineinfoMapper baselineinfoMapper;
    @Resource
    private FirstbootinfoMapper firstbootinfoMapper;
    @Resource
    private PatchinfoMapper patchinfoMapper;
    @Resource
    private ServiceinfoMapper serviceinfoMapper;

    public void insertTest(Sysinfo_t sysinfo_t) {
        sysinfoTMapper.insert(sysinfo_t);
    }


    @Override
    public void process(Integer option, String msg, Integer deviceid) {
        switch(option)
        {
            case 0:
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    List<Sysinfo> sysinfos = mapper.readValue(msg, new TypeReference<List<Sysinfo>>() {
                    });
                    for (int i = 0; i < sysinfos.size(); i++) {
                        Sysinfo tmp = sysinfos.get(i);
                        Sysinfo_t ans = new Sysinfo_t();
                        Date date = new Date();
                        Timestamp timestamp = new Timestamp(date.getTime());
                        ans.setCheckTime(timestamp);
                        ans.setHostname(tmp.getHostname());
                        ans.setIp(tmp.getIp());
                        ans.setCpuType(tmp.getCpu_type());
                        ans.setCpuUsage(tmp.getCpu_usage());
                        ans.setOsInfo(tmp.getOs_info());
                        ans.setMemUsage(tmp.getMem_usage());
                        ans.setTotalMem(tmp.getTotal_mem());
                        ans.setUsedMem(tmp.getUsed_mem());
                        String tmp2s = String.join(",", tmp.getListening_port());
                        ans.setListeningPort(tmp2s);
                        //System.out.println(this.sysinfoTMapper);
                        this.sysinfoTMapper.insert(ans);
                        //System.out.println(tmp.toString());
                    }

                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            case 1:
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    List<Baselineinfo_d> baselineinfos = mapper.readValue(msg, new TypeReference<List<Baselineinfo_d>>() {});
                    for (int i = 0; i < baselineinfos.size(); i++) {
                        Baselineinfo_d tmp = baselineinfos.get(i);
                        Baselineinfo ans = new Baselineinfo();
                        ans.setItemId(tmp.getItem_id());
                        ans.setItemName(tmp.getItem_name());
                        ans.setCurrentVal(tmp.getCurrent_val());
                        ans.setNote(tmp.getNote());
                        ans.setResult(tmp.getResult());
                        ans.setRecommendVal(tmp.getRecommend_val());
                        ans.setRule(tmp.getRule());
                        ans.setRemediationPath(tmp.getRemediation_path());
                        ans.setDeviceId(deviceid);
                        this.baselineinfoMapper.insert(ans);
                    }
                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            case 2:
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    List<FirstBootinfo_d> firstBootinfos = mapper.readValue(msg, new TypeReference<List<FirstBootinfo_d>>() {});
                    for (int i = 0; i < firstBootinfos.size(); i++) {
                        FirstBootinfo_d tmp = firstBootinfos.get(i);
                        Firstbootinfo ans = new Firstbootinfo();
                        ans.setAutorunIten(tmp.getAutorun_item());
                        ans.setPath(tmp.getPath());
                        ans.setDeviceId(deviceid);
                        this.firstbootinfoMapper.insert(ans);
                    }
                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            case 3:
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    List<Patchinfo_d> patchinfos = mapper.readValue(msg, new TypeReference<List<Patchinfo_d>>() {});
                    for (int i = 0; i < patchinfos.size(); i++) {
                        Patchinfo_d tmp = patchinfos.get(i);
                        Patchinfo ans = new Patchinfo();
                        ans.setDescription(tmp.getDescription());
                        ans.setInstalledBy(tmp.getInstalled_by());
                        Date date = tmp.getInstalled_on();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(date);
                        ans.setInstalledOn(dateString);
                        ans.setPatchId(tmp.getPatch_id());
                        ans.setDeviceId(deviceid);
                        this.patchinfoMapper.insert(ans);
                    }
                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            case 4:
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    List<Serviceinfo_d> serviceinfos = mapper.readValue(msg, new TypeReference<List<Serviceinfo_d>>() {});
                    for (int i = 0; i < serviceinfos.size(); i++) {
                        Serviceinfo_d tmp = serviceinfos.get(i);
                        Serviceinfo ans = new Serviceinfo();
                        ans.setServiceName(tmp.getService_name());
                        ans.setBinaryPathName(tmp.getBinary_path_name());
                        ans.setDeviceId(deviceid);
                        ans.setDisplayName(tmp.getDisplay_name());
                        ans.setStartType(tmp.getStart_type());
                        ans.setState(tmp.getState());
                        this.serviceinfoMapper.insert(ans);
                    }
                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            case 5:
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    List<ImageHijackinfo> imageHijackinfos = mapper.readValue(msg, new TypeReference<List<ImageHijackinfo>>() {});
                    System.out.println(imageHijackinfos);
                }
                catch  (IOException e){
                    e.printStackTrace();}
                break;
            default:
                break;
        }
    }
}
