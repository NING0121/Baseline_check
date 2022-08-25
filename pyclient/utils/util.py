# -*- encoding: utf-8 -*-
'''
@File    :   util.py
@Time    :   2021/06/09 14:59:49
@Author  :   NING 王楠楠
@Version :   1.0
@Contact :   1104120243@qq.com
'''

# here put the import lib
import sys
sys.path.append("./")

import subprocess
import ctypes
import codecs
from DB.DBOperator import DBOperator

db_path = '../resources/baseline.db'
cfg_path = "../resources/secpolicy.cfg" 
csv_path = '../resources/policy_data.csv'
dic = {}

# 获取管理员权限
def is_admin():
    try:
        return ctypes.windll.shell32.IsUserAnAdmin()
    except:
        return False


# 运行cmd
def run_code(cmd):
    res = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    for line in res.communicate():
        return line.decode("GB2312")


# 获取 cfg 文件
def get_policy_cfg(cmd="secedit /export /cfg resources/secpolicy.cfg"):
    # 管理员权限
    if is_admin():

        # 运行cmd
        run_code(cmd)

    else:
        ctypes.windll.shell32.ShellExecuteW(None, "runas", sys.executable, __file__, None, 1)


# 读取 cfg 文件
def read_policy_cfg(file_path):
    # 用于存储
    dic = {}

    # 打开文件
    with codecs.open(file_path, 'r+', 'utf-16') as f:
        for line in f.readlines():
            line = line.strip('\r\n')  # 去除换行
            name = line.split('=')[0].strip()
            try:
                val = line.split('=')[1].strip()
                dic[name] = val
            except:
                continue

    return dic


def update(db_path = db_path,cfg_path = cfg_path, csv_path = csv_path):

    # 对象
    dbo = DBOperator()

    # 获取cfg文件
    get_policy_cfg()

    # 读取文件生成字典
    dic = read_policy_cfg(cfg_path)

    # 更新数据库
    dbo.updatedb(db_path, dic)
    
    # 存储文件
    dbo.export2csv(csv_path)



# if __name__ == "__main__":
#     update()
#     exit(1)