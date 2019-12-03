CREATE TABLE airport (airport_id int4 PRIMARY KEY, name VARCHAR(255), location VARCHAR(255));

CREATE TABLE luggage (luggage_id int4  PRIMARY KEY, shelf VARCHAR(255), comment VARCHAR(255), fk_airport_id int4,
constraint fk_airport_id foreign key (luggage_id) references airport(airport_id));