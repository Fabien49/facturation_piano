-- Insertion des étudiants
INSERT INTO Student (first_name, last_name, address, zip_code, city, phone_number, mail, take_courses)
VALUES
    ('Alice', 'Martin', '10 rue des Fleurs', '75000', 'Paris', '0123456789', 'alice.martin@gmail.com', true),
    ('Bob', 'Durand', '15 avenue des Champs', '69000', 'Lyon', '0987654321', 'bob.durand@gmail.com', true),
    ('Charlie', 'Lemoine', '20 place du Marché', '31000', 'Toulouse', '0223344556', 'charlie.lemoine@gmail.com', true),
    ('Diana', 'Roche', '5 impasse des Érables', '44000', 'Nantes', '0336677889', 'diana.roche@gmail.com', false),
    ('Eve', 'Morel', '8 rue des Vignes', '13000', 'Marseille', '0444556677', 'eve.morel@gmail.com', true),
    ('Frank', 'Dubois', '12 chemin des Bois', '75016', 'Paris', '0555667788', 'frank.dubois@gmail.com', true),
    ('Grace', 'Lambert', '25 boulevard Saint-Michel', '75005', 'Paris', '0777888999', 'grace.lambert@gmail.com', true),
    ('Henry', 'Bernard', '30 avenue des Lumières', '33000', 'Bordeaux', '0888999900', 'henry.bernard@gmail.com', false),
    ('Ivy', 'Perret', '2 rue de l''Horloge', '69001', 'Lyon', '0999000011', 'ivy.perret@gmail.com', true),
('Jack', 'Laurent', '50 allée des Pins', '14000', 'Caen', '0112233445', 'jack.laurent@gmail.com', true);

-- Insertion des enfants des étudiants
INSERT INTO StudentChild (last_name, first_name, student_id)
VALUES
('Martin', 'Sophie', 1),
('Durand', 'Lucas', 2),
('Lemoine', 'Emma', 3),
('Roche', 'Paul', 4),
('Morel', 'Julie', 5),
('Dubois', 'Nicolas', 6),
('Lambert', 'Clara', 7),
('Bernard', 'Antoine', 8),
('Perret', 'Marie', 9),
('Laurent', 'Thomas', 10);

-- Insertion des cours (durations : 0.5, 0.75, 1, 1.5, 2 heures)
INSERT INTO Course (date, duration, student_id, student_child_id)
VALUES
('2025-01-01', 0.5, 1, 1),
('2025-01-03', 0.75, 2, 2),
('2025-01-05', 1.0, 3, 3),
('2025-01-07', 1.5, 4, 4),
('2025-01-10', 2.0, 5, 5),
('2025-01-12', 0.5, 6, 6),
('2025-01-15', 1.0, 7, 7),
('2025-01-17', 1.5, 8, 8),
('2025-01-20', 0.75, 9, 9),
('2025-01-25', 2.0, 10, 10);

-- Insertion des factures
INSERT INTO Bill (amount, sent_date, relaunched_date, bill_status, payment_type, payment_status, student_id, course_id)
VALUES
(60.00, '2025-01-02', NULL, 'SENT', 'CASH', 'CREATED', 1, 1),
(90.00, '2025-01-04', '2025-01-05', 'RELAUNCHED', 'TRANSFER', 'CREATED', 2, 2),
(120.00, '2025-01-06', NULL, 'SET', 'CHECK', 'VALIDATED', 3, 3),
(150.00, '2025-01-08', NULL, 'SENT', 'CASH', 'CREATED', 4, 4),
(180.00, '2025-01-11', '2025-01-12', 'RELAUNCHED', 'CARD', 'CREATED', 5, 5),
(60.00, '2025-01-13', NULL, 'SET', 'CASH', 'VALIDATED', 6, 6),
(120.00, '2025-01-16', NULL, 'SENT', 'TRANSFER', 'CREATED', 7, 7),
(150.00, '2025-01-18', '2025-01-19', 'RELAUNCHED', 'CARD', 'CREATED', 8, 8),
(90.00, '2025-01-21', NULL, 'SET', 'CHECK', 'VALIDATED', 9, 9),
(180.00, '2025-01-26', NULL, 'SENT', 'CASH', 'CREATED', 10, 10);
