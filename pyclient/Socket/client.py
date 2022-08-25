# -*- encoding: utf-8 -*-
'''
@File    :   client.py
@Time    :   2021/06/12 09:17:22
@Author  :   E-11 林佳评 / NING 王楠楠 / dilison 代宇盛
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import os
import socket
from multiprocessing import Process

from server_functions import *
# 变量声明
coding = 'GB2312'

# 操作指令
commend = {'0': '检测主机信息',
           '1': '进行基线核查',
           '2': '检测自启动项',
           '3': '检测补丁信息',
           '4': '检测服务信息',
           '5': '检测映像劫持',
           '6': '检测影子账户',
           's': '结束核查端程序',
           'q': '断开连接'}


# 定义对应操作
switch = {'0': server_sys_info,
          '1': server_baseline_check,
          '2': server_autorun_info,
          '3': server_patch_info,
          '4': server_service_info,
          '5': server_IFEO_info,
          '6': server_shadow_accounts_info,
          's': server_shutdown,
          'q': client_quit}


# 处理连接
def parse_client_cmd(clientSocket):
    while True:
        # 解码
        cmd = clientSocket.recv(128).decode(coding)
        print('cmd',cmd)
        try:
            str_cmd = commend[cmd]
            print('str_cmd',str_cmd)
            send_msg = pack_msg('s', -1, ['开始' + str_cmd])[2]
            print('send_msg',send_msg)
            clientSocket.send(send_msg)
        except KeyError:
            str_cmd = '错误的指令'

        method = switch.get(cmd, default)
        result = method(clientSocket)

        if result == 1:
            os._exit(0)
        if result == 2:
            break

    clientSocket.close()

def main():
    host = socket.gethostname()
    port = 9999
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((host, port))
    parse_client_cmd(s)

if __name__ == '__main__':
    main()
