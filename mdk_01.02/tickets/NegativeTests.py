from datetime import datetime, timedelta
import unittest
import os
from DbHandler import DbHandler
from TicketRefunder import TicketRefunder

DB_PATH = "db.db"


class NegTestsTicketRefunder(unittest.TestCase):
    TEST_TICKET_ID_PURCHASED = 99999
    TEST_TICKET_ID_NOT_PURCHASED = 99998
    NOT_EXISTS_TICKET_ID = -1
    TEST_EVENT_ID = 99999

    TEST_TICKET_PRICE = 6666

    def setUp(self) -> None:
        if os.path.exists(DB_PATH):
            os.remove(DB_PATH)
        self.ticket_refunder = TicketRefunder(DB_PATH)
        self.db_handler = DbHandler(DB_PATH)
        self.input_test_data()

    def test_1_buy_non_exists_ticket(self):
        statuscode = self.ticket_refunder.buy_ticket(self.NOT_EXISTS_TICKET_ID)
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_NOT_EXISTS)

    def test_2_buy_already_purchased_ticket(self):
        statuscode = self.ticket_refunder.buy_ticket(self.TEST_TICKET_ID_PURCHASED)
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_INVALID_STATE)

    def test_3_refund_non_purchased_ticket(self):
        statuscode = self.ticket_refunder.refund_ticket(self.TEST_TICKET_ID_NOT_PURCHASED, datetime.now())
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_INVALID_STATE)

    def test_4_refund_non_exists_ticket(self):
        statuscode = self.ticket_refunder.refund_ticket(self.NOT_EXISTS_TICKET_ID, datetime.now())
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_NOT_EXISTS)

    def test_5_belated_refund_event_over(self):
        event_date = self.db_handler.select("SELECT event_datetime FROM events e "
                                            "JOIN event_tickets et "
                                            "ON et.event_id = e.event_id "
                                            f"WHERE ticket_id = {self.TEST_TICKET_ID_PURCHASED}", 1)
        event_date = datetime.strptime(event_date, '%Y-%m-%d %H:%M:%S')
        belated_event_date = event_date + timedelta(minutes=1)
        statuscode = self.ticket_refunder.refund_ticket(self.TEST_TICKET_ID_PURCHASED, belated_event_date)
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_NON_REFUNDABLE)

    def test_6_belated_refund_event_very_soon(self):
        event_date = self.db_handler.select("SELECT event_datetime FROM events e "
                                            "JOIN event_tickets et "
                                            "ON et.event_id = e.event_id "
                                            f"WHERE ticket_id = {self.TEST_TICKET_ID_PURCHASED}", 1)
        event_date = datetime.strptime(event_date, '%Y-%m-%d %H:%M:%S')
        belated_event_date = event_date - timedelta(minutes=1)
        statuscode = self.ticket_refunder.refund_ticket(self.TEST_TICKET_ID_PURCHASED, belated_event_date)
        self.assertEqual(statuscode, TicketRefunder.StatusCode.TICKET_NON_REFUNDABLE)

    def input_test_data(self):
        sql_data = f"""
        insert into events values ({self.TEST_EVENT_ID}, 'test_event', 1, datetime('now', '+10 day', 'localtime'));
        
        INSERT INTO event_tickets VALUES 
        ({self.TEST_TICKET_ID_NOT_PURCHASED}, {self.TEST_EVENT_ID}, 'test_seat', {self.TEST_TICKET_PRICE}, 'в продаже');
                        
        
        INSERT INTO event_tickets VALUES 
        ({self.TEST_TICKET_ID_PURCHASED}, {self.TEST_EVENT_ID}, 'test_seat', {self.TEST_TICKET_PRICE}, 'куплен');
        """
        self.db_handler.cursor.executescript(sql_data)


if __name__ == '__main__':
    unittest.main()
