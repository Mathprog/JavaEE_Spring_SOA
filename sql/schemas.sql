CREATE TABLE javaee.usager 
(
id int NOT NULL AUTO_INCREMENT,
email varchar(255) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB;

SELECT * FROM javaee.usager;

CREATE TABLE javaee.ouvrage
(
id int NOT NULL auto_increment,
titre varchar(255) NOT NULL,
nb_dispo int,
PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE javaee.pret
(
id int NOT NULL auto_increment,
usager_id int NOT NULL,
ouvrage_id int NOT NULL,
date_pret date NOT NULL,
date_fin date NOT NULL,
PRIMARY KEY (id),
CONSTRAINT FK_pret_usager FOREIGN KEY (usager_id)
    REFERENCES javaee.usager(id),
CONSTRAINT FK_pret_ouvrage FOREIGN KEY (ouvrage_id)
    REFERENCES javaee.ouvrage(id)
) ENGINE=InnoDB;

CREATE TABLE javaee.relance
(
id int NOT NULL auto_increment,
pret_id int NOT NULL,
date_fin date NOT NULL,
PRIMARY KEY(id),
 FOREIGN KEY(pret_id) REFERENCES javaee.pret(id)
) ENGINE=InnoDB;