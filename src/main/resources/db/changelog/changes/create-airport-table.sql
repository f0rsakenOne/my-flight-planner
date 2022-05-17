--liquibase formatted sql

--changeset janis:4

CREATE TABLE airport
(
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    airport VARCHAR(255) PRIMARY KEY
);