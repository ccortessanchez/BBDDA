DROP TABLE IF EXISTS inmoble;
DROP TABLE IF EXISTS sol;
DROP TABLE IF EXISTS tipus_inmoble;
DROP TABLE IF EXISTS subtipus_inmoble;
DROP TABLE IF EXISTS tipus_sol;
DROP TABLE IF EXISTS geolocalitzacio;
DROP TABLE IF EXISTS us;
DROP TABLE IF EXISTS propietari;
DROP TABLE IF EXISTS ciutat;

CREATE TABLE ingredient (
    nom VARCHAR(50),
    idIngredient INTEGER ,
    refrigeracio BOOLEAN NOT NULL DEFAULT false ,
    familia INTEGER ,
    FOREIGN KEY (familia) REFERENCES familia(idFamilia)
);
