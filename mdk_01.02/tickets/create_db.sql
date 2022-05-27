CREATE TABLE ticket_types (
    ticket_type_id INTEGER PRIMARY KEY,
    ticket_type_name VARCHAR(20)
);

CREATE TABLE ticket_refund_sum (
    ticket_type_id INTEGER,
    remaining_time BIGINT,
    refund_percent INT NOT NULL,
    PRIMARY KEY (ticket_type_id, remaining_time),
    FOREIGN KEY (ticket_type_id) REFERENCES tickets_type(ticket_type_id)
);

CREATE TABLE events (
    event_id INTEGER PRIMARY KEY AUTOINCREMENT,
    event_name TEXT,
    ticket_type INTEGER NOT NULL,
    event_datetime DATETIME NOT NULL,
    FOREIGN KEY(ticket_type) REFERENCES tickets_type(ticket_type_id)
);

CREATE TABLE event_tickets (
    ticket_id INTEGER PRIMARY KEY AUTOINCREMENT,
    event_id INTEGER,
    seat TEXT,
    ticket_status VARCHAR(20) DEFAULT 'в продаже',
    FOREIGN KEY(event_id) REFERENCES event(ticket_type_id)
);

CREATE TABLE tickets_history (
    ticket_id INTEGER,
    status_date DATETIME DEFAULT (datetime('now', 'localtime')),
    ticket_status VARCHAR(20),
    PRIMARY KEY (ticket_id, status_date)
);
