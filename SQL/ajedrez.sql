CREATE USER IF NOT EXISTS 'ajedrez'@'%' IDENTIFIED BY 'Ajedrez2020;';

CREATE DATABASE IF NOT EXISTS ajedrez CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci;

GRANT ALL PRIVILEGES ON ajedrez.* TO 'ajedrez'@'%';

FLUSH PRIVILEGES;

USE ajedrez;

DROP TABLE IF EXISTS partidas;
DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (idUsuario int not null auto_increment, nombreUsuario VARCHAR(50), victorias int default 0, 
tablas int default 0, derrotas int default 0, primary key (idUsuario));

CREATE TABLE partidas (idPartida int not null auto_increment, idGanadorFK int, idPerdedorFK int, esTablas boolean, 
primary key (idPartida), foreign key (idGanadorFK) references usuarios (idUsuario), foreign key (idPerdedorFK) 
references usuarios (idUsuario));

DROP TRIGGER IF EXISTS jugadoresPartida;
DELIMITER $$
CREATE TRIGGER jugadoresPartida BEFORE INSERT 
    ON partidas
    FOR EACH ROW BEGIN 
		IF (NEW.idGanadorFK = NEW.idPerdedorFK) 
        THEN 
			signal sqlstate '45000' set message_text = 'Hay que elegir distintos jugadores.';
        END IF;
    END;$$
DELIMITER ;

DROP TRIGGER IF EXISTS jugadoresExistentes;
DELIMITER $$
CREATE TRIGGER jugadoresExistentes BEFORE INSERT 
    ON usuarios
    FOR EACH ROW BEGIN 
		IF (SELECT COUNT(*) FROM USUARIOS WHERE NEW.nombreUsuario = nombreUsuario > 0) 
        THEN 
			signal sqlstate '45000' set message_text = 'Ya existe un jugador con ese nombre.';
        END IF;
    END;$$
DELIMITER ;

DROP TRIGGER IF EXISTS clasificacionPartida;
DELIMITER $$
CREATE TRIGGER clasificacionPartida AFTER INSERT 
    ON partidas
    FOR EACH ROW BEGIN 
        IF (NEW.esTablas = 0) THEN
			UPDATE usuarios SET victorias = (1+(SELECT victorias WHERE NEW.idGanadorFK = idUsuario)) 
				WHERE NEW.idGanadorFK = idUsuario;
			UPDATE usuarios SET derrotas = (1+(SELECT derrotas WHERE NEW.idPerdedorFK = idUsuario)) 
				WHERE NEW.idPerdedorFK = idUsuario;
        END IF;
        IF (NEW.esTablas = 1) THEN
			UPDATE usuarios SET tablas = (1+(SELECT tablas WHERE NEW.idGanadorFK = idUsuario)) 
				WHERE NEW.idGanadorFK = idUsuario;
			UPDATE usuarios SET tablas = (1+(SELECT tablas WHERE NEW.idPerdedorFK = idUsuario)) 
				WHERE NEW.idPerdedorFK = idUsuario;
        END IF; 
    END;$$
DELIMITER ;

INSERT INTO usuarios (nombreUsuario) VALUES ("Pepe");
INSERT INTO usuarios (nombreUsuario) VALUES ("Paco");
INSERT INTO USUARIOS (nombreUsuario) VALUES ("Pedro");

INSERT INTO PARTIDAS (idGanadorFK, idPerdedorFK, esTablas) VALUES (3, 2, false);
INSERT INTO partidas (idGanadorFK, idPerdedorFK, esTablas) VALUES (2, 1, false);
INSERT INTO partidas (idGanadorFK, idPerdedorFK, esTablas) VALUES (1, 2, true);

SELECT * FROM usuarios, partidas WHERE idUsuario = idGanadorFK 
ORDER BY usuarios.victorias DESC, usuarios.tablas DESC, usuarios.nombreUsuario ASC;

INSERT INTO usuarios (nombreUsuario) VALUES ("Pepe");
INSERT INTO partidas (idGanadorFK, idPerdedorFK, esTablas) VALUES (1, 1, true);

