CREATE SCHEMA IF NOT EXISTS slab4db DEFAULT CHARACTER SET utf8 ;
USE slab4db;

DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS vaccination;
DROP TABLE IF EXISTS tech_info;
DROP TABLE IF EXISTS technic;
DROP TABLE IF EXISTS technic_group;
DROP TABLE IF EXISTS bosch;

CREATE TABLE bosch (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(200) NOT NULL,
                       street VARCHAR(200) NOT NULL,
                       building_number INT NOT NULL)
    ENGINE = InnoDB;

CREATE TABLE technic_group (
                               id INT NOT NULL AUTO_INCREMENT,
                               bosch_id INT NOT NULL,
                               name VARCHAR(200) NOT NULL,
                               count_of_technics INT NOT NULL,
                               PRIMARY KEY (id, bosch_id),
                               CONSTRAINT fk_technic_group_bosch1
                                   FOREIGN KEY (bosch_id)
                                       REFERENCES bosch (id)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE worker (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(500) NOT NULL,
                        surname VARCHAR(500) NOT NULL,
                        date_of_employment DATE NOT NULL,
                        technic_group_id INT NOT NULL,
                        technic_group_bosch_id INT NOT NULL,
                        status VARCHAR(20) NOT NULL,
                        CONSTRAINT fk_worker_technic_group1
                            FOREIGN KEY (technic_group_id , technic_group_bosch_id)
                                REFERENCES technic_group (id , bosch_id)
                                ON DELETE CASCADE
                                ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE payment (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         worker_id INT NOT NULL,
                         salary FLOAT NOT NULL,
                         amount_of_remuneration FLOAT NULL,
                         date_of_pay DATE NOT NULL,
                         CONSTRAINT fk_payment_worker1
                             FOREIGN KEY (worker_id)
                                 REFERENCES worker (id)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE technic (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(500) NOT NULL,
                         date_of_entry DATE NOT NULL,
                         technic_group_id INT NOT NULL,
                         technic_group_bosch_id INT NOT NULL,
                         status VARCHAR(20) NOT NULL,
                         CONSTRAINT fk_technic_technic_group1
                             FOREIGN KEY (technic_group_id , technic_group_bosch_id)
                                 REFERENCES technic_group (id , bosch_id)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE vaccination (
                             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             technic_id INT NOT NULL,
                             name VARCHAR(100) NOT NULL,
                             date_of_vaccination DATE NOT NULL,
                             CONSTRAINT fk_vaccination_technic1
                                 FOREIGN KEY (technic_id)
                                     REFERENCES technic (id)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE tech_info (
                           technic_id INT NOT NULL PRIMARY KEY,
                           technic_name VARCHAR(500) NULL,
                           info_phone_number VARCHAR(10) NULL,
                           CONSTRAINT fk_tech_info_technic1
                               FOREIGN KEY (technic_id)
                                   REFERENCES technic (id)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE INDEX index_technic_group ON technic_group (bosch_id ASC);
CREATE INDEX index_worker ON worker (technic_group_id ASC, technic_group_bosch_id ASC);
CREATE INDEX index_technic ON  technic (technic_group_id ASC, technic_group_bosch_id ASC);

INSERT INTO bosch (id, name, street, building_number) VALUES
(1, '№1 Сонечко', 'Городоцька', 23 ),
(2, '№2 Метелик', 'П. Куліша', 48),
(3, '№3 Райдуга', 'І. Франка', 10),
(4, '№4 Квітка', 'Личаківська', 41),
(5, '№5 Еколенд', 'Червоної Калини', 51),
(6, '№6', 'Сихівська', 40),
(7, '№40 Ромашка', 'Наукова', 34),
(8, '№33', 'Кульпарківська', 103),
(9, '№9 Зірка', 'Широка', 44),
(10, '№10', 'Сяйво', 28);

INSERT INTO technic_group (id, bosch_id, name, count_of_technics) VALUES
(1, 1, 'Ромашка', 20),
(2, 2, 'Метелик', 14),
(3, 3, 'Казка', 18),
(4, 4, 'Бджілка', 13),
(5, 5, 'Троянда', 22),
(6, 6, 'Струмок', 30),
(7, 7, 'Сонечко', 27),
(8, 8, 'Річечка', 23),
(9, 9, 'Кошеня', 19),
(10, 10, 'Ведмежа', 21);

INSERT INTO worker (id, name, surname, date_of_employment, technic_group_id, technic_group_bosch_id, status) VALUES
(1, 'Анастасія', 'Іванчук', '2001-11-11', 1, 1, 'FIRED'),
(2, 'Надія', 'Тарасенко', '2010-10-10', 2, 2, 'FIRED'),
(3, 'Поліна', 'Шевченко', '2015-09-01', 3, 3, 'FIRED'),
(4, 'Ангеліна', 'Кравчук', '2010-12-12', 4, 4, 'FIRED'),
(5, 'Аліна', 'Янукович', '2002-05-05', 5, 5, 'WORKING'),
(6, 'Валерія', 'Віденська', '2007-07-07', 6, 6, 'WORKING'),
(7, 'Софія', 'Домбровська', '2009-09-09', 7, 7, 'WORKING'),
(8, 'Кіра', 'Франко', '2001-09-11', 8, 8, 'WORKING'),
(9, 'Марія', 'Чуприк', '2016-09-16',  9, 9, 'WORKING'),
(10, 'Ксенія', 'Верес', '2015-03-01', 10, 10, 'ON VACATION');

INSERT INTO payment (id, worker_id, salary, amount_of_remuneration, date_of_pay) VALUES
(1, 5, 4500, 500, '2020-10-05'),
(2, 6, 5000, NULL, '2020-10-05'),
(3, 7, 4200, NULL, '2020-10-05'),
(4, 8, 3800, 1000, '2020-10-05'),
(5, 9, 5500, NULL, '2020-10-05');

INSERT INTO technic (id, name, date_of_entry, technic_group_id, technic_group_bosch_id, status) VALUES
(1, 'Андрій', '2015-09-01', 1, 1, 'RELEASE'),
(2, 'Марія',  '2016-09-01', 2, 2, 'RELEASE'),
(3, 'Максим',  '2017-09-01', 3, 3, 'STUDYING'),
(4, 'Анастасія',  '2015-09-01', 4, 4, 'RELEASE'),
(5, 'Микита',  '2016-09-01', 5, 5, 'RELEASE'),
(6, 'Ольга',  '2017-09-01', 6, 6, 'STUDYING'),
(7, 'Антон',  '2018-09-01', 7, 7, 'STUDYING'),
(8, 'Яна',  '2018-11-11', 8, 8, 'STUDYING'),
(9, 'Олег',  '2017-04-04', 9, 9, 'STUDYING'),
(10, 'Вероніка',  '2016-09-01', 10, 10, 'RELEASE');

INSERT INTO vaccination (id, technic_id, name, date_of_vaccination) VALUES
(1, 3, 'Холера', '2017-09-21'),
(2, 6, 'Холера', '2017-09-21'),
(3, 7, 'Скарлатина', '2018-09-21'),
(4, 8, 'Скарлатина', '2018-09-21'),
(5, 9, 'Холера', '2017-09-21');

INSERT INTO tech_info (technic_id, technic_name, info_phone_number) VALUES
(3, 'Максименко',  '0671502846'),
(6, 'Нестай',  '0661230984'),
(7, 'Ліненко', '0671232343'),
(8, 'Олена',  '0981475964'),
(9, 'Олешків', '0670492740');