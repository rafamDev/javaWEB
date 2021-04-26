CREATE TABLE product(
    id INTEGER(5) NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL, 
    description VARCHAR(45) NOT NULL,
    price LONG NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO product(name,description,price) VALUES("PS5","rafamayo@gmail.com",650.35);