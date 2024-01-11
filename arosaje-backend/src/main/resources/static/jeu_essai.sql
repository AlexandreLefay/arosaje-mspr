INSERT INTO users (username, firstname, lastname, email, phone, street, city, zip, x, y, password) VALUES
('johndoe', 'John', 'Doe', 'john.doe@example.com', '1234567890', '1234 Elm Street', 'Anytown', '12345', 35.6895, 139.6917, 'password123'),
('janedoe', 'Jane', 'Doe', 'jane.doe@example.com', '0987654321', '5678 Oak Street', 'Anycity', '54321', 40.7128, -74.0060, 'password321');

INSERT INTO plants (user_id, name, species, care_instructions) VALUES
(1, 'Ficus', 'Ficus benjamina', 'Arrosez régulièrement.'),
(1, 'Cactus', 'Cactaceae', 'Peu d\'eau nécessaire.');

INSERT INTO tickets (user_id, title, description, status) VALUES
(1, 'Problème avec mon ficus', 'Les feuilles jaunissent.', 'ouvert'),
(2, 'Conseil pour cactus', 'Quel engrais utiliser ?', 'ouvert');

INSERT INTO guardianships (plant_id, guardian_user_id, start_date, end_date, status) VALUES
(1, 2, '2023-01-01', '2023-01-15', 'actif'),
(2, 1, '2023-02-01', '2023-02-15', 'actif');

INSERT INTO messages (sender_id, receiver_id, guardianship_id, content) VALUES
(1, 2, 1, 'Pouvez-vous arroser le ficus demain ?'),
(2, 1, 2, 'Le cactus va bien, ne vous inquiétez pas.');

INSERT INTO ticket_comments (ticket_id, user_id, comment) VALUES
(1, 2, 'Avez-vous vérifié l\'humidité du sol ?'),
(2, 1, 'Un engrais à faible teneur en azote est recommandé.');

INSERT INTO photos (reference_id, reference_type, image_blob) VALUES
(1, 'plant', '...blob data...'),
(1, 'ticket', '...blob data...');
