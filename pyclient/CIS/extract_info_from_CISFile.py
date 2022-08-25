# -*- encoding: utf-8 -*-
'''
@File    :   extract_info_from_CISFile.py
@Time    :   2021/06/26 16:03:51
@Author  :   E-11 林佳评 
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib

import csv
import sqlite3
import re


def get_item_info():
    item_infos = []
    fp = open('cis.txt', 'r', encoding='utf-8')
    content = fp.read()

    pattern = re.compile(r" Ensure '(.*[\n]*.*?)'[' '\n]+is[' '\n]+set[' '\n]+to[' '\n]+'(.*[\n]*.*?)'")
    results = re.findall(pattern, content)
    pattern = re.compile(r"Configure '(.*[\n]*.*?)'")
    item_names = re.findall(pattern, content)
    for item_name in item_names:
        results.append((item_name, "Null"))
    results.sort(key=lambda x: x[0])

    pattern = re.compile(r"Description:\n([\s\S]*?)Rationale:\n")
    descriptions = re.findall(pattern, content)
    pattern = re.compile(r"Remediation:\n([\s\S]*?)Impact:\n")
    remediation_paths = re.findall(pattern, content)
    for i in range(len(results)):
        item_name = re.sub('\n', ' ', results[i][0])
        recommend_val = re.sub('\n', ' ', results[i][1])
        description = re.sub('\n', ' ', descriptions[i])
        remediation_path = re.sub('\n', ' ', remediation_paths[i])
        item_infos.append({'item_name': item_name, 'recommend_val': recommend_val, 'description': description,
                           'remediation_path': remediation_path})
    print('total record: ', len(results))
    return item_infos


def insert_item_info(item_infos):
    conn = sqlite3.connect('test.db')
    c = conn.cursor()

    item_id = 0
    for record in item_infos:
        item_id += 1
        item_name = record['item_name']
        print(item_name)
        recommend_val = record['recommend_val']
        note = record['description']
        remediation_path = record['remediation_path']

        c.execute("INSERT INTO security_options (item_id,item_name,recommend_val,item_comment,harden_place,status) \
                  VALUES (?, ?, ?, ?, ?, ?)", (str(item_id), item_name, recommend_val, note, remediation_path, "待检测"))
    conn.commit()


if __name__ == '__main__':
    item_information = get_item_info()
    insert_item_info(item_information)
