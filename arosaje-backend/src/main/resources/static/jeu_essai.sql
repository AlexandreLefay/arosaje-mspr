INSERT INTO roles (id, name) VALUES
 (1, 'ADMIN'),
 (2, 'USER'),
 (3, 'BOTANIST');

INSERT INTO status (id, name) VALUES
(1, 'IN PROGRESS'),
(2, 'PENDING'),
(3, 'CLOSED');

INSERT INTO users (id, active, city, street, zip, created_at, email, firstname, lastname, password, phone, updated_at, username, x, y) VALUES
(1, 1, 'New William', 'Jessica Island', '02353', '2022-10-24 16:06:40', 'ymay@peterson-crawford.org', 'Cassandra', 'Powers', '$2a$10$R6q5SD5yNOVXRakKz7VQy.lVDJz9ClehPBIgIfA8l4JlR3hmHoFPe', '001-342-773-0549x116', '2020-06-06 09:39:16', 'arosaje', -39.733311, 8.908165),
(2, 1, 'Michaelmouth', 'Kevin Branch', '45534', '2022-06-10 22:37:07', 'gregorylawson@hotmail.com', 'Lori', 'Zamora', '$2a$10$R6q5SD5yNOVXRakKz7VQy.lVDJz9ClehPBIgIfA8l4JlR3hmHoFPe', '382-927-2935x4730', '2021-04-11 13:51:44', 'arosaje', 13.768757, 76.842686),
(3, 1, 'South Wanda', 'Cassandra Keys', '68235', '2020-01-27 21:37:35', 'blackwelljason@ali.biz', 'Kyle', 'Webster', '$2a$10$R6q5SD5yNOVXRakKz7VQy.lVDJz9ClehPBIgIfA8l4JlR3hmHoFPe', '574-000-2323x07447', '2022-02-22 18:20:46', 'arosaje', -83.208637, -81.183681),
(4, 1, 'Terrifurt', 'Moreno Rest', '16711', '2020-02-24 09:14:43', 'scott95@mack.biz', 'Regina', 'Bates', '$2a$10$R6q5SD5yNOVXRakKz7VQy.lVDJz9ClehPBIgIfA8l4JlR3hmHoFPe', '(174)810-3361x4237', '2023-12-05 05:55:49', 'arosaje', -29.88286, 10.164089),
(5, 1, 'Stewarttown', 'Klein Villages', '12042', '2021-01-17 20:07:25', 'smorales@hotmail.com', 'Richard', 'Castaneda', '$2a$10$R6q5SD5yNOVXRakKz7VQy.lVDJz9ClehPBIgIfA8l4JlR3hmHoFPe', '233.360.7495', '2020-01-06 17:28:13', 'arosaje', -10.538765, -47.935761);


INSERT INTO plants (id, care_instructions, created_at, name, species, updated_at, user_id) VALUES
(1, 'Low authority whole. Dream happy they training buy citizen yeah.', '2022-09-08 09:57:25', 'though', 'support', '2021-08-19 16:35:55', 1),
(2, 'Apply decision whole defense many. Attack lead human serve easy open. Go admit yes stage.', '2020-09-06 06:08:16', 'Congress', 'between', '2023-07-23 16:58:20', 1),
(3, 'Perhaps stuff middle minute value common. Pressure feel hotel none left game professional.', '2021-02-14 13:41:05', 'everybody', 'consumer', '2022-09-26 03:44:53', 3),
(4, 'Study none catch which.', '2020-03-12 07:50:28', 'at', 'staff', '2021-11-29 16:55:31', 4),
(5, 'Happen already within specific success know.', '2023-10-28 23:15:20', 'economic', 'purpose', '2021-05-24 08:50:00', 4);

