"""
This class in responsible for making whole conntection with Soap service defined in wsdl
"""
__author__ = "Daniel Szarek"

import zeep
import pathlib
from os.path import join

CURRENT_DIR = pathlib.Path(__file__).parent.absolute()


class SoapClient:
    def __init__(self):
        try:
            self.wsdl = join(CURRENT_DIR, "soap_wsdl.xml")
        except FileNotFoundError:
            print("Brak pliku wsdl!")
        self.client = zeep.Client(wsdl=self.wsdl)

    def results_operation(self, student):
        try:
            response = self.client.service.results(student)
            return str(response)
        except Exception as e:
            return f"Wystąpił błąd: {str(e)}"

    def register_call_operation(self, student):
        try:
            response = self.client.service.registerCall(student)
            return str(response)
        except Exception as e:
            return f"Wystąpił błąd: {str(e)}"
