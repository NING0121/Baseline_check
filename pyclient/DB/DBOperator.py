# -*- encoding: utf-8 -*-
'''
@File    :   DBOperator.py
@Time    :   2021/06/11 14:13:22
@Author  :   NING 
@Version :   1.0
@Contact :   1104120243@qq.com
'''

# here put the import lib
import sys
sys.path.append("./")
import sqlite3
import csv
from utils.get_patch_info import get_patch_info


class DBOperator(object):
    '''
    数据库操作对象
    通过updatedb方法更新数据库
    policy_list存储数据结果
    '''
    # 属性
    policy_list = []
    service_list= []

    # SID转换
    convert_SID = {
        "*S-1-0": "Null Authority",
        "*S-1-0-0": "Nobody",
        "*S-1-1": "World Authority",
        "*S-1-1-0": "Everyone",
        "*S-1-2": "Local Authority",
        "*S-1-2-0": "Local",
        "*S-1-3": "Creator Authority",
        "*S-1-3-0": "Creator Owner",
        "*S-1-3-1": "Creator Group",
        "*S-1-3-4": "Owner Rights",
        "*S-1-4": "Non-unique Authority",
        "*S-1-5": "NT Authority",
        "*S-1-5-1": "Dialup",
        "*S-1-5-2": "Network",
        "*S-1-5-3": "Batch",
        "*S-1-5-4": "Interactive",
        "*S-1-5-5-X-Y": "Logon Session",
        "*S-1-5-6": "Service",
        "*S-1-5-7": "Anonymous",
        "*S-1-5-9": "Enterprise Domain Controllers",
        "*S-1-5-10": "Principal Self",
        "*S-1-5-11": "Authenticated Users",
        "*S-1-5-12": "Restricted Code",
        "*S-1-5-13": "Terminal Server Users",
        "*S-1-5-14": "Remote Interactive Logon",
        "*S-1-5-17": "IUSR",
        "*S-1-5-18": "Local System",
        "*S-1-5-19": "NT Authority",
        "*S-1-5-20": "NT Authority",
        "*S-1-5-21domain-500": "Administrator",
        "*S-1-5-21domain-501": "Guest",
        "*S-1-5-21domain-502": "KRBTGT",
        "*S-1-5-21domain-512": "Domain Admins",
        "*S-1-5-21domain-513": "Domain Users",
        "*S-1-5-21domain-514": "Domain Guests",
        "*S-1-5-21domain-515": "Domain Computers",
        "*S-1-5-21domain-516": "Domain Controllers",
        "*S-1-5-21domain-517": "Cert Publishers",
        "*S-1-5-21root domain-518": "Schema Admins",
        "*S-1-5-21root domain-519": "Enterprise Admins",
        "*S-1-5-21domain-520": "Group Policy Creator Owners",
        "*S-1-5-21domain-526": "Key Admins",
        "*S-1-5-21domain-527": "Enterprise Key Admins",
        "*S-1-5-21domain-553": "RAS and IAS Servers",
        "*S-1-5-32-544": "Administrators",
        "*S-1-5-32-545": "Users",
        "*S-1-5-32-546": "Guests",
        "*S-1-5-32-547": "Power Users",
        "*S-1-5-32-548": "Account Operators",
        "*S-1-5-32-549": "Server Operators",
        "*S-1-5-32-550": "Print Operators",
        "*S-1-5-32-551": "Backup Operators",
        "*S-1-5-32-552": "Replicators",
        "*S-1-5-32-582": "Storage Replica Administrators",
        "*S-1-5-64-10": "NTLM Authentication",
        "*S-1-5-64-14": "SChannel Authentication",
        "*S-1-5-64-21": "Digest Authentication",
        "*S-1-5-80": "NT Service",
        "*S-1-3-2": "Creator Owner Server",
        "*S-1-3-3": "Creator Group Server",
        "*S-1-5-8": "Proxy",
        "*S-1-5-15": "This Organization",
        "*S-1-5-32-554": "Builtin\Pre-Windows 2000 Compatible Access",
        "*S-1-5-32-555": "Builtin\Remote Desktop Users",
        "*S-1-5-32-556": "Builein\\Network Configuration Operators",
        "*S-1-5-32-557": "Builtin\Incoming Forest Trust Builders",
        "*S-1-5-32-558": "Builtin\Performance Monitor Users",
        "*S-1-5-32-559": "Builtin\Performance Log Users",
        "*S-1-5-32-560": "Builtin\Windows Authorization Access Group",
        "*S-1-5-32-561": "Builtin\Terminal Server License Servers",
        "*S-1-5-32-562": "Builtin\Distributed COM Users",
        "*S-1-2-1": "Console Logon",
        "*S-1-5-21 domain -498": "Enterprise Read-only Domain Controllers",
        "*S-1-5-21 domain -521": "Read-only Domain Controllers",
        "*S-1-5-21 domain -571": "Allowed RODC Password Replication Group",
        "*S-1-5-21 domain -572": "Denied RODC Password Replication Group",
        "*S-1-5-32-569": "Builtin\Cryptographic Operators",
        "*S-1-5-32-573": "Builtin\Event Log Readers",
        "*S-1-5-32-574": "Builtin\Certificate Service DCOM Access",
        "*S-1-5-80-0": "NT Services\All Services",
        "*S-1-5-80-0": "All Services",
        "*S-1-5-83-0": "NT Virtual Machine\Virtual Machines",
        "*S-1-5-90-0": "Window Manager\Window Manager Group",
        "*S-1-16-0": "Untrusted Mandatory Level",
        "*S-1-16-4096": "Low Mandatory Level",
        "*S-1-16-8192": "Medium Mandatory Level",
        "*S-1-16-8448": "Medium Plus Mandatory Level",
        "*S-1-16-12288": "High Mandatory Level",
        "*S-1-16-16384": "System Mandatory Level",
        "*S-1-16-20480": "Protected Process Mandatory Level",
        "*S-1-16-28672": "Secure Process Mandatory Level",
}

    # 创建数据库和表头
    def createdb(self):
        # 连接数据库

        # '''创建一个数据库，文件名'''
        conn = sqlite3.connect('../resources/baseline.db')

        # '''创建游标'''
        cursor = conn.cursor()

        # '''执行语句'''
        sql = '''CREATE TABLE "main"."policy2" (
            "ID" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            "item_name" TEXT NOT NULL,
            "checked_val" TEXT DEFAULT 待检测,
            "find_func" TEXT,
            "find_pattern" TEXT,
            "proposed_comment" TEXT,
            "proposed_val" TEXT NOT NULL,
            "proposed_val_type" TEXT NOT NULL,
            "eval_result" TEXT DEFAULT 待评定,
            "harden_tips" TEXT NOT NULL,
            "item_comment" TEXT NOT NULL,
            "str_handle" TEXT NOT NULL DEFAULT None
            );'''

        cursor.execute(sql)

        conn.commit()
        # 使用游标关闭数据库的链接
        cursor.close()


    # 数据库连接及操作
    def updatedb(self, db_path, dic):
        '''
        Input data: db_path, dic
        '''
        # 连接数据库
        conn = sqlite3.connect(db_path)
        print("Opened database successfully")

        # 创建cursor
        cursor = conn.cursor()
        
        # 数据库操作
        # 取出所有规则记录
        cursor.execute('select * from policy')
        logs = cursor.fetchall()


        # 创建列表用于存储写出
        policy_list = []

        # 遍历记录
        for log in logs:
            """ 可能的情况：
            A、字典中存在相应字段
                1.赋值--审核
                2.针对用户权限部分单独处理
            B、字典中不存在相应字段
                1.赋值(未配置)--审核
            """
            # 如果字典中存在相应字段
            if log[3] in dic:

                # 获取字典中对应值
                checked_val = dic.get(log[3])

                # 首先判断是否为str_vague_eq, 对 checked_val 重新赋值 
                if log[6] == "str_vague_eq":
                    checked_val = self.__convert_sort(log[2])


                # 数据规则核查
                if self.switch.get(log[6])(checked_val, log[5]):
                    eval_result = "符合"
                else:
                    eval_result = "不符合"
            


            # 不存在相应字段 置为None(未配置)
            else:
                checked_val = "None"
                # 处理方式为 eq 默认为符合
                if log[6] == 'eq':
                    eval_result = "符合"
                else:
                    eval_result = "不符合"
            

            # 更新数据库)
            cursor.execute('update policy set checked_val = ? where id = ?', (checked_val, log[0],))
            cursor.execute('update policy set eval_result = ? where id = ?', (eval_result, log[0],))
            
            

            # 存入列表
            # 处理策略项的逗号和换行
            checked_val = checked_val.replace(",", "，")
            log_r = log[9].replace("\n", " ")
            log_r = log_r.replace("\r", " ")


            # 加入列表
            # '策略编号','策略名称',''策略名称en', 检测值', '建议范围', '建议值',  '核查结果','加固提示','策略说明'
            policy_list.append([log[0], log[1], log[3], checked_val, log[4], log[5], eval_result, log[8], log_r])
            
        
        self.policy_list = policy_list

        print("database execute successfully")

        # 关闭Cursor:
        cursor.close()

        # 提交事务：
        conn.commit()

        # 关闭connection：
        conn.close()

        print("Close database successfully")

    # 更新补丁
    def update_patch(self, db_path):
         # 连接数据库
        conn = sqlite3.connect(db_path)
        print("Opened database successfully")

        # 创建cursor
        cursor = conn.cursor()
        
        records = get_patch_info()

        cursor.execute("DELETE FROM patch_info")
        for record in records:
            patch_id = record['patch_id']
            update_date = record['installed_on']
            description = record['description']
            installed_by = record['installed_by']

            cursor.execute("INSERT INTO patch_info (id,update_date,description,installed_by)"
                    " VALUES ({}, {}, {}, {})".format("'" + patch_id + "'", "'" + update_date + "'",
                                                        "'" + description + "'",
                                                        "'" + installed_by + "'"))
        print("database execute successfully")

        # 关闭Cursor:
        cursor.close()

        # 提交事务：
        conn.commit()

        # 关闭connection：
        conn.close()

        print("Close database successfully")

    # 待完成-----------
    # def update_service(self, db_path, dic):
    #     '''
    #     Input data: db_path, dic
    #     '''
    #     # 连接数据库
    #     conn = sqlite3.connect(db_path)
    #     print("Opened database successfully")

    #     # 创建cursor
    #     cursor = conn.cursor()
        
    #     # 数据库操作
    #     # 取出所有规则记录
    #     cursor.execute('select * from service')
    #     logs = cursor.fetchall()


    #     # 创建列表用于存储写出
    #     service_list = []

    #     # 遍历记录
    #     for log in logs:
    #         """ 可能的情况：
    #         A、字典中存在相应字段
    #             1.赋值--审核
    #             2.针对用户权限部分单独处理
    #         B、字典中不存在相应字段
    #             1.赋值(未配置)--审核
    #         """
    #         # 如果字典中存在相应字段
    #         if log[3] in dic:

    #             # 获取字典中对应值
    #             checked_val = dic.get(log[3])

    #             # 首先判断是否为str_vague_eq, 对 checked_val 重新赋值 
    #             if log[6] == "str_vague_eq":
    #                 checked_val = self.__convert_sort(log[2])


    #             # 数据规则核查
    #             if self.switch.get(log[6])(checked_val, log[5]):
    #                 eval_result = "符合"
    #             else:
    #                 eval_result = "不符合"
            


    #         # 不存在相应字段 置为None(未配置)
    #         else:
    #             checked_val = "None"
    #             # 处理方式为 eq 默认为符合
    #             if log[6] == 'eq':
    #                 eval_result = "符合"
    #             else:
    #                 eval_result = "不符合"
            

    #         # 更新数据库)
    #         cursor.execute('update service set checked_val = ? where id = ?', (checked_val, log[0],))
    #         cursor.execute('update serivce set eval_result = ? where id = ?', (eval_result, log[0],))
            
            

    #         # 存入列表
    #         # 处理策略项的逗号和换行
    #         checked_val = checked_val.replace(",", "，")
    #         log_r = log[9].replace("\n", " ")
    #         log_r = log_r.replace("\r", " ")


    #         # 加入列表
    #         # '策略编号','策略名称',''策略名称en', 检测值', '建议范围', '建议值',  '核查结果','加固提示','策略说明'
    #         service_list.append([log[0], log[1], log[3], checked_val, log[4], log[5], eval_result, log[8], log_r])
            
        
    #     self.service_list = service_list

    #     print("database execute successfully")

    #     # 关闭Cursor:
    #     cursor.close()

    #     # 提交事务：
    #     conn.commit()

    #     # 关闭connection：
    #     conn.close()

    #     print("Close database successfully")
    #     pass

    # 导出到csv文件
    def export2csv(self, csv_path):
        with open(csv_path, 'w', encoding="utf-8") as f:
            writer = csv.writer(f)
            writer.writerow(['策略编号','策略名称','检测值','建议范围','建议值','核查结果','加固提示','策略说明'])
            writer.writerows(self.policy_list)
        


    # 私有方法
    # 定义相关规则函数
    # 小于规则
    def __lt(check_val, proposed_val):

        # 处理 CachedLogonsCount 1,“10”情况
        if "," in check_val:
            c_val = check_val.split(',')
            c_val[-1] = c_val[-1].strip("\"")
            return int(c_val[-1]) < int(proposed_val)
        else:
            return int(check_val) < int(proposed_val)


    # 大于规则
    def __bt(check_val, proposed_val):

        # 处理 CachedLogonsCount 1,“10”情况
        if "," in check_val:
            c_val = check_val.split(',')
            c_val[-1] = c_val[-1].strip("\"")
            return int(c_val[-1]) > int(proposed_val)
        else:
            return int(check_val) > int(proposed_val)


    # 等于规则
    def __eq(check_val, proposed_val):
        return check_val == proposed_val


    # between规则
    def __between(check_val, proposed_val):
        val = proposed_val[1:-1].split(',')
        # 处理类似 MaximumPasswordAge 1,30 的情况
        if "," in check_val:
            c_val = check_val.split(',')
            return int(val[0]) <= int(c_val[-1]) <= int(val[1])
        
        else:
            return int(val[0]) <= int(check_val) <= int(val[1])


    # 不等于规则
    def __ne(check_val, proposed_val):
        return check_val != proposed_val


     # 定义switch
    

    # 模糊匹配字符串（无序）
    # 思路：
    # 将推荐值排序写成字符串，在进行对比
    def __str_vague_eq(check_val, proposed_val):
        # check_val is str(sort)
        proposed_vals = proposed_val.split(",")

        proposed_vals.sort()

        new_proposed_val = ",".join(proposed_vals)

        return check_val == new_proposed_val
     

    # SID 转换为账户名并排序
    def __convert_sort(self, value):
        
        # 划分 value
        values = value.split(",")
        
        # 账户名列表
        value_list = []

        # 将 SID 转换为账户名
        # 获取所有可读账户名
        for val in values:
            if self.convert_SID.get(val):
                value_list.append(self.convert_SID.get(val))

            else:
                value_list.append(val)
        
        # 账户名排序
        value_list.sort()

        # list -> str
        new_value = ",".join(value_list)

        return new_value


    # 规则函数匹配
    switch = {
        'lt': __lt,
        'bt': __bt,
        'eq': __eq,
        'between': __between,
        'str_vague_eq': __str_vague_eq,
        'ne': __ne,
    }


if __name__ == "__main__":
    dbo = DBOperator()
    dbo.update_patch("resources/baseline.db")