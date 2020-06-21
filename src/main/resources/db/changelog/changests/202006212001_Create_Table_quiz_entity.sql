CREATE TABLE quiz_entity
(
    ID          INT     NOT NULL,
    name        varchar NOT NULL,
    start_date  date    NOT NULL,
    finish_date date    NOT NULL,
    status      varchar NOT NULL,
    PRIMARY KEY (ID)
);