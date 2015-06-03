-- Establishment

select * from establishment;

insert into establishment (name, description, number, street_name, city, zip_code)
values
('Université Pierre et Marie Curie', 'Université Paris 6', 6, '4 place jussieu', 'Paris', '75006'),
('Université Paris Diderot', 'Université Paris 7', 6, '5 rue Thomas-Mann', 'Paris', '75205'),
('Université Paris Descartes', 'Université Paris 5', 6, '12, rue de l’École de Médecine', 'Paris', '75270'),
('Facebook', 'Facebook Social Network', 12, 'rue de la societe 1', 'Paris', '75001'),
('Apple', 'Apple Inc', 12, 'rue de la societe 2', 'Paris', '75002'),
('Microsoft', 'Microsoft Software', 12, 'rue de la societe 3', 'Paris', '75003');


-- Country

select * from country;

insert into country(name)
values
('France'),
('Allemagne'),
('Angleterre'),
('Russie'),
('Pologne'),
('Corse'),
('Suisse'),
('Chine'),
('Japon'),
('Corée'),
('Canada'),
('Californie'),
('Las Vegas'),
('Los Angeles');


-- User

select * from users;

insert into users (last_name, first_name, phone, mobile, description, email, password, country_id, number, street_name, city, zip_code,state_user)
values
('Pol','Patrick','0123456789','0123456789','Team Linkedin','pol.patrick1411@gmail.com','linkedin',1,6,'quartier chinois','Paris','75001','EN_RECHERCHE'),
('Ghansum','Nourdine','0123456789','0123456789','Team Linkedin','ghansumn@gmail.com','linkedin',1,6,'Quartier noir','Nanterre','92000','EN_RECHERCHE'),
('Negrocastro','Lucas','0123456789','0123456789','Team Linkedin','lucasnegrocastro@gmail.com','linkedin',1,6,'Quartier espagnol','Paris','75003','EN_RECHERCHE'),
('Ibouroihim','Loutfi','0123456789','0123456789','Team Linkedin','loutfi003@gmail.com','linkedin',1,6,'Chatelet','Paris','75001','EN_RECHERCHE'),
('Nasser','Ashraf','0123456789','0123456789','Team Linkedin','ashraf.nasser1991@gmail.com','linkedin',1,6,'Sevran','Sevran','93000','EN_RECHERCHE'),
('Kornilov','Grigory','0123456789','0123456789','Team Linkedin','gr.kornilov@gmail.com','linkedin',1,6,'Viva La Russie','Paris','75006','EN_RECHERCHE'),
('Sivanathan','Sinthu','0123456789','0123456789','Team Deezer','shinthujan.sivanathan@gmail.com','linkedin',1,6,'Quartien indou','Paris','75011','EN_RECHERCHE'),
('Amri','Zakaria','0123456789','0123456789','Team Deezer','zak.amri@gmail.com','linkedin',1,6,'Montparnasse','Paris','75012','EN_RECHERCHE'),
('Danglet','Eric','0123456789','0123456789','Team Deezer','dangleteric@gmail.com','linkedin',1,6,'QuelquePart','Paris','75007','AU_TRAVAIL'),
('Margarido','Julien','0123456789','0123456789','Team Deezer','julienMargarido@gmail.com','linkedin',1,6,'QuelquePart','Paris','75008','AU_TRAVAIL'),
('ElMeskini','Naoufal','0123456789','0123456789','Team Deezer','elmeskininaoufal@gmail.com','linkedin',1,6,'QuelquePart','Paris','75009','AU_CHOMAGE'),
('Laduranti','Sandra','0123456789','0123456789','Team Youtube','sandraladu@gmail.com','linkedin',1,6,'QuelquePart','Paris','75001','EN_RECHERCHE'),
('Donny','Leo','0123456789','0123456789','Team Youtube','donnyleo@gmail.com','linkedin',1,6,'QuelquePart','Paris','75001','EN_RECHERCHE'),
('Serin','Damien','0123456789','0123456789','Team Youtube','damienserin@gmail.com','linkedin',1,6,'QuelquePart','Paris','75002','AU_TRAVAIL'),
('Goualard','Mickael','0123456789','0123456789','Team Youtube','goualardMika@gmail.com','linkedin',1,6,'QuelquePart','Paris','75003','AU_TRAVAIL'),
('Lecoq','Guillaume','0123456789','0123456789','Team Youtube','lecoqguigui@gmail.com','linkedin',1,6,'QuelquePart','Paris','75010','AU_CHOMAGE'),
('PiardRousseau','Idriss','0123456789','0123456789','Team Youtube','idriss@gmail.com','linkedin',1,6,'QuelquePart','Paris','75014','AU_CHOMAGE'),
('Petit','Clement','0123456789','0123456789','Team Twitter','petitClement@gmail.com','linkedin',1,6,'QuelquePart','Paris','75004','AU_TRAVAIL'),
('Tsekov','Sasha','0123456789','0123456789','Team Deezer','sashatsekov@gmail.com','linkedin',1,6,'QuelquePart','Paris','75005','AU_TRAVAIL'),
('Katri','Mohamed','0123456789','0123456789','Team Twitter','katriMomo@gmail.com','linkedin',1,6,'QuelquePart','Paris','75006','AU_TRAVAIL'),
('Poulet','Citron','0123456789','0123456789','Team Twitter','pouletcitron@gmail.com','linkedin',1,6,'QuelquePart','Paris','75011','AU_CHOMAGE'),
('Jesaisplus','Ahmad','0123456789','0123456789','Team Twitter','ahmad@gmail.com','linkedin',1,6,'QuelquePart','Paris','75012','AU_CHOMAGE'),
('Jesaispas','Rubina','0123456789','0123456789','Team Twitter','rubina@gmail.com','linkedin',1,6,'QuelquePart','Paris','75013','AU_CHOMAGE'),
('PITTON','Olivier','0123456789','0123456789','Prof','olivier.pitton@gmail.com','linkedin',1,6,'Quartier pauvre','Paris','75018','AU_CHOMAGE'),
('Jobs','Steve','0123456789','0123456789','Apple','stevejobs@gmail.com','linkedin',12,6,'Quartier Bourge','Paris','75006','AU_TRAVAIL'),
('Zuckerberg','Mark','0123456789','0123456789','Facebook','zuckerbergmark@gmail.com','linkedin',12,6,'Quartier Bourge','Paris','75016','AU_TRAVAIL'),
('Gates','Bill','0123456789','0123456789','Microsoft','gatesbill@gmail.com','linkedin',12,6,'Quartier Bourge','Paris','75005','AU_TRAVAIL');




