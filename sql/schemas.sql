CREATE TABLE javaee.usager 
(
id int NOT NULL AUTO_INCREMENT,
email varchar(255) NOT NULL UNIQUE,
PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE VIEW javaee.nbouvrage AS SELECT COUNT(*) FROM javaee.ouvrage;

CREATE TABLE javaee.ouvrage
(
id int NOT NULL auto_increment,
titre varchar(255) NOT NULL,
auteur CHAR(80),
resume varchar(500),
image char(80),
imageb BLOB,
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
SELECT * FROM javaee.ouvrage;/*1056*/
SELECT * FROM javaee.usager;/*1051*/

DELETE FROM javaee.relance WHERE id BETWEEN 1 AND 1000000;
UPDATE javaee.exemplaire set pret_id = NULL  WHERE id BETWEEN 1 AND 1000000;
DELETE FROM javaee.pret WHERE id BETWEEN 1 AND 1000000;
DELETE FROM javaee.exemplaire WHERE id BETWEEN 1 AND 1000000;
DELETE FROM javaee.usager WHERE id BETWEEN 1 AND 100000;
DELETE FROM javaee.ouvrage WHERE id BETWEEN 1 AND 100000;

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
LEFT JOIN javaee.exemplaire e ON o.id = e.ouvrage_id
WHERE o.titre LIKE "%Spring%"
GROUP BY o.id;



ALTER TABLE javaee.ouvrage DROP COLUMN ouvrage;
ALTER TABLE javaee.usager ADD unique (email);
ALTER TABLE javaee.ouvrage ALTER titre SET DEFAULT NULL;
ALTER TABLE javaee.exemplaire ADD COLUMN pret_id integer NULL;
ALTER TABLE javaee.ouvrage ADD COLUMN auteur CHAR(80) NULL;
ALTER TABLE javaee.ouvrage ADD COLUMN resume VARCHAR(500) NULL;
ALTER TABLE javaee.ouvrage ADD COLUMN image CHAR(80) NULL;
ALTER TABLE javaee.ouvrage ADD COLUMN imageb BLOB NULL;
ALTER TABLE javaee.exemplaire ENGINE = InnoDB;
ALTER TABLE javaee.pret ENGINE = InnoDB;
ALTER TABLE javaee.usager ENGINE = InnoDB;
ALTER TABLE javaee.relance ENGINE = InnoDB;
ALTER TABLE javaee.relance ENGINE = InnoDB;
ALTER TABLE javaee.exemplaire
ADD CONSTRAINT FK_exemplaire_pret
FOREIGN KEY (pret_id) REFERENCES javaee.pret(id);




select usagerimpl0_.id as id1_4_, 
email as email2_4_ 
from javaee.usager usagerimpl0_ 
inner join javaee.pret prets1_ on usagerimpl0_.id=prets1_.usager_id 
where prets1_.date_fin < current_date
and  not (exists (select relanceimp3_.id 
from javaee.relance relanceimp3_ 
inner join javaee.pret pretimpl4_ on relanceimp3_.pret_id=pretimpl4_.id 
where pretimpl4_.id=prets1_.id));

select distinct usagerimpl0_.id as id1_4_, usagerimpl0_.email as email2_4_ from usager usagerimpl0_ inner join pret prets1_ on usagerimpl0_.id=prets1_.usager_id inner join relance relanceimp2_ on prets1_.id=relanceimp2_.pret_id where relanceimp2_.date_fin<current_date