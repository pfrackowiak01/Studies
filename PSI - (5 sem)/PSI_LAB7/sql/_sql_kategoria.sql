-- Table: laravel_ksiazki.kategoria

-- DROP TABLE laravel_ksiazki.kategoria;

CREATE SEQUENCE laravel_ksiazki.kategoria_id_seq;
CREATE TABLE laravel_ksiazki.kategoria
(
    id bigint NOT NULL DEFAULT nextval('laravel_ksiazki.kategoria_id_seq'::regclass),
    opis character varying(50) NOT NULL,
    CONSTRAINT kategoria_pkey PRIMARY KEY (id)
)
WITH (OIDS = FALSE)
TABLESPACE pg_default;

ALTER SEQUENCE laravel_ksiazki.kategoria_id_seq OWNED BY laravel_ksiazki.kategoria.id;