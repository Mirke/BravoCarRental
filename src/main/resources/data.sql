INSERT INTO customer (firstName, lastName, streetAddress, postalCode, city, email, phone)
VALUES ('Anita', 'Andersson', 'Blomvägen 2', '80348', 'Bergby', 'anita.hemma@hotmail.com', '0762485251'),
       ('Anders', 'Lindgren', 'Sportvägen9', '31528', 'Målilla', 'a.lindgren@gmail.com', '074594549'),
       ('Sten', 'Frisk', 'Buvägen 2', '48257', 'Grönmåla', 'friskarestenar@outlook.se', '0754895251'),
       ('Ellen', 'Rosqvist', 'Smultronstigen 8', '65214', 'Lilldal', 'ellen.ros@gmail.com', '0741592828'),
       ('Patrik', 'Lugn', 'Sveavägen 99', '82221', 'Ockelbo', 'lugnochro@gmail.com', '0705645654');

INSERT INTO car (factory, model, costPerDay, registrationNumber, available)
VALUES ('Fiat', 'Punto', '479', 'AAA111', false),
       ('VW', 'Passat', '849', 'BBB222', false),
       ('VW', 'Passat', '859', 'CCC333', false),
       ('Volvo', 'XC90', '1249', 'DDD444', true),
       ('Volvo', 'XC90', '1329', 'EEE555', true);

INSERT INTO orders(id, orderDate, bookedFrom, returnDate, CarId, CustomerId)
VALUES (1, '1988-09-09', '1988-09-10', '1988-10-10', 1, 1),
       (2, '1989-09-09', '1989-09-10', '1989-10-10', 2, 2),
       (3, '1990-09-09', '1990-09-10', '1990-10-10', 3, 3);