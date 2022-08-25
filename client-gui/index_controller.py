# -*- encoding: utf-8 -*-
'''
@File    :   index_controller.py
@Time    :   2021/06/26 16:02:02
@Author  :   vagr4nt 王研博 
@Version :   1.0
@Contact :   1150670720@qq.com
'''

# here put the import lib
from ui_index import *
import requests
import json
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

    def updateurl(self):
        self.url = self.ui.textEdit_3.toPlainText()
    def updatedevicenum(self):
        self.device_num = self.ui.textEdit_2.toPlainText()



    def checkMissionFromServer(self):
        #url = 'http://192.168.163.1:8080'+'/scan/device/'+str(device_num)
        url = self.url + '/scan/device/'+str(self.device_num)
        r = requests.get(url).text
        self.ui.textEdit.setText(r)
        return r

if __name__ == '__main__':  # 程序的入口
    import sys



    app2 = QtWidgets.QApplication([])

    application = indexwindow()

    application.show()

    sys.exit(app2.exec())
