CREATE DATABASE xunta_ayudas

CREATE TABLE ayuda(
id INTEGER(11) NOT NULL AUTO_INCREMENT,
tipo VARCHAR(25) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE unidadDeConvivencia(
id INTEGER(11) NOT NULL AUTO_INCREMENT,
dni_conyuge VARCHAR(9) NOT NULL,
nombre_conyuge VARCHAR(9) NOT NULL,
apellido_conyuge VARCHAR(9) NOT NULL,
numero_hijos INTEGER(20) NOT NULL, 
PRIMARY KEY (id));

CREATE TABLE ayuda_unidadFamiliar(
id_ayuda INTEGER(3) NOT NULL,
id_unidadFamiliar INTEGER(3) NOT NULL,
PRIMARY KEY (id_ayuda,id_unidadFamiliar),
FOREIGN KEY (id_ayuda) REFERENCES ayuda (id),
FOREIGN KEY (id_unidadFamiliar) REFERENCES unidadDeConvivencia (id));

