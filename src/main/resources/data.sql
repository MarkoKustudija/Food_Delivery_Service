INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','USER');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','USER');
              
INSERT INTO deliverer(id, personalnumber, idnumber, namesurname) VALUES (1, '220022', '334455', 'AA');
INSERT INTO deliverer(id, personalnumber, idnumber, namesurname) VALUES (2, '330022', '324655', 'BB');
INSERT INTO deliverer(id, personalnumber, idnumber, namesurname) VALUES (3, '440022', '334775', 'CC');
INSERT INTO deliverer(id, personalnumber, idnumber, namesurname) VALUES (4, '550022', '334409', 'DD');
INSERT INTO deliverer(id, personalnumber, idnumber, namesurname) VALUES (5,'660022', '3007461', 'EE');

INSERT INTO bill (id, billnumber, `date`, price) VALUES (1, 001, '2020:10:15 18:45', 455);
INSERT INTO bill (id, billnumber, `date`, price) VALUES (2, 002, '2020:10:15 18:47', 475);
INSERT INTO bill (id, billnumber, `date`, price) VALUES (3, 003, '2020:10:15 18:49', 395);
INSERT INTO bill (id, billnumber, `date`, price) VALUES (4, 004, '2020:10:15 18:51', 755);
INSERT INTO bill (id, billnumber, `date`, price) VALUES (5, 005, '2020:10:15 18:55', 655);


INSERT INTO `order` (id, ordernumber, orderdate, address, price, description, deliverer_id, bill_id) 
VALUES(1,10, '2020:10:15 18:45', 'A street', 455, 'pizza', 1, 1 );
INSERT INTO `order` (id,ordernumber, orderdate, address, price, description, deliverer_id, bill_id) 
VALUES(2,20, '2020:10:15 18:49', 'B street', 475, 'burger', 2, 2 );
INSERT INTO `order` (id,ordernumber, orderdate, address, price, description, deliverer_id, bill_id) 
VALUES(3,30, '2020:10:15 18:52', 'C street', 395, 'pasta', 3, 3 );
INSERT INTO `order` (id,ordernumber, orderdate, address, price, description, deliverer_id, bill_id) 
VALUES(4,40, '2020:10:15 19:45', 'D street', 755, 'fish and cheeps', 4, 4 );
INSERT INTO `order` (id,ordernumber, orderdate, address, price, description, deliverer_id, bill_id) 
VALUES(5,50, '2020:10:15 20:45', 'E street', 655, 'lava cake', 5, 5 ); 



