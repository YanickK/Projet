----
-- phpLiteAdmin database dump (http://phpliteadmin.googlecode.com)
-- phpLiteAdmin version: 1.9.2
-- Exported on Nov 13th, 2012, 02:42:56AM
-- Database file: ./Service.sqlite
----

----
-- Table structure for Menu
----
CREATE TABLE Menu(Id_Menu INTEGER PRIMARY KEY NOT NULL, Heure_min INTEGER, Heure_max INTEGER, Nom_Menu TEXT);

----
-- Data dump for Menu, a total of 3 rows
----
BEGIN TRANSACTION;
INSERT INTO Menu (Id_Menu,Heure_min,Heure_max,Nom_Menu) VALUES ('1','600','1100','Déjeuner');
INSERT INTO Menu (Id_Menu,Heure_min,Heure_max,Nom_Menu) VALUES ('2','1100','1600','Lunch');
INSERT INTO Menu (Id_Menu,Heure_min,Heure_max,Nom_Menu) VALUES ('3','1600','2300','Souper');
COMMIT;

----
-- Table structure for Repas
----
CREATE TABLE Repas(Id_Repas INTEGER PRIMARY KEY NOT NULL, Nom_Repas TEXT NOT NULL, Prix_Repas INTEGER NOT NULL, Desc_Repas REAL);

----
-- Data dump for Repas, a total of 14 rows
----
BEGIN TRANSACTION;
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('1','Le classique','8.99','Deux oeufs à votre goût, 2 toats, ');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('2','Café','1.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('3','Jus d''orange','2.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('4','Boisson gazeuse','1.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('5','Galettes de sarrazin','11.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('6','Scones','6.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('7','Soupe du jour','5.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('8','Hambuger du chef','8.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('9','Burrito','7,99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('10','Frites','3.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('11','pizza margherita','8.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('12','Pizza à la viande','9.99','');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('13','Steak tartare','21,99','Viande crue marinée... yum!');
INSERT INTO Repas (Id_Repas,Nom_Repas,Prix_Repas,Desc_Repas) VALUES ('14','Filet de sole','19.99','Poisson cuit à l''étouffée avec légumes braisés');
COMMIT;

----
-- Table structure for Ingredients
----
CREATE TABLE Ingredients(Id_Ingredients INTEGER PRIMARY KEY NOT NULL, Nom_Ingredients TEXT NOT NULL);

----
-- Data dump for Ingredients, a total of 12 rows
----
BEGIN TRANSACTION;
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('1','Fromage cheddar');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('2','Laitue');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('3','Cornichon');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('4','Ketchup');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('5','Matière grasse non hydrogénée');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('6','Monoglycéride');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('7','Sel');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('8','Sucre et dérivés (glucose, fructose, etc.)');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('9','Tomate');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('10','Bacon');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('11','Vinaigre');
INSERT INTO Ingredients (Id_Ingredients,Nom_Ingredients) VALUES ('12','Boeuf');
COMMIT;

----
-- Table structure for Menu_Repas
----
CREATE TABLE Menu_Repas (
    Id_Menu integer not null,
    Id_Repas  integer not null,
    foreign key (Id_Menu) references Menu(Id_Menu),
    foreign key (Id_Repas) references Repas(Id_Repas),
    primary key (Id_Menu, Id_Repas)
);

----
-- Data dump for Menu_Repas, a total of 20 rows
----
BEGIN TRANSACTION;
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','2');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','1');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','3');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','4');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','5');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('1','6');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','2');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','3');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','4');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','7');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','8');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','9');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','10');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','11');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('2','12');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('3','2');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('3','4');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('3','7');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('3','13');
INSERT INTO Menu_Repas (Id_Menu,Id_Repas) VALUES ('3','14');
COMMIT;

----
-- Table structure for Repas_Ingredients
----
CREATE TABLE Repas_Ingredients(Id_Repas integer not null, Id_Ingredients integer not null, foreign key (Id_Repas) references Repas(Id_Repas), foreign key (Id_Ingredients) references Ingredients(Id_Ingredients), primary key (Id_Repas, Id_Ingredients));

----
-- Data dump for Repas_Ingredients, a total of 18 rows
----
BEGIN TRANSACTION;
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('11','1');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('11','9');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('11','6');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('11','5');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('12','1');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('12','5');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('12','6');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('12','9');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('12','10');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('13','11');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('13','12');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','1');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','2');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','3');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','4');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','9');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','10');
INSERT INTO Repas_Ingredients (Id_Repas,Id_Ingredients) VALUES ('8','12');
COMMIT;

----
-- Structure for index sqlite_autoindex_Menu_Repas_1 on table Menu_Repas
----
;

----
-- Structure for index sqlite_autoindex_Repas_Ingredients_1 on table Repas_Ingredients
----
;
