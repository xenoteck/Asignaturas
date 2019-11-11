CREATE DATABASE GAMELAND;

USE GAMELAND;


CREATE TABLE PLATAFORMA(
ID INT(11) NOT NULL auto_increment,
NOMBRE varchar(100) NOT NULL,

primary key (ID)

);

CREATE TABLE GENERO(
ID INT(11) NOT NULL auto_increment,
NOMBRE varchar(100) NOT NULL,

primary key (ID)


);

CREATE TABLE JUEGO(
ID INT(11) NOT NULL auto_increment,
TITULO varchar(100) NOT NULL,
ANYO INT NOT NULL,
FOTO VARCHAR(255),
DESCRIPCION VARCHAR(255),
IDGENERO INT(11) NOT NULL,
IDPLATAFORMA INT(11) NOT NULL,

primary key(ID),
foreign key(IDGENERO) references GENERO(ID),
foreign key(IDPLATAFORMA) references PLATAFORMA(ID)

);

CREATE TABLE USUARIO(
ID INT(11) NOT NULL auto_increment,
NOMBRE VARCHAR(100) NOT NULL,
USUARIO VARCHAR(100) NOT NULL,
PASS VARCHAR(100) NOT NULL,
FOTO VARCHAR(100) NOT NULL,
ADMINISTRADOR INT(1) NOT NULL,

primary key(ID)


);

CREATE TABLE VALORACION(
ID INT(11) NOT NULL auto_increment,
IDJUEGO INT(11) NOT NULL,
IDUSUARIO INT(11) NOT NULL,
VALORACION INT(11) NOT NULL,

primary key(ID),

FOREIGN KEY (IDJUEGO) references JUEGO(ID),
FOREIGN KEY (IDUSUARIO) references USUARIO(ID)
);

