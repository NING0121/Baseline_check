# -*- encoding: utf-8 -*-
'''
@File    :   login_controller.py
@Time    :   2021/06/26 16:02:43
@Author  :   vagr4nt 王研博 
@Version :   1.0
@Contact :   1150670720@qq.com
'''

# here put the import lib

from ui_login import *
import requests
import json
from index_controller import indexwindow
from time import *
if __name__ == '__main__':  # 程序的入口
    import sys

    class loginwindow(QtWidgets.QMainWindow):
        def make_all_connections(self):
            self.ui.textEdit_2.textChanged.connect(self.updateusername)
            self.ui.textEdit_3.textChanged.connect(self.updateurl)
            self.ui.textEdit.textChanged.connect(self.updatepassword)
            self.ui.pushButton.clicked.connect(self.login)

        def __init__(self):
            super(loginwindow, self).__init__()
            self.ui = Ui_MainWindow()
            self.ui.setupUi(self)
            self.ui.textEdit_3.setText('http://localhost:8080')
            self.url = self.ui.textEdit_3.toPlainText()
            self.make_all_connections()

        def updateurl(self):
            self.url = self.ui.textEdit_3.toPlainText()
        def updateusername(self):
            self.username = self.ui.textEdit_2.toPlainText()
        def updatepassword(self):
            self.password = self.ui.textEdit.toPlainText()

        def login(self):

            url = self.url+'/shiro/login'
            try:
                r = requests.post(url,data={'username':self.username,'password':self.password})
            except:
                sys.exit(app.quit())

            if json.loads(r.text)['code'] == 200:
                print("login success!")
                sleep(1)
                self._index_window = indexwindow()
                self._index_window.show()

            else:
                print("login failed!")
                sys.exit(app.quit())

    app = QtWidgets.QApplication([])

    application = loginwindow()

    application.show()

    sys.exit(app.exec())
