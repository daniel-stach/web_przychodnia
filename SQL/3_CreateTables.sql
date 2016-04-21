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

