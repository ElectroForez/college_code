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

    def buy_ticket(self, ticket_id):
        ticket = self.get_ticket(ticket_id)
        if ticket is None:
            raise sqlite3.DataError(f"Билет {ticket_id} не существует")

        if ticket[-1] != 'в продаже':
            raise sqlite3.DataError(f"Билет {ticket_id} не в продаже")

        self.cursor.execute("UPDATE event_tickets "
                            "SET ticket_status = 'куплен' "
                            f"WHERE ticket_id = {ticket_id}")
        self.insert_history(ticket_id, 'куплен')

    def insert_history(self, ticket_id, status):
        self.cursor.execute("INSERT INTO tickets_history VALUES "
                            f"({ticket_id}, datetime('now', 'localtime'), '{status}')")

    def get_ticket(self, ticket_id):
        result = self.select(f"SELECT * FROM event_tickets WHERE ticket_id = {ticket_id}", 1)
        return result

    def get_refunded_sum(self, ticket_id):
        ticket_type = self.select("SELECT ticket_type FROM event_tickets "
                                  "JOIN events e ON e.event_id = event_tickets.event_id "
                                  f"WHERE ticket_id={ticket_id}", 1)[0]
        if ticket_type is None:
            return
        remaining_time = self.select("SELE")
        refunded_percent = self.select("SELECT ticket_type FROM event_tickets "
                                       "JOIN events e ON e.event_id = event_tickets.event_id "
                                       f"WHERE ticket_id={ticket_id}", 1)[0]

    def select(self, query, fetch_size=-1):
        """return result of select query"""
        self.cursor.execute(query)
        if fetch_size == -1:
            result = self.cursor.fetchall()
        elif fetch_size == 1:
            result = self.cursor.fetchone()
            if result is not None:
                result = result
        else:
            result = self.cursor.fetchmany(fetch_size)
        return result

    def close_connection(self):
        self.connection.commit()
        self.cursor.close()
        self.connection.close()
