DROP TABLE IF EXISTS recepta;
DROP TABLE IF EXISTS menjar;
DROP TABLE IF EXISTS plat;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS familia;
DROP TABLE IF EXISTS xef;
DROP TABLE IF EXISTS format_per;


CREATE TABLE ingredient (
    nom VARCHAR(50),
    idIngredient INTEGER ,
    refrigeracio BOOLEAN NOT NULL DEFAULT false ,
    familia INTEGER ,
    FOREIGN KEY (familia) REFERENCES familia(idFamilia)
);
