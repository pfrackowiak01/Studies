
CREATE TABLE osoby (
  id bigint(20) NOT NULL auto_increment,
  nazwisko varchar(20) default NULL,
  imie varchar(20) default NULL,
  zawod varchar(20) default NULL,
  wyksztalcenie varchar(20) default NULL,
  rokur int(11) default NULL,
  PRIMARY KEY  (id) 
) ENGINE=InnoDB;


INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Niedzwiedzki', 'Henryk', 'chirurg', 'wyzsze', 1971);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Golebiewski', 'Witold', 'pediatra', 'podstawowe', 1979);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Czerwinski', 'Henryk', 'chirurg', 'wyzsze', 1978);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Lantynski', 'Witold', 'fryzjer', 'podstawowe', 1964);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Kudelski', 'Waclaw', 'chirurg', 'wyzsze', 1953);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Kudelski', 'Witold', 'pediatra', 'zawodowe', 1973);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Czerwionke', 'Konrad', 'fryzjer', 'wyzsze', 1973);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Niedzwiecki', 'Waclaw', 'chirurg', 'wyzsze', 1961);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Czernicki', 'Henryk', 'pediatra', 'wyzsze', 1958);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ('Kowalski', 'Witold', 'fryzjer', 'srednie', 1966);

select * from osoby;