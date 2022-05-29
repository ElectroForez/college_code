import datetime
import os
import time

from DbHandler import DbHandler

DB_PATH = "db.db"


class TicketRefunder:
    class StatusCode:
        SUCCESSFULLY = 0
        TICKET_NOT_EXISTS = -1
        TICKET_INVALID_STATE = -2
        TICKET_NON_REFUNDABLE = 1

    def __init__(self, db_path):
        self.db_path = db_path
        self.db_handler = DbHandler(self.db_path)

    def buy_ticket(self, ticket_id):
        if self.db_handler.is_ticket_exists(ticket_id):
            if self.db_handler.ticket_is_purchased(ticket_id):
                print(f"Билет {ticket_id} уже купили")
                return TicketRefunder.StatusCode.TICKET_INVALID_STATE
            self.db_handler.buy_ticket(ticket_id)
            print(f'Билет {ticket_id} куплен')
            return TicketRefunder.StatusCode.SUCCESSFULLY
        else:
            print(f'Билет {ticket_id} не существует')
            return TicketRefunder.StatusCode.TICKET_NOT_EXISTS

    def refund_ticket(self, ticket_id, refund_date):
        if not self.db_handler.is_ticket_exists(ticket_id):
            print(f'Билет {ticket_id} не существует')
            return TicketRefunder.StatusCode.TICKET_NOT_EXISTS
        if not self.db_handler.ticket_is_purchased(ticket_id):
            print(f'Билет {ticket_id} никем не куплен')
            return TicketRefunder.StatusCode.TICKET_INVALID_STATE

        refund_sum = self.db_handler.refund_ticket(ticket_id, refund_date)
        if refund_sum != 0:
            print("Сумма возврата билета:", refund_sum)
            return TicketRefunder.StatusCode.SUCCESSFULLY
        else:
            print('Билет возврату больше не подлежит')
            return TicketRefunder.StatusCode.TICKET_NON_REFUNDABLE


if __name__ == '__main__':
    if os.path.exists(DB_PATH):
        os.remove(DB_PATH)
    ticket_refunder = TicketRefunder('db.db')
    print("Укажите номер билета для покупки: ")
    buy_ticket_id = int(input())
    ticket_refunder.buy_ticket(buy_ticket_id)
    print("Укажите номер билета для возврата: ")
    refund_ticket_id = int(input())
    print("Укажите дату возврата в формате %d/%m/%y %H:%M:")
    refund_datetime = datetime.datetime.strptime(input(), "%d/%m/%y %H:%M")
    ticket_refunder.refund_ticket(refund_ticket_id, refund_datetime)
    ticket_refunder.db_handler.close_connection()
