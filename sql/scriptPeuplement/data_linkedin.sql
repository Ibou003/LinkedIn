

--Establishment
select * from establishment  ;

insert into establishment (name, description, number, street_name, city, zip_code)
values
('UPMC', 'test', 6, 'place jussieu', 'Paris', '75006'),
('Société Général', 'test', 6, 'place jussieu', 'Paris', '75006');



--Country
select * from country    ;

insert into country(name)
 values
('France');


--Users
select * from users ;

insert into users (last_name, first_name, phone, mobile, description, email, password, country_id, number, street_name, city, zip_code,state_user)
values
('linkedin', 'linkedin', '0640356474', '0640356483', 'systeme linkedin', 'dantlinkedin@gmail.com', 'password' , 1, 6, 'place jussieu', 'Paris', '75006','AU_TRAVAIL'),
('admin-linkedin', 'admin-linkedin', '0640356483', '0640356477', 'systeme linkedin', 'adminlinkedin@gmail.com', 'password' , 1, 6, 'place jussieu', 'Paris', '75006','AU_TRAVAIL'),
('test1', 'test1', '0640356474', '0640356483', 'test', 'test1@gmail.com', 'password' , 1, 6, 'place jussieu', 'Paris', '75006','EN_CHOMAGE'),
('test2', 'test', '0640356483', '0640356477', 'systeme linkedin', 'test2@gmail.com', 'password' , 1, 6, 'place jussieu', 'Paris', '75006','EN_RECHERCHE');


--Experience
select * from experience   ;

insert into experience (title, date_start, date_end, description, user_id, establishment_id, current)
values
('developpeur chez dant.linkedin',now(),now(), 'description', 3, 1, true);


--company
select * from company ;

--delete from company ;

insert into company (name, naf, registeration_number, company_creation_date, phone, mobile, description, email, password, user_id, country_id, number, street_name, city, zip_code)
values
('dantLinkedIn', '1234', '123456789', now(), '0123456789', '0640253467', 'Une entreprise dérigé par le groupe red ', 'linkedin@gmail.com', 'password', 1, 1, 6, 'place jussieu', 'Paris', '75006'),
('test1', '1234', '123456789', now(), '0123456789', '0640253467', 'quos trabeae description', 'test1@gmail.com', 'password', 1, 1, 6, 'place jussieu', 'Paris', '75006');


--Domain

select * from domain ;

insert into domain (title, description, company_id)
values
('SCIENCE ET TECHNOLOGIE', null, 2),
('INFORMATIQUE & TELECOMMUNICATION', null, 2);


--Document

--delete from document ;

select * from document ;

insert into document (name, path, company_id, user_id, document_type)
values
('document1', '\chemin1', 2, null,'IMAGE'),
('document2', '\chemin2', 2, null, 'PDF'),
('document3', '\chemin3', 2, null, 'PHOTO_PROFIL'),
('document4', '\chemin4', null, null, 'IMAGE');


--Comment

--delete from post ;

select * from post ;

insert into post (create_date, content, user_id, document_id)
values
(now(), 'ce ci est un un post', 3, 1),
(now(), 'ce ci est un un post', 3, 1),
(now(), 'ce ci est un un post', 3, 1);


--Comment

--delete from comment ;

select * from comment ;

insert into comment (create_date, content, post_id, user_id)
values
(now(), 'ce ci est un commentaire sur un post', 1, 3);


--offer

select * from offer ;

insert into offer (create_date, validate_date, end_date, nb_view, title, company_id, document_id)
values
(now(), now(), now(), 0, 'Recheche d''un webmaster', 2, 4),
(now(), now(), now(), 0, 'Recheche un développeur Ios', 2, 4),
(now(), now(), now(), 0, 'Recheche developpeur HTML5/CSS3', 2, 4),
(now(), now(), now(), 0, 'Recheche un comptable ', 2, 4),
(now(), now(), now(), 0, 'Recheche developpeur analyste ERP', 2, 4);


--message
--select * from message ;

--insert into message (create_date, subject, body, from_id,to_id, document_id, message_type)
--values
--(now(), 'subject', 'dant linkedin envois un message', 1, 2,null,  );




