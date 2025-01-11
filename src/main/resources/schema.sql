-- schema.sql

-- Créer la base de données (si elle n'existe pas déjà)
CREATE DATABASE IF NOT EXISTS facturation_piano;

-- Utiliser la base de données
USE facturation_piano;

-- Création des tables
CREATE TABLE IF NOT EXISTS Student (
                                       student_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       first_name VARCHAR(100),
                                       last_name VARCHAR(100),
                                       address VARCHAR(200),
                                       zip_code VARCHAR(20),
                                       city VARCHAR(100),
                                       phone_number VARCHAR(20),
                                       mail VARCHAR(100),
                                       take_courses BOOLEAN
);

CREATE TABLE IF NOT EXISTS StudentChild (
                                            student_child_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            last_name VARCHAR(100),
                                            first_name VARCHAR(100),
                                            student_id BIGINT,
                                            FOREIGN KEY (student_id) REFERENCES Student(student_id)
);

CREATE TABLE IF NOT EXISTS Course (
                                      course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      date DATE,
                                      duration DOUBLE,
                                      student_id BIGINT,
                                      student_child_id BIGINT,
                                      FOREIGN KEY (student_id) REFERENCES Student(student_id),
                                      FOREIGN KEY (student_child_id) REFERENCES StudentChild(student_child_id)
);

CREATE TABLE IF NOT EXISTS Bill (
                                    bill_number BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    amount DOUBLE,
                                    sent_date DATE,
                                    relaunched_date DATE,
                                    bill_status VARCHAR(50),
                                    payment_type VARCHAR(50),
                                    payment_status VARCHAR(50),
                                    student_id BIGINT,
                                    course_id BIGINT,
                                    FOREIGN KEY (student_id) REFERENCES Student(student_id),
                                    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