-- Experience

select * from experience;

insert into experience(title, date_start, date_end, description, user_id, establishment_id, current)
values
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 1, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 2, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 3, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 4, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 5, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 6, 5, 'true'),
('Apprenti développeur mobile chez facebook', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 7, 4, 'true'),
('Apprenti développeur mobile chez facebook', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 8, 4, 'true'),
('Apprenti développeur mobile chez facebook', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 9, 4, 'true'),
('Apprenti développeur mobile chez facebook', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 10,4, 'true'),
('Apprenti développeur mobile chez facebook', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 11,4, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 12, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 13, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 14, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 15, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 16, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 17, 6, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 18, 5, 'true'),
('Apprenti développeur logiciel chez Apple', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Developpement de nouveaux modules et de fonctionnalités pour Apple', 19, 5, 'true'),
('Apprenti développeur mobile chez facebook', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 20, 4, 'true'),
('Apprenti développeur mobile chez facebook', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles fonctionnalités pour Facebook', 21, 4, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 22, 6, 'true'),
('Apprenti developpeur web chez Microsoft', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpement de nouvelles page web pour Microsoft', 23, 6, 'true'),
('Developpeur chez Apple', '2010-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Developpeur junior , mise en place de nouveaux modules et tests', 24, 5, 'true'),
('PDG Apple', '1976-04-01 00:00:00', '2011-10-05 00:00:00', 'Fondateur Apple', 25, 5, 'false'),
('PDG Facebook', '2010-01-01 00:00:00.0', '2015-06-04 00:00:00.0', 'Fondateur de Facebook', 26, 4, 'true'),
('PDG Microsoft', '2000-01-01 00:00:00.0', '2015-06-04 00:00:00.0', 'Fondateur de Microsoft', 27, 6, 'true');

-- Training

select * from training;

insert into training (name, date_start, date_end, degree, discipline, description, user_id, establishment_id)
values
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 1, 1),
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 2, 1),
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 3, 1),
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 4, 1),
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 5, 1),
('Développement de logiciel et architecture logiciel', '2014-05-30 00:00:00.0', '2015-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 6, 1),
('Developpement mobile et etude du marché mobile', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 7, 2),
('Developpement mobile et etude du marché mobile', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 8, 2),
('Developpement mobile et etude du marché mobile', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 9, 2),
('Developpement mobile et etude du marché mobile', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 10, 2),
('Developpement mobile et etude du marché mobile', '2014-09-01 00:00:00.0', '2015-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 11, 2),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 12, 3),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 13, 3),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 14, 3),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 15, 3),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 16, 3),
('Developpment web et etude du marché web', '2014-10-01 00:00:00.0', '2015-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 17, 3),
('Développement de logiciel et architecture logiciel', '2010-05-30 00:00:00.0', '2011-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 18, 1),
('Développement de logiciel et architecture logiciel', '2009-05-30 00:00:00.0', '2010-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 19, 1),
('Developpement mobile et etude du marché mobile', '2009-09-01 00:00:00.0', '2010-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 20, 2),
('Developpement mobile et etude du marché mobile', '2005-09-01 00:00:00.0', '2006-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 21, 2),
('Developpment web et etude du marché web', '2008-10-01 00:00:00.0', '2009-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 22, 3),
('Developpment web et etude du marché web', '2002-10-01 00:00:00.0', '2003-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 23, 3),
('Développement de logiciel et architecture logiciel', '2000-05-30 00:00:00.0', '2001-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 24, 1),
('Développement de logiciel et architecture logiciel', '1990-05-30 00:00:00.0', '1991-05-30 00:00:00.0', 'Master 2', 'Informatique Logiciel', 'Developpement logiciel', 25, 1),
('Developpement mobile et etude du marché mobile', '1991-09-01 00:00:00.0', '1992-09-01 00:00:00.0', 'Master 1', 'Informatique Mobile', 'Developpement mobile', 26, 2),
('Developpment web et etude du marché web', '1994-10-01 00:00:00.0', '1995-10-01 00:00:00.0', 'Licence 3', 'Informatique Web e-business', 'Developpement web social', 27, 3);


-- Company

select * from company;

insert into company(name, naf, registeration_number, company_creation_date, phone, mobile, description, email, password, user_id, country_id, number, street_name, city, zip_code)
values
('Apple','1111','123456789','1976-04-01 00:00:00.0','0123456789','0623456789','Vente de téléphone, lecteur de musique, tablette etc','contact@apple.com','apple',25,12,6,'Applet Street','Cupertino','785478'),
('Facebook','2222','987654321','2010-01-01 00:00:00.0','0145826935','0625789541','Réseau social','contact@facebook.com','facebook',26,12,6,'Facebook Street','Cambridge','456132'),
('Microsoft','3333','159738264','2000-01-01 00:00:00.0','0123525658','0678855441','Vente de logiciel et de téléphone et tablette','contact@microsoft.com','microsoft',27,12,6,'Microsoft Street','Albuquerque','321545');

-- Domain

select * from domain ;

insert into domain (title, description, company_id)
values
('INFORMATIQUE ET ELECTRONIQUE', null, 1),
('RESEAU SOCIAL', null, 2),
('RESEAU SOCIAL', null, 2),
('EDITEUR DE LOGICIEL', null, 3);

--Document

select * from document ;

insert into document (name, path, company_id, user_id, document_type)
values
('document1', '\chemin1', 1, 25,'IMAGE'),
('document2', '\chemin2', 2, 26, 'PDF'),
('document3', '\chemin3', 3, 27, 'PHOTO_PROFIL'),
('document4', '\chemin4', null, null, 'IMAGE');

--Post

select * from post ;

insert into post (create_date, content, user_id, document_id)
values
(now(), 'Nouveau post par Apple', 25, 1),
(now(), 'Nouveau post par Facebook', 26, 2),
(now(), 'Nouveau post par Microsoft', 27, 3);

--Comment

select * from comment ;

insert into comment (create_date, content, post_id, user_id)
values
(now(), 'Steve a commente son propre post', 1, 25),
(now(), 'Mark a commente son propre post', 2, 26),
(now(), 'Bill a commente son propre post', 3, 27);

--offer

select * from offer ;

insert into offer (create_date, validate_date, end_date, nb_view, title, company_id, document_id)
values
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche d''un webmaster', 1, 4),
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche un développeur Ios', 1, 4),
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche developpeur HTML5/CSS3', 2, 4),
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche un comptable ', 2, 4),
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche un expert en tout ', 3, 4),
(now(), now(), '2015-12-12 00:00:00.0', 0, 'Recheche developpeur analyste ERP', 3, 4);



