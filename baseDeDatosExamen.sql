CREATE DATABASE examendesarrollo
USE examendesarrollo

CREATE TABLE profesor (
	idProfesor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rfc VARCHAR(13) NOT NULL UNIQUE
)

CREATE TABLE unidadAprendizaje (
	idUnidadAprendizaje INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    horasClase INT NOT NULL,
    horasTaller INT NOT NULL,
    horasLab INT NOT NULL
)

CREATE TABLE registroProfesor (
	idProfesor INT NOT NULL,
    idUnidadAprendizaje INT NOT NULL,
    PRIMARY KEY (idProfesor, idUnidadAprendizaje),
    FOREIGN KEY (idProfesor) REFERENCES profesor(idProfesor),
    FOREIGN KEY (idUnidadAprendizaje) REFERENCES UnidadAprendizaje(idUnidadAprendizaje)    
)

CREATE TABLE users (
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
	nombre_usuario VARCHAR(20) NOT NULL,
    correo VARCHAR(40) NOT NULL,
    contrasena VARCHAR(25) NOT NULL,
    rol VARCHAR(6) NOT NULL CHECK (rol IN ('admin', 'prof'))
)

insert into users values (0,'admin','jose.fong@uabc.edu.mx','admin','admin'); 
insert into users values (0,'admin','manuel.lopez@gmail.com','admin','admin');
insert into profesor values (0,'Brenda','Flores','1234567890123');
insert into profesor values (0,'Angélica','Astorga','2345678912345');
insert into profesor values (0,'Alfredo','Abad','1234567890124');
insert into unidadAprendizaje values (0,'Reingeniería',2,2,2);
insert into unidadAprendizaje values (0,'Optimización',3,3,3);
insert into unidadAprendizaje values (0,'Programación',4,4,4);
insert into registroProfesor values (1,1);
insert into registroProfesor values (2,3);
insert into registroProfesor values (3,4);

select * from profesor;
select * from unidadaprendizaje;
select * from registroprofesor;

select a.nombre, c.nombre
from profesor as a
join registroprofesor as b
on a.idProfesor = b.idProfesor
join unidadaprendizaje as c
on c.idUnidadAprendizaje = b.idUnidadAprendizaje