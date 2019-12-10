CREATE TABLE airport (airport_id int4 PRIMARY KEY, name VARCHAR(255), city VARCHAR(255), country VARCHAR(255), iata_code VARCHAR(255));

CREATE TABLE luggage (luggage_id int4  PRIMARY KEY, shelf VARCHAR(255), comment VARCHAR(255), fk_airport_id int4 references airport(airport_id));

--constraint fk_airport_id foreign key (luggage_id) references airport(airport_id));