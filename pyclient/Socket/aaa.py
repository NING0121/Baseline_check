# -*- encoding: utf-8 -*-
'''
@File    :   client.py
@Time    :   2021/06/12 09:17:22
@Author  :   E-11 林佳评 vagr4nt 王研博修改client_main，checkMissionFromServer，__main__作为测试文件
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import os
import socket
import requests
from multiprocessing import Process

from server_functions import *
# 变量声明
coding = 'GB2312'


filename = {'0': '主机信息',
            '1': '基线核查结果',
            '2': '自启动项检测结果',
            '3': '补丁信息检测结果',
            '4': '服务信息检测结果',
            '5': '映像劫持检测结果',
            '6': '影子账户检测结果'}

menu = '\r\n|' + 'MENU'.center(36, '*') + '|\r\n' + \
       '|' + '* 0——检测主机信息' + '\r\n' + \
       '|' + '* 1——进行基线核查' + '\r\n' + \
       '|' + '* 2——检测自启动项' + '\r\n' + \
       '|' + '* 3——检测补丁信息' + '\r\n' + \
       '|' + '* 4——检测服务信息' + '\r\n' + \
       '|' + '* 5——检测映像劫持' + '\r\n' + \
       '|' + '* 6——检测影子账户(需要以管理员身份运行程序)' + '\r\n' + \
       '|' + '* s——结束核查端程序' + '\r\n' + \
       '|' + '* q——断开连接'

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

        try:
            str_cmd = commend[cmd]
            send_msg = pack_msg('s', -1, ['开始' + str_cmd])[2]
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

def client_main(s):
    while True:
        print(menu)
        send_msg = input('发送指令:\n>')
        if send_msg == 'q':
            print('连接已断开！')
            break
        if send_msg == 's':
            print('核查端程序已结束，连接已断开！')
            break

        method = switch.get(send_msg, default)
        result = method()
        result = str(result)
        result = result.replace('"','')
        result = result.replace('\'','"')
        result = str(1)+str(send_msg)+result
        print(result)
        
        s.send(str(result).encode())
        if result == 1:
            os._exit(0)
        if result == 2:
            break
        return result

def checkMissionFromServer(device_num):
    url = 'http://192.168.163.1:8080'+'/scan/device/'+str(device_num)
    r = requests.get(url).text
    print(r)


def main():
    #client_main()
    host = '192.168.163.1'#socket.gethostname()
    port = 9999
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((host, port))
    client_main(s)
    # parse_client_cmd(s)

if __name__ == '__main__':
    #checkMissionFromServer(1)
    main()
