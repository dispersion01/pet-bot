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
    owner_chat_id     bigint   NOT NULL,
    name              VARCHAR   NOT NULL,
    age               BIGINT   NOT NULL,
    date_adoption     timestamp NOT NULL
    );
create table if not exists report
(
    id     bigint not null primary key,
    owner_id     bigint   NOT NULL,
    photo   bytea   not null,
    message varchar not null
);

