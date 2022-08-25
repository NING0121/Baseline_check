# -*- encoding: utf-8 -*-
'''
@File    :   get_policy.py
@Time    :   2021/06/14 15:45:18
@Author  :   NING 王楠楠 
@Version :   1.0
@Contact :   1104120243@qq.com
'''

# here put the import lib
import sys
sys.path.append("./")

from utils.util import update
import sqlite3

def get_policy():
    # 连接数据库
    conn = sqlite3.connect('../resources/baseline.db')
    table_name = 'policy'
    
    # 更新 policy 最新值
    update()
    

    # 定义游标对象
    cursor = conn.cursor()

    # 获取所有内容
    records = cursor.execute("SELECT * from " + table_name)
    
    result_records = []

    # 逐个赋值
    for record in records:
        item_id = record[0]
        item_name = record[1]
        current_val = record[2]
        recommend_val = record[5]
        note = record[9]
        remediation_path = record[8]
        rule = record[6]
        result = record[7]

        result_records.append({'item_id': item_id, 'item_name': item_name, 'current_val': current_val,\
                               'recommend_val': recommend_val, 'rule': rule, 'result': result,
                               'remediation_path': remediation_path, 'note': note})

    conn.close()
    return result_records

# if __name__ =="__main__":
#     result = get_policy()
#     print(result)