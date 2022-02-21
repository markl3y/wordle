DROP TABLE IF EXISTS customer_purchase; 
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS customer; 
DROP TABLE IF EXISTS artist;

CREATE TABLE customer (
	customer_id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	address VARCHAR(100) NOT NULL,
	phone VARCHAR(12) NOT NULL
);

CREATE TABLE artist (
	artist_id SERIAL NOT NULL PRIMARY KEY,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64) NOT NULL
);

CREATE TABLE art (
	art_id SERIAL NOT NULL PRIMARY KEY,
	title VARCHAR(64) NOT NULL,
	artist_id INT NOT NULL CONSTRAINT fk_artist REFERENCES artist(artist_id)
);

CREATE TABLE customer_purchase(
	customer_id INT NOT NULL CONSTRAINT fk_customer REFERENCES customer(customer_id), 
	art_id INT NOT NULL CONSTRAINT fk_art REFERENCES art(art_id),
	purchase_date TIMESTAMP NOT NULL,
	price MONEY NOT NULL,
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id, art_id, purchase_date)
);

ALTER TABLE customer_purchase
	ADD COLUMN sold_date TIMESTAMP NULL;
	

