import datetime
import sqlite3
import os


class DbHandler:
    def __init__(self, db_path):
        self.db_path = db_path
        db_exists = self.db_is_exists()
        self.connection = sqlite3.connect(db_path)
        self.cursor = self.connection.cursor()
        if not db_exists:
            self.create_db()

    def db_is_exists(self):
        return os.path.exists(self.db_path)

    def create_db(self):
        with open("create_db.sql") as dbfile:
            sqlscript = dbfile.read()
        self.connection.executescript(sqlscript)

        with open("data.sql") as datafile:
            sqldata = datafile.read()
        self.connection.executescript(sqldata)

    def ticket_is_purchased(self, ticket_id):
        self.is_ticket_exists(ticket_id, True)
        ticket = self.select("SELECT * FROM event_tickets "
                             f"WHERE ticket_id = {ticket_id} "
                             "AND "
                             "ticket_status = 'куплен'")
        if ticket:
            return True
        else:
            return False

    def is_ticket_exists(self, ticket_id, raise_error=False):
        ticket = self.select("SELECT ticket_id "
                             "FROM event_tickets "
                             f"WHERE ticket_id = {ticket_id}", 1)
        if ticket is not None:
            return True
        else:
            if raise_error:
                raise sqlite3.DataError(f"Билет {ticket_id} не существует")
            return False

    def buy_ticket(self, ticket_id):
        self.is_ticket_exists(ticket_id, True)
        ticket = self.get_ticket(ticket_id)
        if ticket[-1] != 'в продаже':
            raise sqlite3.DataError(f"Билет {ticket_id} не в продаже")

        self.cursor.execute("UPDATE event_tickets "
                            "SET ticket_status = 'куплен' "
                            f"WHERE ticket_id = {ticket_id}")
        self.insert_history(ticket_id, 'куплен')

    def insert_history(self, ticket_id, status, date=None):
        if date is None:
            date = datetime.datetime.now()

        self.cursor.execute("INSERT INTO tickets_history VALUES "
                            f"({ticket_id}, datetime('{date}'), '{status}')")

    def get_ticket(self, ticket_id):
        result = self.select(f"SELECT * FROM event_tickets WHERE ticket_id = {ticket_id}")[0]
        return result

    def refund_ticket(self, ticket_id, refund_date):
        self.is_ticket_exists(ticket_id, True)
        if not self.ticket_is_purchased(ticket_id):
            raise sqlite3.DataError(f"Билет {ticket_id} не куплен")

        self.cursor.execute("UPDATE event_tickets "
                            "SET ticket_status = 'в продаже' "
                            f"WHERE ticket_id = {ticket_id}")
        refunded_sum = self.get_refunded_sum(ticket_id, refund_date)
        if refunded_sum != 0:
            self.insert_history(ticket_id, 'возврат', date=refund_date)
        return refunded_sum

    def get_refunded_sum(self, ticket_id, refund_date):
        self.is_ticket_exists(ticket_id, True)

        ticket_price = self.select("SELECT ticket_price "
                                   "FROM event_tickets "
                                   f"WHERE ticket_id = {ticket_id} "
                                   f"", 1)
        if ticket_price is None:
            return

        refund_percentages = self.select(f"""
            SELECT MAX(refund_percent)
            FROM
            event_tickets et
            JOIN events e
            ON e.event_id = et.event_id
            JOIN ticket_refund_sum trs
            ON trs.ticket_type_id = e.ticket_type_id
            WHERE
            et.ticket_id = {ticket_id}
            AND
            remaining_time < (strftime("%s", e.event_datetime) - strftime("%s", datetime('{refund_date}')));
        """, 1)

        if refund_percentages is None:
            refund_percentages = 0
        refund_sum = ticket_price * refund_percentages // 100
        return refund_sum

    def select(self, query, fetch_size=-1):
        """return result of select query"""
        self.cursor.execute(query)
        if fetch_size == -1:
            result = self.cursor.fetchall()
        elif fetch_size == 1:
            result = self.cursor.fetchone()
            if result is not None:
                result = result[0]
        else:
            result = self.cursor.fetchmany(fetch_size)
        return result

    def close_connection(self):
        self.connection.commit()
        self.cursor.close()
        self.connection.close()
