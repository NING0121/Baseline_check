# -*- encoding: utf-8 -*-
'''
@File    :   center.py
@Time    :   2021/06/13 09:16:33
@Author  :   E-11 林佳评 
@Version :   1.0
@Contact :   974879729@qq.com
'''
# here put the import lib
import socket
import json
import struct
import csv
from multiprocessing import Process



# 变量声明
coding = 'GB2312'
recv_buffer = 2048

filename = {'0': '主机信息',
            '1': '基线核查结果',
            '2': '自启动项检测结果',
            '3': '补丁信息检测结果',
            '4': '服务信息检测结果',
            '5': '映像劫持检测结果',
            '6': '影子账户检测结果'}

# 菜单
menu = '\r\n|' + 'MENU'.center(36, '*') + '|\r\n' + \
       '|' + '* 0——检测主机信息' + '\r\n' + \
       '|' + '* 1——进行基线核查' + '\r\n' + \
       '|' + '* 2——检测自启动项' + '\r\n' + \
       '|' + '* 3——检测补丁信息' + '\r\n' + \
       '|' + '* 4——检测服务信息' + '\r\n' + \
       '|' + '* 5——检测映像劫持' + '\r\n' + \
       '|' + '* 6——检测影子账户(需要以管理员身份运行程序)' + '\r\n' + \
       '|' + '* s——结束核查端程序' + '\r\n' + \
       '|' + '* q——断开连接'


# 接收消息
def receive_msg(clientSocket, buffer):

    body_buffer = bytes()
    header_size = 8
    data = clientSocket.recv(buffer)

    header = struct.unpack('si', data[:header_size])
    body_buffer += data[header_size:]


    while header[1] != -1:
        data = clientSocket.recv(buffer)
        header = struct.unpack('si', data[:header_size])
        body_buffer += data[header_size:]
    

    recv_msg = body_buffer.decode(coding)
    recv_msg = json.loads(recv_msg)


    return header[0].decode(coding), recv_msg



# 服务连接
def connect_server(client_sokcet,addr):
    # 打印客户端连接 IP及PORT
    print("连接地址: %s" % str(addr))

    while True:
        # 打印菜单
        print(menu)
        
        # 接收指令输入
        send_msg = input('发送指令:\n>')

        # 发送指令
        client_sokcet.send(send_msg.encode(coding))

        # 指令判断
        if send_msg == 'q':
            print('连接已断开！')
            break
        if send_msg == 's':
            print('核查端程序已结束，连接已断开！')
            break
        
        # 接收消息
        notice, recv_msg = receive_msg(client_sokcet, recv_buffer)


        if notice =="e":
            print(recv_msg[0])
            continue
            
        
        while notice != 'r' and notice != 'e':
            notice, recv_msg = receive_msg(client_sokcet, recv_buffer)
            if notice == 'r':
                print('*****************************')
                print(recv_msg[1])
                header = recv_msg[0]
                data = recv_msg[1]
                file_name = filename[send_msg]
                write_into_file(header, data, file_name)
            else:
                print('*****************************')
                print(recv_msg[1])

                
    client_sokcet.close()




# 写入文件
def write_into_file(header, result_records, file_name):
    try:
        # 打开文件
        file = open("../resources/result/"+ file_name + '.csv', 'w', encoding='utf-8-sig')

        # 字典 --> csv
        csv_writer = csv.DictWriter(file, fieldnames=header)
        # csv header 和 data
        csv_writer.writeheader()
        csv_writer.writerows(result_records)

        # 关闭文件
        file.close()

        print("结果保存为： "+file_name+".csv")
   
    # IOError 处理
    except IOError:
        print("结果保存失败： "+file_name+".csv")




if __name__ == '__main__':

    # 定义套接字
    serverSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # 获取主机 端口
    host = socket.gethostname()
    port = 9999

    # 端口绑定
    serverSocket.bind((host, port))

    # 端口监听
    serverSocket.listen(5)

    # 接收连接
    client_sokcet, addr = serverSocket.accept()   
    connect_server(client_sokcet,addr)

 
    
  
