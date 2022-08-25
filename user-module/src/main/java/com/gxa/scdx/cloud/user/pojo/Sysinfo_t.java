

package com.gxa.scdx.cloud.user.pojo;

/**
 * (Upgrade) pojo实体
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */
public class Sysinfo_t {

  private long id;
  private String hostname;
  private String ip;
  private String osInfo;
  private String cpuType;
  private String cpuUsage;
  private String listeningPort;
  private String totalMem;
  private String usedMem;
  private String memUsage;
  private java.sql.Timestamp checkTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


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


  public String getOsInfo() {
    return osInfo;
  }

  public void setOsInfo(String osInfo) {
    this.osInfo = osInfo;
  }


  public String getCpuType() {
    return cpuType;
  }

  public void setCpuType(String cpuType) {
    this.cpuType = cpuType;
  }


  public String getCpuUsage() {
    return cpuUsage;
  }

  public void setCpuUsage(String cpuUsage) {
    this.cpuUsage = cpuUsage;
  }


  public String getListeningPort() {
    return listeningPort;
  }

  public void setListeningPort(String listeningPort) {
    this.listeningPort = listeningPort;
  }


  public String getTotalMem() {
    return totalMem;
  }

  public void setTotalMem(String totalMem) {
    this.totalMem = totalMem;
  }


  public String getUsedMem() {
    return usedMem;
  }

  public void setUsedMem(String usedMem) {
    this.usedMem = usedMem;
  }


  public String getMemUsage() {
    return memUsage;
  }

  public void setMemUsage(String memUsage) {
    this.memUsage = memUsage;
  }


  public java.sql.Timestamp getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(java.sql.Timestamp checkTime) {
    this.checkTime = checkTime;
  }

}
