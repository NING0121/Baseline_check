# -*- encoding: utf-8 -*-
'''
@File    :   get_patch_info.py
@Time    :   2021/06/26 16:07:11
@Author  :   NING 王楠楠 
@Version :   1.0
@Contact :   1104120243@qq.com
'''

# here put the import lib

import wmi
import csv
import time


# 获取最近更新时间 和 补丁总数
def get_summary():
    '''
    思路: 利用时间戳大小进行比较
    格式化字符转为时间戳（例）
    a = "Sat Mar 28 22:24:24 2016"
    print time.mktime(time.strptime(a,"%a %b %d %H:%M:%S %Y"))
    '''
    patch_list = get_patch_info()

    # 首先将最新日期设为时间戳的最早日期 即 1/1/1970
    last_day = ("1/1/1970",time.mktime((1970, 1, 1, 8, 0, 0, 0, 1, 0)))

    total_num = 0
    
    # 遍历更新 last_day
    for count, patch_item in enumerate(patch_list):
        time_stamp = time.mktime(time.strptime(patch_item['installed_on'], '%m/%d/%Y'))

        # 选择最大的作为 last_day
        if time_stamp > last_day[1]:
            last_day = (patch_item['installed_on'], time_stamp)

        # 总数为 count + 1（count从0开始）
        total_num = count + 1 
    
    return last_day[0] , total_num


# 获取补丁信息
def get_patch_info():

    # 用于获取windows更新补丁相关信息
    update_obj = wmi.WMI().Win32_QuickFixEngineering()

    # 存放每个补丁信息，list[dic_1{},dic_2{}……]
    results = []
    for s in update_obj:
        results.append({'patch_id': s.HotFixID, 'installed_on': s.InstalledOn, 'description': s.Description,
                        'installed_by': s.InstalledBy})

    return results


# 打印到 CSV
def get_patch_csv(file_path):
    # 获取补丁 最新时间、总数
    last_time, total_num = get_summary()
    
    # 获取补丁详细内容列表
    patch_list = get_patch_info()

    # 文件书写
    with open(file_path, "w+", encoding="utf-8") as f:
        writer = csv.writer(f)
        writer.writerow(["total number:",total_num,"Last Update Time:",last_time])
        writer.writerow(["补丁ID", "安装位置", "描述", "安装时间"])
        writer.writerows(patch_list)



# def main():
#     results = get_patch_info()
#     last_day , sum = get_summary()
#     print('--->Windows更新列表：')
#     for item in results:
#         print(item.values())
    
#     print("最后升级日期：", last_day)
#     print("补丁总数：", sum )


# if __name__ == '__main__':
#     main()
