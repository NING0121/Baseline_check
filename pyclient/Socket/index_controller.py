'''
@File    :   index_controller.py
@Author  :   vagr4nt 王研博
@Version :   1.0
@Contact :   1150670720@qq.com
'''

from ui_index import *
import requests
import json

import os
import socket
import requests
from multiprocessing import Process

from server_functions import *
# 变量声明
coding = 'GB2312'


filename = {'0': '主机信息',
            '1': '基线核查结果',
            '2': '自启动项检测结果',
            '3': '补丁信息检测结果',
            '4': '服务信息检测结果',
            '5': '映像劫持检测结果',
            '6': '影子账户检测结果'}

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

# 操作指令
commend = {'0': '检测主机信息',
           '1': '进行基线核查',
           '2': '检测自启动项',
           '3': '检测补丁信息',
           '4': '检测服务信息',
           '5': '检测映像劫持',
           '6': '检测影子账户',
           's': '结束核查端程序',
           'q': '断开连接'}


# 定义对应操作
switch = {'0': server_sys_info,
          '1': server_baseline_check,
          '2': server_autorun_info,
          '3': server_patch_info,
          '4': server_service_info,
          '5': server_IFEO_info,
          '6': server_shadow_accounts_info,
          's': server_shutdown,
          'q': client_quit}


# 处理连接
def parse_client_cmd(clientSocket):
    while True:
        # 解码
        cmd = clientSocket.recv(128).decode(coding)

        try:
            str_cmd = commend[cmd]
            send_msg = pack_msg('s', -1, ['开始' + str_cmd])[2]
            clientSocket.send(send_msg)
        except KeyError:
            str_cmd = '错误的指令'

        method = switch.get(cmd, default)
        result = method(clientSocket)

        if result == 1:
            os._exit(0)
        if result == 2:
            break

    clientSocket.close()

def client_main(s,choice,device_id):

    method = switch.get(str(choice), default)
    result = method()
    result = str(result)
    result = result.replace('"','')
    result = result.replace('\'','"')
    result = device_id+str(choice)+result
    print(result)

    s.send(str(result).encode())

    return result



class indexwindow(QtWidgets.QMainWindow):
    def make_all_connections(self):
        self.ui.textEdit_3.textChanged.connect(self.updateurl)
        self.ui.textEdit_2.textChanged.connect(self.updatedevicenum)
        self.ui.pushButton.clicked.connect(self.checkMissionFromServer)

    def __init__(self):
        super(indexwindow, self).__init__()
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.ui.textEdit_3.setText('http://localhost:8080')
        self.url = self.ui.textEdit_3.toPlainText()
        self.make_all_connections()

    def main(self, option):
        host = self.url[7:-5]#socket.gethostname()
        port = 9999
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.connect((host, port))
        return client_main(s,option,self.device_num)

    def updateurl(self):
        self.url = self.ui.textEdit_3.toPlainText()
    def updatedevicenum(self):
        try:
            self.device_num = self.ui.textEdit_2.toPlainText()
            tmp = int(self.device_num)
        except:
            self.device_num = 1

    def checkMissionFromServer(self):
        #url = 'http://192.168.163.1:8080'+'/scan/device/'+str(device_num)
        url = self.url + '/scan/device/'+str(self.device_num)
        print(url)
        r = requests.get(url).text
        print(r)
        import json
        status = json.loads(r)['data']
        if status == 9:
            self.ui.textEdit.setText('No scan mission now.')
            return 0
        else:
            self.ui.textEdit.setText('Scanning..\nResults:\n'+self.main(status))
            r = requests.get(self.url+'/scan/update/'+str(self.device_num)+'/9')
            return 1

if __name__ == '__main__':  # 程序的入口
    import sys

    app2 = QtWidgets.QApplication([])

    application = indexwindow()

    application.show()

    sys.exit(app2.exec())
