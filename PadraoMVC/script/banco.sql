create database ams20241;

create table ams20241.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));

create table ams20241.gerente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  tipo VARCHAR(255),
  status VARCHAR(255),
  ip VARCHAR(255),
  primary key (id));

create table ams20241.usuarios_gerente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idU BIGINT NOT NULL,
  idG BIGINT NOT NULL,
  obs VARCHAR(255),
  primary key (id));

ALTER TABLE ams20241.usuarios_gerente ADD CONSTRAINT fk_ussi FOREIGN KEY (idU) REFERENCES ams20241.usuarios(id);
ALTER TABLE ams20241.usuarios_gerente ADD CONSTRAINT fk_gere FOREIGN KEY (idG) REFERENCES ams20241.gerente(id);

INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('DAYANE', '060605', 'ATIVO', 'ADM');
INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('MOREIRA', 'DSM05', 'ATIVO', 'VISITANTE');

