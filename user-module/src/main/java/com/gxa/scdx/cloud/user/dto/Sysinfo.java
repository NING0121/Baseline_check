
package com.gxa.scdx.cloud.user.dto;

import java.util.List;


/**
 * (Sysinfo) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */
public class Sysinfo {
    public Sysinfo(){

    }
    private String hostname;
    private String ip;
    private String os_info;
    private String cpu_type;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs_info() {
        return os_info;
    }

    public void setOs_info(String os_info) {
        this.os_info = os_info;
    }

    public String getCpu_type() {
        return cpu_type;
    }

    public void setCpu_type(String cpu_type) {
        this.cpu_type = cpu_type;
    }

    public String getCpu_usage() {
        return cpu_usage;
    }

    public void setCpu_usage(String cpu_usage) {
        this.cpu_usage = cpu_usage;
    }

    public List<String> getListening_port() {
        return listening_port;
    }

    public void setListening_port(List<String> listening_port) {
        this.listening_port = listening_port;
    }

    public String getTotal_mem() {
        return total_mem;
    }

    public void setTotal_mem(String total_mem) {
        this.total_mem = total_mem;
    }

    public String getUsed_mem() {
        return used_mem;
    }

    public void setUsed_mem(String used_mem) {
        this.used_mem = used_mem;
    }

    public String getMem_usage() {
        return mem_usage;
    }

    public void setMem_usage(String mem_usage) {
        this.mem_usage = mem_usage;
    }

    private String cpu_usage;
    private List<String> listening_port;
    private String total_mem;
    private String used_mem;
    private String mem_usage;
}
