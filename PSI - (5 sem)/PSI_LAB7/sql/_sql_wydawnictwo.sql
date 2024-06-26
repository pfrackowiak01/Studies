-- Table: laravel_ksiazki.wydawnictwo

-- DROP TABLE laravel_ksiazki.wydawnictwo;

CREATE SEQUENCE laravel_ksiazki.wydawnictwo_id_seq;
CREATE TABLE laravel_ksiazki.wydawnictwo
(
    id bigint NOT NULL DEFAULT nextval('laravel_ksiazki.wydawnictwo_id_seq'::regclass),
    nazwa character varying(50) NOT NULL,
    adres character varying,
    CONSTRAINT wydawnictwo_pkey PRIMARY KEY (id)
)
WITH (OIDS = FALSE)
TABLESPACE pg_default;

ALTER SEQUENCE laravel_ksiazki.wydawnictwo_id_seq OWNED BY laravel_ksiazki.wydawnictwo.id;


