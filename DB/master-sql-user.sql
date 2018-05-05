-- Table: test."user"

-- DROP TABLE test."user";

CREATE TABLE test."user"
(
    id bigint NOT NULL,
    name character(20) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE test."user"
    OWNER to postgresql;