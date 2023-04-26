


INSERT INTO customer (firstName, lastName, streetAddress, postalCode, city, email, phone)
VALUES  ('Anita', 'Andersson', 'Blomvägen 2', '80348', 'Bergby', 'anita.hemma@hotmail.com', '0762485251'),
        ('Anders', 'Lindgren', 'Sportvägen9', '31528', 'Målilla', 'a.lindgren@gmail.com', '074594549'),
        ('Sten', 'Frisk', 'Buvägen 2', '48257', 'Grönmåla', 'friskarestenar@outlook.se', '0754895251'),
        ('Ellen', 'Rosqvist','Smultronstigen 8', '65214', 'Lilldal', 'ellen.ros@gmail.com', '0741592828'),
        ('Patrik', 'Lugn', 'Sveavägen 99', '82221','Ockelbo','lugnochro@gmail.com', '0705645654');

INSERT INTO car (carSize, costPerDay, available )
VALUES ('small typ Fiat Punto', '479', true),
       ('medium typ VW Passat', '849', true),
       ('medium typ VW Passat', '859', true),
        ('large typ Volvo XC90', '1249', true),
        ('large typ Volvo XC90', '1329', true);

INSERT  INTO orders(id)
VALUES ( 1 ),
       ( 2 ),
       ( 3 );