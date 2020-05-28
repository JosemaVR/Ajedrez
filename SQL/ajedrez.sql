CREATE USER IF NOT EXISTS 'ajedrez'@'%' IDENTIFIED BY 'Ajedrez2020;';

CREATE DATABASE IF NOT EXISTS ajedrez CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci;

GRANT ALL PRIVILEGES ON ajedrez.* TO 'ajedrez'@'%';

USE ajedrez;

DROP TABLE IF EXISTS partidas;
DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (idUsuario int not null auto_increment, nombreUsuario VARCHAR(50), primary key (idUsuario));

CREATE TABLE partidas (idPartida int not null auto_increment, idGanadorFK int, idPerdedorFK int, tablas boolean, 
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

INSERT INTO usuarios (nombreUsuario) values ("Pepe");
INSERT INTO usuarios (nombreUsuario) values ("Paco");

INSERT INTO partidas (idGanadorFK, idPerdedorFK, tablas) values (2, 1, false);
INSERT INTO partidas (idGanadorFK, idPerdedorFK, tablas) values (1, 2, true);
SELECT * FROM usuarios, partidas WHERE idUsuario = idGanadorFK;

INSERT INTO partidas (idGanadorFK, idPerdedorFK, tablas) values (1, 1, true);

