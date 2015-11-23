DROP TABLE IF EXISTS fecha CASCADE;
DROP TABLE IF EXISTS inmoble CASCADE;
DROP TABLE IF EXISTS sol CASCADE;
DROP TABLE IF EXISTS tipus_inmoble CASCADE;
DROP TABLE IF EXISTS subtipus_inmoble CASCADE;
DROP TABLE IF EXISTS tipus_sol CASCADE;
DROP TABLE IF EXISTS geolocalitzacio CASCADE;
DROP TABLE IF EXISTS us CASCADE;
DROP TABLE IF EXISTS propietari CASCADE;
DROP TABLE IF EXISTS cadastre CASCADE;


CREATE TABLE fecha(
  id_fecha INTEGER NOT NULL,
  
  id_anyo INTEGER NOT NULL,
  desc_anyo VARCHAR(20),

  id_mes INTEGER NOT NULL,
  desc_mes VARCHAR(20),

  id_dia INTEGER NOT NULL,
  desc_dia VARCHAR(20),
  
  PRIMARY KEY(id_fecha)
);

CREATE TABLE tipus_inmoble (
	id_tipusinmoble INTEGER NOT NULL,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200), 
	PRIMARY KEY (id_tipusinmoble)
);

CREATE TABLE subtipus_inmoble (
	id_subtipus INTEGER NOT NULL,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200),
	tipus_inmoble INTEGER , 
	PRIMARY KEY (id_subtipus) ,
	FOREIGN KEY (tipus_inmoble) REFERENCES tipus_inmoble(id_tipusinmoble)
);

CREATE TABLE inmoble (
	id_inmoble INTEGER NOT NULL, 
    superficie INTEGER,
    estat VARCHAR(50) ,
    internet BOOLEAN NOT NULL DEFAULT false ,
	num_residents INTEGER ,
	planta INTEGER ,
	subtipus_inmoble INTEGER ,
	PRIMARY KEY (id_inmoble)
    FOREIGN KEY (subtipus_inmoble) REFERENCES subtipus_inmoble(id_subtipus)
);

CREATE TABLE tipus_sol (
	id_tipussol INTEGER NOT NULL ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200) ,
	PRIMARY KEY (id_tipussol)
);

CREATE TABLE sol (
    id_sol INTEGER NOT NULL , 
	superficie INTEGER ,
	tipus_sol INTEGER , 
	PRIMARY KEY (id_sol) ,
	FOREIGN KEY (tipus_sol) REFERENCES tipus_sol(id_tipussol)
);


CREATE TABLE geolocalitzacio (
	id_geolocalitzacio INTEGER NOT NULL ,
	x INTEGER ,
	y INTEGER ,
	z INTEGER ,
	PRIMARY KEY (id_geolocalitzacio)
);

CREATE TABLE us (
	id_us INTEGER NOT NULL ,
	nom VARCHAR(50) ,
	descripcio VARCHAR(200) ,
	PRIMARY KEY (id_us)
);

CREATE TABLE propietari (
	dni CHAR(9) NOT NULL,
	nom VARCHAR(25) ,
	cognom1 VARCHAR(25) ,
	cognom2 VARCHAR(25) ,
	telefon INTEGER ,
	PRIMARY KEY (dni)
);

CREATE TABLE cadastre (
	ref_cadastral INTEGER NOT NULL ,
	inmoble_id INTEGER NOT NULL ,
	propietari_id CHAR(9) NOT NULL ,
	sol_id INTEGER NOT NULL,
	us_id INTEGER NOT NULL,
	geolocalitzacio_id INTEGER NOT NULL ,
	fecha_id INTEGER ,
	ciutat VARCHAR(25) ,
	PRIMARY KEY(ref_cadastral, inmoble_id,propietari_id,sol_id,us_id,geolocalitzacio_id, fecha_id),
	FOREIGN KEY (inmoble_id) REFERENCES inmoble(id_inmoble) ,
	FOREIGN KEY (propietari_id) REFERENCES propietari(dni) ,
	FOREIGN KEY (sol_id) REFERENCES sol(id_sol) ,
	FOREIGN KEY (us_id) REFERENCES us(id_us) ,
	FOREIGN KEY (geolocalitzacio_id) REFERENCES geolocalitzacio(id_geolocalitzacio) ,
	FOREIGN KEY (fecha_id) REFERENCES fecha(id_fecha)
);