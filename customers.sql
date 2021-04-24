CREATE TABLE customer(
    id INTEGER(5) NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL, 
    email VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO customer(name,email,address) VALUES("Rafa","rafamayo@gmail.com","Sada");