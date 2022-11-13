-- ADMINISTRADORES --
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('admin1','admin','TRUE','Admin FN','Admin LN','admin1@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (1,'admin');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('albperleo','1234','TRUE','Alberto','Perea Leon','albperleo@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (2,'admin');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('javnunrui','dp1','TRUE','Javier','Nunes Ruiz','javnunrui@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (3,'admin');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('marvicmar','2121','TRUE','Maria','Vico Martin','marvicmar@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (4,'admin');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('juaramlop2','1234','TRUE','Juan Carlos','Ramirez Lopez','juaramlop2@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (5,'admin');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('alepervaz','1234','TRUE','Alejandro','Perez Vazquez','alepervaz@sevenislands.com','2022-10-29','admin','2022-10-29','adminAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (6,'admin');

-- JUGADORES --
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('player1','player','TRUE','Player FN','Player LN','player1@sevenislands.com','2022-10-29','player','2022-10-29','playerAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (7,'player');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('player2','player','TRUE','Player FN','Player LN','player2@sevenislands.com','2022-10-29','player','2022-10-29','playerAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (8,'player');
INSERT INTO users(nickname,password,enabled,first_name,last_name,email,creation_date,type,birth_date,avatar) VALUES ('player3','player','TRUE','Player FN','Player LN','player3@sevenislands.com','2022-10-29','player','2022-10-29','playerAvatar.png');
INSERT INTO authorities(user_id,authority) VALUES (9,'player');

-- LOBBY --
--INSERT INTO lobby(code,active) VALUES('00000000','TRUE');

--INSERT INTO lobby_players(lobby_id,players_id) VALUES (1,8);

-- MATERIALES --
INSERT INTO cards(id,name,multiplicity) VALUES (1,'barril',6);
INSERT INTO cards(id,name,multiplicity) VALUES (2,'mapa_tesoro',4);
INSERT INTO cards(id,name,multiplicity) VALUES (3,'collar',4);
INSERT INTO cards(id,name,multiplicity) VALUES (4,'caliz',3);
INSERT INTO cards(id,name,multiplicity) VALUES (5,'corona',4);
INSERT INTO cards(id,name,multiplicity) VALUES (6,'diamante',3);
INSERT INTO cards(id,name,multiplicity) VALUES (7,'doblon',27);
INSERT INTO cards(id,name,multiplicity) VALUES (8,'revolver',6);
INSERT INTO cards(id,name,multiplicity) VALUES (9,'rubi',3);
INSERT INTO cards(id,name,multiplicity) VALUES (10,'espada',6);
INSERT INTO cards(id,name,multiplicity) VALUES (11,'baraja',1);

-- CREACIÓN DE UNA PARTIDA --

