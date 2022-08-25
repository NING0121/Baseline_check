package com.gxa.scdx.cloud.user.pojo;

/**
 * (Task) pojo实体
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */
public class Task {

  private long deviceId;
  private long taskStatus;


  public long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(long deviceId) {
    this.deviceId = deviceId;
  }


  public long getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(long taskStatus) {
    this.taskStatus = taskStatus;
  }

}
