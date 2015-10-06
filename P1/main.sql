DROP TABLE IF EXISTS receptes;
DROP TABLE IF EXISTS menjars;
DROP TABLE IF EXISTS plats;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS families;
DROP TABLE IF EXISTS xefs;
DROP TABLE IF EXISTS format_per;



CREATE TABLE menjars {
    nom VARCHAR(50) ,
    idMenjar INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)

};

CREATE TABLE plats {
    nom VARCHAR(50) ,
    idPlat INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)
};

CREATE TABLE ingredients {
    nom VARCHAR(50),
    idIngredient INTEGER ,
    refrigeracio BOOLEAN NOT NULL DEFAULT false ,
    familia INTEGER ,
    FOREIGN KEY (familia) REFERENCES families(idFamilia)
};

CREATE TABLE families {
    nom VARCHAR(50) ,
    idFamilia INTEGER PRIMARY KEY NOT NULL ,
    descripcio VARCHAR(150)

};

CREATE TABLE xefs {
    nom VARCHAR(50)  ,
    idXef INTEGER PRIMARY KEY NOT NULL,
    estrella INTEGER

};


CREATE TABLE receptes {
    nom VARCHAR(50) ,
    elaboracio VARCHAR(200) ,
    idRecepta INTEGER PRIMARY KEY NOT NULL ,
    temps INTEGER ,
    dificultat INTEGER,
    idX INTEGER ,
    idP INTEGER ,
    idM INTEGER ,
    FOREIGN KEY(idX) REFERENCES xefs(idXef) ,
    FOREIGN KEY(idP) REFERENCES plats(idPlat) ,
    FOREIGN KEY(idM) REFERENCES menjars(idMenjar) 
};



CREATE TABLE format_per {
    idR INTEGER ,
    idIngr INTEGER ,
    FOREIGN KEY(idR) REFERENCES receptes(idRecepta), 
    FOREIGN KEY(idIngr) REFERENCES ingredients(idIngredient)

};

