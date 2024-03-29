import sys  # sys нужен для передачи argv в QApplication
from PyQt5 import QtWidgets
from PyQt5.QtGui import QPainter, QPixmap
from PyQt5.QtWidgets import QLineEdit

import design  # Это наш конвертированный файл дизайна
from DbHandler import DbHandler


class ExampleApp(QtWidgets.QMainWindow, design.Ui_MainWindow):
    def __init__(self):
        # Это здесь нужно для доступа к переменным, методам
        # и т.д. в файле design.py
        super().__init__()
        self.setupUi(self)  # Это нужно для инициализации нашего дизайна
        self.init_logic()
        self.db_handler = DbHandler()

    def click_button(self):
        login = self.login_edit.text()
        password = self.pass_edit.text()
        if login and password:
            user = self.db_handler.get_user(login, password)
            if user:
                msg_box = QtWidgets.QMessageBox()
                painter = QPainter(msg_box)
                pixmap = QPixmap(f"img/{user[2].split()[0]}.jpeg")
                msg_box.setText('Успешная авторизация:\n'
                                f'ФИО: {user[2]}\n'
                                f'Должность: {user[1]}\n')
                msg_box.setIconPixmap(pixmap)
                msg_box.exec()
            else:
                msg_box = QtWidgets.QMessageBox()
                msg_box.setText('Пользователь с такими данными не найден')
                msg_box.exec()
        else:
            print('Поля пусты')

    def click_show_pass(self):
        if self.check_show_pass.isChecked():
            self.pass_edit.setEchoMode(QLineEdit.Normal)
        else:
            self.pass_edit.setEchoMode(QLineEdit.Password)

    def init_logic(self):
        self.auth_btn.clicked.connect(self.click_button)
        self.login_edit.setText("Ivanov@namecomp.ru")
        self.pass_edit.setText("2L6KZG")
        self.check_show_pass.stateChanged.connect(self.click_show_pass)


def main():
    app = QtWidgets.QApplication(sys.argv)  # Новый экземпляр QApplication
    window = ExampleApp()  # Создаём объект класса ExampleApp
    window.show()  # Показываем окно
    app.exec_()  # и запускаем приложение


if __name__ == '__main__':  # Если мы запускаем файл напрямую, а не импортируем
    main()  # то запускаем функцию main()
