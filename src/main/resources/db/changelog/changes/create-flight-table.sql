--liquibase formatted sql

--changeset nikolajs:2

CREATE TABLE flight
(
    flight_id INTEGER PRIMARY KEY,
    from_id VARCHAR(255),
    to_id VARCHAR(255),
    carrier VARCHAR(255),
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP,
    CONSTRAINT flight_airport_from_fkey FOREIGN KEY (from_id) REFERENCES airport,
    CONSTRAINT flight_airport_to_fkey FOREIGN KEY (to_id) REFERENCES airport
);