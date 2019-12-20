CREATE TABLE airport (airport_id int4 PRIMARY KEY, name VARCHAR(255), city VARCHAR(255), country VARCHAR(255), iata_code VARCHAR(255));

CREATE TABLE owner (owner_id int4 PRIMARY KEY, first_name VARCHAR(255), sur_name VARCHAR(255), phone_number VARCHAR(255));

CREATE TABLE luggage (luggage_id int4  PRIMARY KEY, shelf VARCHAR(255), comment VARCHAR(255), fk_airport_id int4 references airport(airport_id),
fk_owner_id int4 references owner(owner_id));

