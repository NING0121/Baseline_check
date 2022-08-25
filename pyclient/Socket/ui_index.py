'''
@File    :   ui_index.py
@Author  :   vagr4nt 王研博
@Version :   1.0
@Contact :   1150670720@qq.com
'''
# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'indexKzFPMR.ui'
##
## Created by: Qt User Interface Compiler version 5.14.2
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *


class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(800, 600)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.listView = QListView(self.centralwidget)
        self.listView.setObjectName(u"listView")
        self.listView.setGeometry(QRect(200, 30, 341, 341))
        self.listView.setStyleSheet(u"background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:1, y2:0, stop:0 rgba(198, 150, 72, 255), stop:1 rgba(255, 255, 255, 255));")
        self.listView.setAlternatingRowColors(False)
        self.pushButton = QPushButton(self.centralwidget)
        self.pushButton.setObjectName(u"pushButton")
        self.pushButton.setGeometry(QRect(310, 300, 112, 32))
        self.pushButton.setStyleSheet(u"")
        self.horizontalLayoutWidget_2 = QWidget(self.centralwidget)
        self.horizontalLayoutWidget_2.setObjectName(u"horizontalLayoutWidget_2")
        self.horizontalLayoutWidget_2.setGeometry(QRect(210, 150, 321, 21))
        self.horizontalLayout_2 = QHBoxLayout(self.horizontalLayoutWidget_2)
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.horizontalLayout_2.setContentsMargins(0, 0, 0, 0)
        self.lineEdit_2 = QLineEdit(self.horizontalLayoutWidget_2)
        self.lineEdit_2.setObjectName(u"lineEdit_2")
        self.lineEdit_2.setAlignment(Qt.AlignCenter)

        self.horizontalLayout_2.addWidget(self.lineEdit_2)

        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Expanding, QSizePolicy.Minimum)

        self.horizontalLayout_2.addItem(self.horizontalSpacer)

        self.textEdit_2 = QTextEdit(self.horizontalLayoutWidget_2)
        self.textEdit_2.setObjectName(u"textEdit_2")

        self.horizontalLayout_2.addWidget(self.textEdit_2)

        self.lineEdit_3 = QLineEdit(self.centralwidget)
        self.lineEdit_3.setObjectName(u"lineEdit_3")
        self.lineEdit_3.setGeometry(QRect(290, 60, 151, 31))
        self.lineEdit_3.setAlignment(Qt.AlignCenter)
        self.textEdit = QTextEdit(self.centralwidget)
        self.textEdit.setObjectName(u"textEdit")
        self.textEdit.setGeometry(QRect(260, 190, 221, 101))
        self.horizontalLayoutWidget_3 = QWidget(self.centralwidget)
        self.horizontalLayoutWidget_3.setObjectName(u"horizontalLayoutWidget_3")
        self.horizontalLayoutWidget_3.setGeometry(QRect(210, 110, 321, 21))
        self.horizontalLayout_3 = QHBoxLayout(self.horizontalLayoutWidget_3)
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.horizontalLayout_3.setContentsMargins(0, 0, 0, 0)
        self.lineEdit_4 = QLineEdit(self.horizontalLayoutWidget_3)
        self.lineEdit_4.setObjectName(u"lineEdit_4")
        self.lineEdit_4.setAlignment(Qt.AlignCenter)

        self.horizontalLayout_3.addWidget(self.lineEdit_4)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Expanding, QSizePolicy.Minimum)

        self.horizontalLayout_3.addItem(self.horizontalSpacer_2)

        self.textEdit_3 = QTextEdit(self.horizontalLayoutWidget_3)
        self.textEdit_3.setObjectName(u"textEdit_3")

        self.horizontalLayout_3.addWidget(self.textEdit_3)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 800, 22))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.pushButton.setText(QCoreApplication.translate("MainWindow", u"\u68c0\u6d4b\u626b\u63cf\u4efb\u52a1", None))
        self.lineEdit_2.setText(QCoreApplication.translate("MainWindow", u"\u5ba2\u6237\u673a\u8bbe\u5907\u53f7", None))
        self.lineEdit_3.setText(QCoreApplication.translate("MainWindow", u"\u57fa\u7ebf\u626b\u63cf\u7cfb\u7edf\u5ba2\u6237\u7aef", None))
        self.lineEdit_4.setText(QCoreApplication.translate("MainWindow", u"\u670d\u52a1\u5668\u5730\u5740", None))
    # retranslateUi
