# -*- encoding: utf-8 -*-
'''
@File    :   server_functions.py
@Time    :   2021/06/12 09:19:59
@Author  :   E-11 林佳评 / NING 王楠楠 / dilison 代宇盛
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import json
import struct
import os
import sys


sys.path.append(os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))
sys.path.append(r"./")
sys.path.append(r"../")

from utils.get_patch_info import get_patch_info
from utils.get_autorun_info import get_autorun_info
from utils.get_sys_info import get_sys_info
from utils.IFEO_detection import get_IFEOs
from utils.ShadowAccount_detection import get_shadow_accounts
from utils.get_policy import *



from GetServiceInfo.get_service_info import get_service_info

# from Fix.fix import fix_main

coding = 'GB2312'




# 打包数据
def pack_msg(notice, package_num, data):

    # 
    header = struct.pack('si', notice.encode(coding), package_num)

    header_len = len(header)  # 8

    if data is not None:
        body = json.dumps(data).encode(coding)
        body_len = len(body)
        send_msg = header + body
    else:
        body_len = 0
        send_msg = header

    return header_len, body_len, send_msg


# 发送数据
def send_data(info_header, info, clientSocket):
    # 缓冲区大小
    buffer = 2048


    data = [info_header, info]
    header_len, body_len, send_msg = pack_msg('r', -1, data)
    max_body_len = buffer - header_len
    body = send_msg[header_len:]
    i = 0
    while body_len > 0:
        if body_len >= max_body_len:
            body_pack = body[i * max_body_len:(i + 1) * max_body_len]
            _, _, header_pack = pack_msg('r', i, None)
            clientSocket.send(header_pack + body_pack)
            body_len -= max_body_len
            i += 1
        else:
            body_pack = body[i * max_body_len:]
            _, _, header_pack = pack_msg('r', -1, None)
            clientSocket.send(header_pack + body_pack)
            body_len = 0


# 自启动项
def server_autorun_info():
    autorun_info = get_autorun_info()
    return autorun_info
    # header = ['自启动项', '自启动文件路径']
    info_header = ['autorun_item', 'path']
    send_data(info_header, autorun_info, clientSocket)
    return 0


# 补丁信息
def server_patch_info():
    patch_info = get_patch_info()
    return patch_info
    info_header = ['patch_id', 'installed_on', 'description', 'installed_by']
    send_data(info_header, patch_info, clientSocket)
    return 0


# 服务信息
def server_service_info():
    service_info = get_service_info()
    return service_info
    # header = ['服务显示名称', '服务名', '启动类型', '状态', '二进制文件路径']
    info_header = ['display_name', 'service_name', 'start_type', 'state', 'binary_path_name']
    send_data(info_header, service_info, clientSocket)
    return 0


# 系统基本信息
def server_sys_info():
    sys_info = get_sys_info()
    return sys_info
    info_header = ['hostname', 'ip', 'os_info', 'cpu_type', 'cpu_usage', 'listening_port', 'total_mem', 'used_mem','mem_usage']
    send_data(info_header, sys_info, clientSocket)
    return 0


# 镜像劫持检查
def server_IFEO_info():
    IFEO_info = get_IFEOs()
    return IFEO_info
    info_header = ['original_file', 'actual_executable_file']
    send_data(info_header, IFEO_info, clientSocket)
    return 0


# 影子账户检查
def server_shadow_accounts_info():
    shadow_account_info = get_shadow_accounts()
    return shadow_account_info
    # header = ['影子账户', '实际账户']
    info_header = ['shadow_account', 'real_account']
    send_data(info_header, shadow_account_info, clientSocket)
    return 0


# 基线检查
def server_baseline_check():
    baseline_check_info = get_policy()
    return baseline_check_info
    info_header = ['item_id', 'item_name', 'current_val', 'recommend_val', 'rule', 'result', 'remediation_path', 'note']
    send_data(info_header, baseline_check_info, clientSocket)
    return 0


# 服务器关闭
def server_shutdown(clientSocket):
    return 1


# 客户端退出
def client_quit(clientSocket):
    return 2


# 默认
def default(clientSocket):
    send_msg = pack_msg('e', -1, ['命令不正确，请重新输入'])[2]
    clientSocket.send(send_msg)
    return 0
