DROP TABLE IF EXISTS inmoble;
DROP TABLE IF EXISTS sol;
DROP TABLE IF EXISTS tipus_inmoble;
DROP TABLE IF EXISTS subtipus_inmoble;
DROP TABLE IF EXISTS tipus_sol;
DROP TABLE IF EXISTS geolocalitzacio;
DROP TABLE IF EXISTS us;
DROP TABLE IF EXISTS propietari;
DROP TABLE IF EXISTS cadastre;
DROP TABLE IF EXISTS inscriu_sol_inmoble;


CREATE TABLE inmoble (
    superficie INTEGER,
    estat VARCHAR(50) ,
    internet BOOLEAN NOT NULL DEFAULT false ,
    ref_cadastral INTEGER PRIMARY KEY NOT NULL,
	num_residents INTEGER ,
	planta INTEGER
    --FOREIGN KEY (familia) REFERENCES familia(idFamilia)
);

CREATE TABLE sol (
	superficie INTEGER
	ref_cadastral INTEGER PRIMARY KEY NOT NULL
);

CREATE TABLE tipus_inmoble (
	id_tipusIn INTEGER ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200) 
);

CREATE TABLE subtipus_inmoble (
	id_subtipus INTEGER ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200)
);

CREATE TABLE tipus_sol (
	id_tipusSol INTEGER ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200)
);

CREATE TABLE geolocalitzacio (
	x INTEGER ,
	y INTEGER ,
	z INTEGER
);

CREATE TABLE us (
	id_us INTEGER ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200)
);

CREATE TABLE propietari (
	nom VARCHAR(25) ,
	cognom1 VARCHAR(25) ,
	cognom2 VARCHAR(25) ,
	dni CHAR(9) PRIMARY KEY NOT NULL,
	telefon INTEGER
);

CREATE TABLE cadastre (
	any_cadastre INTEGER ,
	ciutat VARCHAR(25)
);

CREATE TABLE inscriu_sol_inmoble (
	ref_inmoble INTEGER ,
	ref_sol INTEGER ,
	nom_ciutat VARCHAR(25) ,
	FOREIGN KEY (ref_inmoble) REFERENCES inmoble(ref_cadastral) ,
	FOREIGN KEY (ref_sol) REFERENCES sol(ref_cadastral) ,
	FOREIGN KEY (nom_ciutat) REFERENCES ciutat(nom)
);