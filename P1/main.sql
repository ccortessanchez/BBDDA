DROP TABLE IF EXISTS recepta;
DROP TABLE IF EXISTS menjar;
DROP TABLE IF EXISTS plat;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS familia;
DROP TABLE IF EXISTS xef;
DROP TABLE IF EXISTS format_per;



CREATE TABLE menjar {
    nom VARCHAR(50) ,
    idMenjar INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)

};

CREATE TABLE plat {
    nom VARCHAR(50) ,
    idPlat INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)
};

CREATE TABLE ingredient {
    nom VARCHAR(50),
    idIngredient INTEGER ,
    refrigeracio BOOLEAN NOT NULL DEFAULT false ,
    familia INTEGER ,
    FOREIGN KEY (familia) REFERENCES familia(idFamilia)
};

CREATE TABLE familia {
    nom VARCHAR(50) ,
    idFamilia INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)

};

CREATE TABLE xef {
    nom VARCHAR(50)  ,
    idXef INTEGER PRIMARY KEY NOT NULL,
    estrella INTEGER

};


CREATE TABLE recepta {
    nom VARCHAR(50) ,
    elaboracio VARCHAR(200) ,
    idRecepta INTEGER PRIMARY KEY NOT NULL ,
    temps INTEGER ,
    dificultat INTEGER,
    idX INTEGER ,
    idP INTEGER ,
    idM INTEGER ,
    FOREIGN KEY(idX) REFERENCES xef(idXef) ,
    FOREIGN KEY(idP) REFERENCES plat(idPlat) ,
    FOREIGN KEY(idM) REFERENCES menjar(idMenjar) 
};



CREATE TABLE format_per {
    idR INTEGER ,
    idIngr INTEGER ,
    FOREIGN KEY(idR) REFERENCES recepta(idRecepta), 
    FOREIGN KEY(idIngr) REFERENCES ingredient(idIngredient)

};

