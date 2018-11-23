CREATE TABLE javaee.usager 
(
id int NOT NULL AUTO_INCREMENT,
email varchar(255) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB;



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
exemplaire_id int NOT NULL,
date_pret date NOT NULL,
date_fin date NOT NULL,
PRIMARY KEY (id),
CONSTRAINT FK_pret_usager FOREIGN KEY (usager_id)
    REFERENCES javaee.usager(id),
CONSTRAINT FK_pret_exemplaire FOREIGN KEY (exemplaire_id)
    REFERENCES javaee.exemplaire(id)
) ENGINE=InnoDB;

CREATE TABLE javaee.relance
(
id int NOT NULL auto_increment,
pret_id int NOT NULL,
date_fin date NOT NULL,
PRIMARY KEY(id),
CONSTRAINT FK_relance_pret FOREIGN KEY (pret_id)
    REFERENCES javaee.pret(id)
) ENGINE=InnoDB;

CREATE TABLE javaee.exemplaire 
(
id int NOT NULL auto_increment,
ouvrage_id int NOT NULL,
PRIMARY KEY (id),
CONSTRAINT FK_ouvrage FOREIGN KEY (ouvrage_id)
    REFERENCES javaee.ouvrage(id)
)ENGINE = InnoDB;

SHOW CREATE TABLE javaee.exemplaire;

SELECT * FROM javaee.exemplaire;
SELECT * FROM javaee.pret;
SELECT * FROM javaee.relance;
SELECT * FROM javaee.ouvrage;
SELECT * FROM javaee.usager;

DELETE FROM javaee.relance WHERE id BETWEEN 1 AND 100000;
UPDATE javaee.exemplaire set pret_id = NULL  WHERE id BETWEEN 1 AND 100000;
DELETE FROM javaee.pret WHERE id BETWEEN 1 AND 100000;
DELETE FROM javaee.exemplaire WHERE id BETWEEN 1 AND 100000;
DELETE FROM javaee.usager WHERE id BETWEEN 1 AND 10000;
DELETE FROM javaee.ouvrage WHERE id BETWEEN 1 AND 10000;

SELECT *, COUNT(e.ouvrage_id) AS nb_ex 
FROM javaee.ouvrage o 
JOIN javaee.exemplaire e ON o.id = e.ouvrage_id
WHERE e.pret_id IS NOT NULL
GROUP BY titre
HAVING nb_ex = (SELECT COUNT(*) FROM javaee.exemplaire e2 
								JOIN javaee.ouvrage o2 ON o2.id = e2.ouvrage_id 
                                WHERE o2.id = o.id);

                                
SELECT *, COUNT(e.id) AS nb_ex 
FROM javaee.ouvrage o 
JOIN javaee.exemplaire e ON o.id = e.ouvrage_id
WHERE e.pret_id IS NULL
HAVING nb_ex > 0;

ALTER TABLE javaee.ouvrage DROP COLUMN ouvrage;
ALTER TABLE javaee.usager ADD unique (email);
ALTER TABLE javaee.ouvrage ALTER titre SET DEFAULT NULL;
ALTER TABLE javaee.exemplaire ADD COLUMN pret_id integer NULL;
ALTER TABLE javaee.exemplaire ENGINE = InnoDB;
ALTER TABLE javaee.pret ENGINE = InnoDB;
ALTER TABLE javaee.usager ENGINE = InnoDB;
ALTER TABLE javaee.relance ENGINE = InnoDB;
ALTER TABLE javaee.relance ENGINE = InnoDB;
ALTER TABLE javaee.exemplaire
ADD CONSTRAINT FK_exemplaire_pret
FOREIGN KEY (pret_id) REFERENCES javaee.pret(id);