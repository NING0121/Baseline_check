# -*- encoding: utf-8 -*-
'''
@File    :   get_sys_info.py
@Time    :   2021/06/26 16:07:23
@Author  :   E-11 林佳评 
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib

import platform
import socket
import os
import psutil
import csv

# 获取系统服务
def get_svc():
    for item in list(psutil.win_service_iter()):
        svc_name = item.name()
        svc_detail = psutil.win_service_get(svc_name)

        print(svc_detail, item.start_type())

# 获取系统信息
def get_sys_info():
    # 存放所有信息
    sys_info = {}

    # HOSTNAME
    hostname = socket.gethostname()
    sys_info["hostname"] = hostname
    
    # IP
    ip = socket.gethostbyname(hostname)
    sys_info["ip"] = ip
    
    # 操作系统
    system = platform.uname()[0]
    version = platform.uname()[3]

    sys_info["os_info"] = f'{system} {version}'
    

    # CPU 类型
    cpu_type = platform.processor()
    sys_info["cpu_type"] = cpu_type


    cpu_usage =  f'{psutil.cpu_percent()}%'
    sys_info["cpu_usage"] = cpu_usage
 
    # 监听端口
    listening_port = []
    
    net_info = os.popen('netstat -nao | findstr LISTENING')            # 命令执行
    line = net_info.readline()

    while line:        # 读取端口号
        items = line.split("    ")
        port = items[1].split(":")[-1]
        listening_port.append(port)
        line = net_info.readline()

    sys_info["listening_port"] = listening_port
    


    # 系统内存
    mem = psutil.virtual_memory()
    total_mem = mem.total/(1024*1024*1024)          # 总内存,单位为 GB
    used_mem = mem.used/(1024*1024*1024)            # 使用内存,单位为 GB
    used_mem_per = mem.percent                      # 使用占比 %


    sys_info["total_mem"] = f'{total_mem} GB '
    sys_info["used_mem"] = f'{used_mem} GB '
    sys_info["mem_usage"] = f'{used_mem_per}% '

    result = [sys_info]

    return result

# def main():
#     result = get_sys_info()
#     sys_info = result[0]
#     file = open('resources/sys_info.csv', 'w', encoding='utf-8')
#     csv_writer = csv.writer(file)
#     csv_writer.writerow(list(sys_info.keys()))
#     csv_writer.writerow(list(sys_info.values()))
#     file.close()
#     print("write into file sys_info.csv")
#     exit(1)

# if __name__ == '__main__':
#     main()
