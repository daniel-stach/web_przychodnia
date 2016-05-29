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
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-07-21 14:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-07-21 15:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-07-26 16:00:00', 1, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-08-13 17:00:00', 2, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-08-21 18:00:00', 2, NULL);
INSERT INTO terminy (data, id_lekarz, id_pacjent) VALUES ('2016-08-22 14:00:00', 3, NULL);
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Beata', 'Koziol', 'koziol@gmail.com', '01010190876', '098765432');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Waldemar', 'Koziol', 'waldek_koziol@gmail.com', '02020290876', '098767732');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Zbigniew', 'Szepczak', 'zbychu@gmail.com', '12345678900', '678456765');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Stefano', 'Terrazino', 'stefek@tlen.pl', '98567854765', '987123345');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Grzegorz', 'Podpalka', 'g_palka@icloud.com', '87020265456', '765456987');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Piotr', 'Palera', 'palera@icloud.com', '67050269956', '987567876');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Daniel', 'Laskota', 'laskota@icloud.com', '57040298456', '678456123');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Damian', 'Tymbark', 'tymbark@icloud.com', '47010265096', '654321123');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Przemyslaw', 'Zbyszko', 'zbyszko@icloud.com', '67090255456', '567890098');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Wojciech', 'Myszko', 'myszko@icloud.com', '88080265456', '767654389');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Bartlomiej', 'Wieden', 'wiedenski@icloud.com', '89020264556', '678909765');
INSERT INTO pacjenci (imie, nazwisko, email, pesel, telefon) VALUES ('Bratyslawa', 'Praga', 'pragowski@icloud.com', '57060264556', '675456789');
