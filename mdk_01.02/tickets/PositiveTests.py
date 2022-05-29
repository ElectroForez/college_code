from datetime import datetime
import unittest
import os
from DbHandler import DbHandler

DB_PATH = "db.db"


class PositiveTestsDbHandler(unittest.TestCase):
    TEST_TICKET_ID_REFUND = 99999
    TEST_TICKET_ID_BUY = 99998
    TEST_EVENT_ID = 99999

    TEST_TICKET_PRICE = 6666

    def setUp(self) -> None:
        if os.path.exists(DB_PATH):
            os.remove(DB_PATH)
        self.db_handler = DbHandler(DB_PATH)
        self.input_test_data()

    def test_1_create_ticket_db(self):
        self.db_handler.select("SELECT * "
                               "FROM "
                               "ticket_types, "
                               "ticket_refund_sum, "
                               "events, "
                               "event_tickets, "
                               "tickets_history ")

    def test_2_db_exists(self):
        is_exists = self.db_handler.db_is_exists()
        self.assertTrue(is_exists)

    def test_3_is_ticket_exists(self):
        is_exists = self.db_handler.is_ticket_exists(self.TEST_TICKET_ID_BUY)
        self.assertTrue(is_exists)

    def test_4_buy_ticket(self):
        self.db_handler.buy_ticket(self.TEST_TICKET_ID_BUY)
        self.db_handler.cursor.execute("SELECT ticket_status "
                                       "FROM event_tickets "
                                       f"WHERE ticket_id = {self.TEST_TICKET_ID_BUY}")
        ticket_status = self.db_handler.cursor.fetchone()[0]
        self.assertEqual(ticket_status, 'куплен')

    def test_5_refund_ticket(self):
        self.db_handler.refund_ticket(self.TEST_TICKET_ID_REFUND, datetime.now())
        self.db_handler.cursor.execute("SELECT ticket_status "
                                       "FROM event_tickets "
                                       f"WHERE ticket_id = {self.TEST_TICKET_ID_REFUND}")
        ticket_status = self.db_handler.cursor.fetchone()[0]
        self.assertEqual(ticket_status, 'в продаже')

    def input_test_data(self):
        sql_data = f"""
        insert into events values ({self.TEST_EVENT_ID}, 'test_event', 1, datetime('now', '+10 day', 'localtime'));
        
        INSERT INTO event_tickets VALUES 
        ({self.TEST_TICKET_ID_BUY}, {self.TEST_EVENT_ID}, 'test_seat', {self.TEST_TICKET_PRICE}, 'в продаже');                
        
        INSERT INTO event_tickets VALUES 
        ({self.TEST_TICKET_ID_REFUND}, {self.TEST_EVENT_ID}, 'test_seat', {self.TEST_TICKET_PRICE}, 'куплен');
        """
        self.db_handler.cursor.executescript(sql_data)


if __name__ == '__main__':
    unittest.main()
