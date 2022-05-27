INSERT INTO ticket_types VALUES (1, "GOLD"), (2, "SILVER"), (3, "BRONZE");

INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+2 months') - strftime('%s', 'now'), 100);
INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+21 day') - strftime('%s', 'now'), 70);
INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+7 day') - strftime('%s', 'now'), 50);
INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+3 days') - strftime('%s', 'now'), 20);
INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+20 hours') - strftime('%s', 'now'), 5);
INSERT INTO ticket_refund_sum VALUES (1, strftime('%s', 'now', '+15 hours') - strftime('%s', 'now'), 0);

INSERT INTO ticket_refund_sum VALUES (2, strftime('%s', 'now', '+1 month') - strftime('%s', 'now'), 100);
INSERT INTO ticket_refund_sum VALUES (2, strftime('%s', 'now', '+7 day') - strftime('%s', 'now'), 80);
INSERT INTO ticket_refund_sum VALUES (2, strftime('%s', 'now', '+2 days') - strftime('%s', 'now'), 50);
INSERT INTO ticket_refund_sum VALUES (2, strftime('%s', 'now', '+10 hours') - strftime('%s', 'now'), 20);
INSERT INTO ticket_refund_sum VALUES (2, strftime('%s', 'now', '+3 hours') - strftime('%s', 'now'), 0);

INSERT INTO ticket_refund_sum VALUES (3, strftime('%s', 'now', '+21 day') - strftime('%s', 'now'), 100);
INSERT INTO ticket_refund_sum VALUES (3, strftime('%s', 'now', '+1 day') - strftime('%s', 'now'), 70);
INSERT INTO ticket_refund_sum VALUES (3, strftime('%s', 'now', '+7 hours') - strftime('%s', 'now'), 50);

insert into events values (1, "Концерт The Вепри", 3, datetime('now', '+2 day', 'localtime'));
insert into events values (2, "Science Slam", 2, datetime('now', '+10 day', 'localtime'));
insert into events values (3, "Николай Басков", 1, datetime('now', '+3 month'));
insert into events values (4, "ЦИПР", 1, datetime('now', '+14 hour', '+30 minute', 'localtime'));


INSERT INTO event_tickets(event_id) VALUES (1);
INSERT INTO event_tickets(event_id) VALUES (1);
INSERT INTO event_tickets(event_id) VALUES (1);

INSERT INTO event_tickets(event_id) VALUES (2);
INSERT INTO event_tickets(event_id) VALUES (2);
INSERT INTO event_tickets(event_id) VALUES (2);

INSERT INTO event_tickets(event_id, seat) VALUES (3, 'A2');
INSERT INTO event_tickets(event_id, seat) VALUES (4, 'B1');
