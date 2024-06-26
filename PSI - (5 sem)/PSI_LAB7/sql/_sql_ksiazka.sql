-- Table: laravel_ksiazki.ksiazka

-- DROP TABLE laravel_ksiazki.ksiazka;

CREATE SEQUENCE laravel_ksiazki.ksiazka_id_seq;
CREATE TABLE laravel_ksiazki.ksiazka
(
    id bigint NOT NULL DEFAULT nextval('laravel_ksiazki.ksiazka_id_seq'),
    tytul character varying(60) NOT NULL,
    idwyd integer,
    idkat integer,
    CONSTRAINT ksiazka_pkey PRIMARY KEY (id)
)
WITH (OIDS = FALSE)
TABLESPACE pg_default;

ALTER SEQUENCE laravel_ksiazki.ksiazka_id_seq OWNED BY laravel_ksiazki.ksiazka.id; 