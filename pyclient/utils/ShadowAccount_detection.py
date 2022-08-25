# -*- encoding: utf-8 -*-
'''
@File    :   ShadowAccount_detection.py
@Time    :   2021/06/11 11:44:06
@Author  :   E-11 林佳评 / dilison 代宇盛
@Version :   1.0
@Contact :   974879729@qq.com
'''

# here put the import lib
import winreg
import re
import subprocess


# 获取影子账户
def get_shadow_accounts():
    # 根键
    root = winreg.ConnectRegistry(None, winreg.HKEY_LOCAL_MACHINE)

    reg_path = r"SAM\SAM\Domains\Account\Users"
    key1 = winreg.OpenKey(root, reg_path)
    key2 = winreg.OpenKey(root, reg_path + '\\Names')


    f_values = {}
    exception = {}
    idx = 0

    while 1:
        try:
            subkey_name = winreg.EnumKey(key1, idx)
            idx += 1
            subkey = winreg.OpenKey(root, reg_path + '\\' + subkey_name)
            try:
                f_value, _ = winreg.QueryValueEx(subkey, 'F')
                subkey_name = '0x' + subkey_name
                subkey_name = int(subkey_name, 16)
                if f_value in f_values.keys():
                    exception[subkey_name] = f_values[f_value]
                else:
                    f_values[f_value] = subkey_name
            finally:
                winreg.CloseKey(subkey)
        except EnvironmentError:
            break

    idx = 0
    name_to_type = {}
    
    while 1:
        try:
            subkey_name = winreg.EnumKey(key2, idx)
            idx += 1
            subkey = winreg.OpenKey(root, reg_path + '\\Names\\' + subkey_name)
            _, names_type = winreg.QueryValueEx(subkey, None)
            name_to_type[names_type] = subkey_name
        except EnvironmentError:
            break
    winreg.CloseKey(key1)
    winreg.CloseKey(key2)
    winreg.CloseKey(root)

    results = []
    for hex_index in exception.keys():
        account1 = name_to_type[hex_index]
        account2 = name_to_type[exception[hex_index]]
        if account1 not in get_normal_user():
            results.append({'shadow_account': account1, 'real_account': account2})
        else:
            results.append({'shadow_account': account2, 'real_account': account1})
    return results


# 获取正常账户
def get_normal_user():
    # 系统命令
    p = subprocess.Popen(['net', 'user'], shell=True, stdout=subprocess.PIPE)
    
    # 获取命令返回值
    content = p.stdout.read().decode('GB2312')

    # 正则匹配
    pattern = re.compile(r"--\r\n([\S\s]*)命令")
    content = re.findall(pattern, content)
    
    accounts = re.split(r"[\s]+", content[0].strip())

    return accounts



# def main():

#     get_normal_user()
#     print("--->开始读取列表...")
#     results = get_shadow_accounts()
#     for result in results:
#         print(result)
#     print("<---读取完毕，共检测出%s个影子账户" % len(results))

#     exit(1)

# if __name__ == "__main__":
#     main()
