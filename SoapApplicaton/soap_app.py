"""
Class with interface for user to use Soap operations
"""
__author__ = "Daniel Szarek"

from soap_client import SoapClient
import os


class SoapApp:
    def __init__(self):
        self.soap_client = SoapClient()
        self.menu_choice = ""
        self.is_open = True

    def menu(self):
        # clear screen depends on OS
        os.system('cls' if os.name == 'nt' else 'clear')

        print("""
    ApiPortService Client
==============================
1. Try results operation
2. Try registerCall operation
==============================
Other key to exit...""")

        self.menu_choice = input("Choice: ")

    def start(self):
        while self.is_open:
            self.menu()
            if self.menu_choice == "1":
                student = input("Student name: ")
                print(self.soap_client.results_operation(student))
            elif self.menu_choice == "2":
                student = input("Student name: ")
                print(self.soap_client.register_call_operation(student))
            else:
                self.is_open = False
            input("Click 'Enter' to continue")


if __name__ == '__main__':
    app = SoapApp()
    app.start()
