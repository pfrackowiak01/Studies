CREATE TABLE osoby
(
  id serial,
  nazwisko character varying(20),
  imie character varying(20),
  zawod character varying(20),
  wyksztalcenie character varying(20),
  rokur integer,
  CONSTRAINT osoby_pkey PRIMARY KEY (id)
);


INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Niedzwiedzki', 'Henryk', 'chirurg', 'wyzsze', 1971);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Golebiewski', 'Witold', 'pediatra', 'podstawowe', 1979);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Czerwinski', 'Henryk', 'chirurg', 'wyzsze', 1978);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Laeantynski', 'Witold', 'fryzjer', 'podstawowe', 1964);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Kudelski', 'Waclaw', 'chirurg', 'wyzsze', 1953);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Kudelski', 'Witold', 'pediatra', 'zawodowe', 1973);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Czerwionke', 'Konrad', 'fryzjer', 'wyzsze', 1973);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Niedzwiecki', 'Waclaw', 'chirurg', 'wyższe', 1961);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES ( 'Czernicki', 'Henryk', 'pediatra', 'wyzsze', 1958);
INSERT INTO osoby (nazwisko, imie, zawod, wyksztalcenie, rokur) VALUES (
'Kowalski', 'Witold', 'fryzjer', 'srednie', 1966);

select * from osoby;