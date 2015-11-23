DROP TABLE IF EXISTS inmoble;
DROP TABLE IF EXISTS sol;
DROP TABLE IF EXISTS tipus_inmoble;
DROP TABLE IF EXISTS subtipus_inmoble;
DROP TABLE IF EXISTS tipus_sol;
DROP TABLE IF EXISTS geolocalitzacio;
DROP TABLE IF EXISTS us;
DROP TABLE IF EXISTS propietari;
DROP TABLE IF EXISTS cadastre;



CREATE TABLE tipus_inmoble (
	id_tipusinmoble INTEGER PRIMARY KEY NOT NULL,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200) 
);

CREATE TABLE subtipus_inmoble (
	id_subtipus INTEGER PRIMARY KEY NOT NULL,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200),
	tipus_inmoble INTEGER
	FOREIGN KEY (tipus_inmoble) REFERENCES tipus_inmoble(id_tipusinmoble)
);

CREATE TABLE inmoble (
	id_inmoble INTEGER PRIMARY KEY NOT NULL, 
    superficie INTEGER,
    estat VARCHAR(50) ,
    internet BOOLEAN NOT NULL DEFAULT false ,
    ref_cadastral INTEGER ,
	num_residents INTEGER ,
	planta INTEGER ,
	subtipus_inmoble INTEGER
    FOREIGN KEY (subtipus_inmoble) REFERENCES subtipus_inmoble(id_subtipus)
);

CREATE TABLE tipus_sol (
	id_tipussol INTEGER NOT NULL,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200)
);

CREATE TABLE sol (
    id_sol INTEGER PRIMARY KEY NOT NULL , 
	superficie INTEGER ,
	tipus_sol INTEGER , 
	FOREIGN KEY (tipus_sol) REFERENCES tipus_sol(id_tipussol)
);


CREATE TABLE geolocalitzacio (
	id_geolocalitzacio INTEGER PRIMARY KEY NOT NULL ,
	x INTEGER ,
	y INTEGER ,
	z INTEGER
);

CREATE TABLE us (
	id_us INTEGER PRIMARY KEY NOT NULL ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200)
);

CREATE TABLE propietari (
	dni CHAR(9) PRIMARY KEY NOT NULL,
	nom VARCHAR(25) ,
	cognom1 VARCHAR(25) ,
	cognom2 VARCHAR(25) ,
	telefon INTEGER
);

CREATE TABLE cadastre (
	inmoble INTEGER ,
	propietari CHAR(9) ,
	sol INTEGER ,
	us INTEGER ,
	geolocalitzacio INTEGER ,
	any_cadastre INTEGER ,
	ciutat VARCHAR(25) ,
	FOREIGN KEY (inmoble) REFERENCES inmoble(id_inmoble) ,
	FOREIGN KEY (propietari) REFERENCES propietari(dni) ,
	FOREIGN KEY (sol) REFERENCES sol(id_sol) ,
	FOREIGN KEY (us) REFERENCES us(id_us) ,
	FOREIGN KEY (geolocalitzacio) REFERENCES geolocalitzacio(id_geolocalitzacio)
);
