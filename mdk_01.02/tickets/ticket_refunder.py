from DbHandler import DbHandler


class TicketRefunder:
    def __init__(self, db_path):
        self.db_path = db_path
        self.db_handler = DbHandler(self.db_path)

    def buy_ticket(self, ticket_id):
        self.db_handler.buy_ticket(1)
        print(f'Билет {ticket_id} куплен')

    def refund_ticket(self, ticket_id):




if __name__ == '__main__':
    ticket_refunder = TicketRefunder('db.db')
    ticket_refunder.db_handler.close_connection()

