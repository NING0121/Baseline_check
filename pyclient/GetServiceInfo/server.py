# -*- encoding: utf-8 -*-
'''
@File    :   util.py
@Time    :   2021/06/09 14:59:49
@Author  :   NING 王楠楠 / dilison 代宇盛
@Version :   1.0
@Contact :   1104120243@qq.com
'''

# here put the import lib
from os import pipe
import subprocess
import ctypes
import codecs
from sys import winver
import re
import csv

import pandas as pd 
import numpy as np 


BINARY_PATH_NAME = []
START_TYPE = []
START_NUM = []


# 运行cmd
def run_code(cmd):
    res = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    for line in res.communicate():
        return line.decode("GB2312")


def find_2(service_name):

    cmd = "sc qc "+ service_name    
    result = run_code(cmd)
    pattern_1 = re.compile(r"START_TYPE         :\s(\d*)\s*(\S*)")
    pattern_2 = re.compile(r'BINARY_PATH_NAME   :\s(\S*)')
    match_1 = pattern_1.search(result)
    match_2 = pattern_2.search(result)
    if match_1 == None:
        return None,None,None
    return match_1.group(1), match_1.group(2), match_2.group(1)

def find(x):
    startnum,starttype,path = find_2(x)
    START_NUM.append(startnum)
    START_TYPE.append(starttype)
    BINARY_PATH_NAME.append(path)
    return 

df = pd.read_csv("./server.csv")
df["SERVICE_NAME"].apply(find)
df["START_TYPE_NUM"] = START_NUM
df["START_TYPE"] =  START_TYPE
df["BINARY_PATH_NAME"] = BINARY_PATH_NAME
df.to_csv("./server.csv",encoding="utf_8_sig")