# -*- encoding: utf-8 -*-
'''
@File    :   IFEO_detection.py
@Time    :   2021/06/11 11:42:56
@Author  :   E-11 林佳评 / dilison 代宇盛
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import winreg
import os

# 获取镜像劫持
def get_IFEOs():
    results = []
    # 根键
    root = winreg.ConnectRegistry(None, winreg.HKEY_LOCAL_MACHINE)
    reg_path = r"SOFTWARE\Microsoft\Windows NT\CurrentVersion\Image File Execution Options"
    
    # 打开连接
    key1 = winreg.OpenKey(root, reg_path)
    idx = 0

    # 查询
    while 1:
        try:
            subkey_name = winreg.EnumKey(key1, idx)
            idx += 1
            subkey = winreg.OpenKey(root, reg_path + '\\' + subkey_name)
            count = 0
            while 1:
                try:
                    n, v, t = winreg.EnumValue(subkey, count)
                    # 存在 debugger 项
                    if n.lower() == 'debugger':
                        if subkey_name != os.path.split(v)[1]:
                            results.append({'original_file': subkey_name, 'actual_executable_file': v})
                    count += 1
                except EnvironmentError:
                    break

                # 关闭连接
                finally:
                    winreg.CloseKey(subkey)
        except EnvironmentError:
            break
    
    # 关闭连接
    winreg.CloseKey(key1)
    winreg.CloseKey(root)
    
    return results


# def main():

#     print("--->开始读取列表...")
#     results = get_IFEOs()
#     print(results)
#     print("<---读取完毕，共检测出%s条映像劫持项" % len(results))
    
#     exit(1)


# if __name__ == "__main__":
#     main()
    
