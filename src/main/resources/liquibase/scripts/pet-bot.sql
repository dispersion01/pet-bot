-- liquibase formatted sql

-- changeset annaLihanova:1
CREATE TABLE IF NOT EXISTS owner
(
    chat_id            BIGINT   NOT NULL PRIMARY KEY,
    name              VARCHAR   NOT NULL
    );

CREATE TABLE IF NOT EXISTS pet
(
    id                bigint   NOT NULL PRIMARY KEY,
    name              VARCHAR   NOT NULL,
    age               INTEGER   NOT NULL,
    date_adoption     timestamp NOT NULL
    );
create table if not exists report
(
    id      integer not null primary key,
    photo   bytea   not null,
    message varchar not null
);

