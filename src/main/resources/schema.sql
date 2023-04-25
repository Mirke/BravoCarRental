DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(90) NOT NULL,
    lastName VARCHAR(90) NOT NULL,
    streetAddress VARCHAR(90) NOT NULL,
    postalCode VARCHAR(90) NOT NULL ,
    city VARCHAR(90) NOT NULL ,
    email VARCHAR(90) NOT NULL ,
    phone VARCHAR(90) NOT NULL
);

CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    carSize VARCHAR(90),
    costPerDay VARCHAR(90),
    available BOOL
);