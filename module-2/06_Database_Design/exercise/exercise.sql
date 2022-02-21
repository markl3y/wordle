--DROP TABLE IF EXISTS interest_group CASCADE;
--DROP TABLE IF EXISTS group_member CASCADE;
--DROP TABLE IF EXISTS event_member CASCADE;
--DROP TABLE IF EXISTS event;
--DROP TABLE IF EXISTS member;


CREATE TABLE member(
	member_number SERIAL NOT NULL PRIMARY KEY,
	last_name VARCHAR(64) NOT NULL,
	first_name VARCHAR(64) NOT NULL,
	email_address VARCHAR(64) NOT NULL,
	phone_number VARCHAR(12) NULL,
	birthday DATE NOT NULL,
	wants_reminders BOOLEAN NOT NULL
);

CREATE TABLE interest_group(
	group_number SERIAL NOT NULL,
	name VARCHAR(64) NOT NULL PRIMARY KEY,
	members INT NOT NULL,
	CHECK (members >= 0)
);

CREATE TABLE event(
	event_number SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	description VARCHAR(500) NOT NULL,
	start_date_time TIMESTAMP NOT NULL,
	duration INT NOT NULL,
	group_host VARCHAR(64) CONSTRAINT fk_group REFERENCES interest_group(name),
	members INT NOT NULL,
	CHECK (members >= 0)
);

CREATE TABLE group_member(
	member_number INT NOT NULL CONSTRAINT fk_member REFERENCES member(member_number), 
	interest_group VARCHAR(64) NOT NULL CONSTRAINT fk_interest_group REFERENCES interest_group(name)--,
	--CONSTRAINT pk_group_member PRIMARY KEY (member_number, interest_group)
);

CREATE TABLE event_member(
	member_number INT NOT NULL CONSTRAINT fk_member REFERENCES member(member_number),
	event_number INT NOT NULL CONSTRAINT fk_event REFERENCES event(event_number)--,
	--CONSTRAINT pk_event_member PRIMARY KEY (member_number, event_number)
);