# -*- encoding: utf-8 -*-
'''
@File    :   fix.py
@Time    :   2021/06/26 16:04:54
@Author  :   E-11 林佳评 
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib

import os
import sqlite3
import configparser
from Database.my_config_parser import MyConfigParser
from Database.opt_policy_db import select_all


def get_reset_value(conn):
    reset_values = {}
    records = select_all(conn, 'test')
    for record in records:
        item_id = record[0]
        item_name = record[1]
        current_val = record[2]
        recommend_comment = record[4]
        recommend_val = record[5]
        result = record[7]

        if result == '检查不通过':
            print("\n***", item_name, ": ", current_val, "***")
            print("修改建议：", recommend_comment)
            print("修改建议值/区间：", recommend_val)
            reset_values[item_name] = input("请输入修改值：")

    return reset_values


def fix(reset_values):
    # 读取配置文件
    cfg_file_path = "../Database/config.inf"
    config = MyConfigParser()
    config.read(cfg_file_path, encoding='utf-16')

    try:
        i = 0
        for item_name in reset_values.keys():
            config.set("System Access", item_name, reset_values[item_name])
            i += 1
    except configparser.Error:
        print("failed to reset "+item_name+" to "+reset_values[item_name])

    # 写入配置文件
    config.write(open("config.inf", "w", encoding='utf-16'))

    # 利用secedit的导入功能，让更改后的配置生效
    os.popen('secedit /import /db fix.sdb /cfg '+cfg_file_path)
    os.popen('secedit /configure /db fix.sdb /cfg '+cfg_file_path)


def recover():
    # os.popen('secedit /import /db recover.sdb /cfg config-backup.inf')
    os.popen('secedit /configure /db recover.sdb /cfg config-backup.inf')


def fix_main():
    conn = sqlite3.connect('../Database/policy.db')
    reset_values = get_reset_value(conn)
    fix(reset_values)
    conn.close()


if __name__ == '__main__':
    # fix_main()
    recover()
