# -*- encoding: utf-8 -*-
'''
@File    :   get_autorun_info.py
@Time    :   2021/06/11 14:48:46
@Author  :   E-11 林佳评 
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import winreg

# 扫描注册表
def scan_regedit(root, reg_path):
    results = []
    key = winreg.OpenKey(root, reg_path)
    try:
        count = 0
        while 1:
            try:
                n, v, t = winreg.EnumValue(key, count)
                results.append({'autorun_item': n, 'path': v})
                count += 1
            except EnvironmentError:
                break
    finally:
        winreg.CloseKey(key)
    return results


# 读取自启动项
def get_autorun_info():
   
    # 第一个根路径
    root = winreg.HKEY_CURRENT_USER
    # 需要扫描的路径
    reg_paths = [r"SOFTWARE\Microsoft\Windows\CurrentVersion\Run", r"SOFTWARE\Microsoft\Windows\CurrentVersion\RunOnce"]
    
    for reg_path in reg_paths:
        results = scan_regedit(root, reg_path)

    # 第二个根路径
    root = winreg.HKEY_LOCAL_MACHINE
    # 需要扫描的路径
    reg_paths = [r"SOFTWARE\Microsoft\Windows\CurrentVersion\Run", r"SOFTWARE\Microsoft\Windows\CurrentVersion\RunOnce",
                 r"SOFTWARE\Wow6432Node\Microsoft\Windows\CurrentVersion\Run",
                 r"SOFTWARE\Wow6432Node\Microsoft\Windows\CurrentVersion\RunOnce"]
    
    for reg_path in reg_paths:
        results += scan_regedit(root, reg_path)

    return results

# def main():
#     print("--->开始读取自启动列表 ")
#     results = get_autorun_info()
#     for result in results:
#         print(result['autorun_item'], ':', result['path'])
#     print("<---读取完毕，注册表共有%s个自启动项" % len(results))


# if __name__ == "__main__":
#     main()