INSERT INTO tickets (id, created_at, description, status, title, updated_at, user_id) VALUES
(1, '2020-04-07 02:08:37', 'Name interest along prepare. Factor outside teach morning skin town key.', 'Pending', 'Two interview seek base their go now.', '2023-08-19 00:18:17', 3),
(2, '2022-07-29 17:42:28', 'State happen family hotel go. Important produce send whatever stand purpose. Behind onto three strong field happy. Who start center decide. Great best represent wear relationship.', 'Closed', 'Main choose account similar hour week summer fly.', '2021-09-23 03:38:31', 2),
(3, '2020-09-19 19:58:19', 'Really choose central talk data reality eat. Watch marriage food. Arrive officer mother. Staff long physical you.', 'Open', 'Activity value alone.', '2023-04-18 13:23:08', 2),
(4, '2020-01-01 10:50:14', 'Congress hospital ground around section. Article consider least bank suddenly.', 'Closed', 'Mother idea short bag produce begin visit.', '2023-04-17 23:14:54', 5),
(5, '2021-06-04 21:26:02', 'Economy human budget. This generation professor sign them prove probably. Somebody sign sense color. Court say admit tax. Prevent better try room Mr interest. Mean old young.', 'Pending', 'Much song sea up dinner.', '2021-08-30 18:50:37', 5);

INSERT INTO ticket_comments (id, comment, created_at, ticket_id, user_id) VALUES
(1, 'Answer out rock there major human. Theory western several law. Will affect ground. Statement receive land win little natural even whether.', '2022-08-30 13:54:40', 2, 1),
(2, 'Final child president water. Throughout effort nor upon. Then foot alone hope dream ball.', '2022-03-27 07:24:11', 3, 3),
(3, 'Color but contain many each. Be me white front focus grow. Change include meeting consumer.', '2021-12-10 11:04:33', 4, 3),
(4, 'With direction door might north nearly a. Huge can shoulder. Seat conference draw impact establish again. Movement may voice from north.', '2021-05-28 00:43:43', 1, 2),
(5, 'Painting believe statement event recently travel. Every another author between nation audience view.', '2020-10-01 21:08:05', 2, 2);


INSERT INTO user_roles (user_id, role_id) VALUES
(1, 3), (2, 2), (3, 2), (4, 2), (5, 2);

INSERT INTO guardianships (description, end_date, start_date, title, guardian_user_id, owner_user_id, plant_id, status_id ) VALUES
('Low authority whole. Dream happy they training buy citizen yeah.', '2022-09-08 09:57:25', '2021-08-19 16:35:55', 'though', 1, 2, 1, 2),
('Apply decision whole defense many. Attack lead human serve easy open. Go admit yes stage.', '2020-09-06 06:08:16', '2023-07-23 16:58:20', 'Congress', 1, 2, 2, 3),
('Perhaps stuff middle minute value common. Pressure feel hotel none left game professional.', '2021-02-14 13:41:05', '2022-09-26 03:44:53', 'everybody', 3, 2, 3, 1),
('Study none catch which.', '2020-03-12 07:50:28', '2021-11-29 16:55:31', 'at', 4, 2, 4,1),
('Happen already within specific success know.', '2023-10-28 23:15:20', '2021-05-24 08:50:00', 'economic', 5, 2, 5,2);

INSERT INTO messages (id, content, created_at, updated_at, receiver_id, sender_id, guardianship_id) VALUES
(1, 'Name interest along prepare. Factor outside teach morning skin town key.', '2020-04-07 02:08:37', '2023-08-19 00:18:17', 3, 1, 1),
(2, 'State happen family hotel go. Important produce send whatever stand purpose. Behind onto three strong field happy. Who start center decide. Great best represent wear relationship.', '2022-07-29 17:42:28', '2021-09-23 03:38:31', 2, 1, 1),
(3, 'Really choose central talk data reality eat. Watch marriage food. Arrive officer mother. Staff long physical you.', '2020-09-19 19:58:19', '2023-04-18 13:23:08', 2, 1, 2),
(4, 'Congress hospital ground around section. Article consider least bank suddenly.', '2020-01-01 10:50:14', '2023-04-17 23:14:54', 5, 1, 2),
(5, 'Economy human budget. This generation professor sign them prove probably. Somebody sign sense color. Court say admit tax. Prevent better try room Mr interest. Mean old young.', '2021-06-04 21:26:02', '2021-08-30 18:50:37', 5, 1, 3);