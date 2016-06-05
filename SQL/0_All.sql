CREATE USER 'SmartMED'@'localhost' IDENTIFIED BY '*gi3q3r*';

CREATE DATABASE SmartMED CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON SmartMED.* TO 'SmartMED'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE IF NOT EXISTS konta (
  id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(50) NOT NULL,
  haslo varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS lekarze (
  id int(11) NOT NULL AUTO_INCREMENT,
  imie varchar(50) NOT NULL,
  nazwisko varchar(50) NOT NULL,
  specjalizacja varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS pacjenci (
  id int(11) NOT NULL AUTO_INCREMENT,
  imie varchar(50) NOT NULL,
  nazwisko varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  pesel varchar(11) NOT NULL,
  telefon varchar(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS terminy (
  id int(11) NOT NULL AUTO_INCREMENT,
  data datetime NOT NULL,
  id_lekarz int(11) NOT NULL,
  id_pacjent int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO konta (id, login, haslo) VALUES (1, 'Beata', 'elo520yo');
INSERT INTO lekarze (imie, nazwisko, specjalizacja) VALUES ('Joanna', 'Kowalska', 'Onkolog');
INSERT INTO lekarze (imie, nazwisko, specjalizacja) VALUES ('Genowefa', 'Pigwa', 'Alergolog');
INSERT INTO lekarze (imie, nazwisko, specjalizacja) VALUES ('Juliana', 'Hurka', 'Ginekolog');
INSERT INTO lekarze (imie, nazwisko, specjalizacja) VALUES ('Zbigniew', 'Wiszniewski', 'Onkolog');
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-04-21 14:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-05-21 15:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-05-26 16:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-06-13 17:00:00', 2, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-06-21 18:00:00', 2, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-06-22 14:00:00', 3, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-06-24 15:00:00', 3, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-06-25 16:00:00', 3, NULL);
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Beata', 'Koziol', 'koziol@gmail.com', '01010190876', '098765432');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Waldemar', 'Koziol', 'waldek_koziol@gmail.com', '02020290876', '098767732');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Zbigniew', 'Szepczak', 'zbychu@gmail.com', '12345678900', '678456765');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Stefano', 'Terrazino', 'stefek@tlen.pl', '98567854765', '987123345');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Grzegorz', 'Podpalka', 'g_palka@icloud.com', '87020265456', '765456987');
