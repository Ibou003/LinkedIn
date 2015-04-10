/*
select * from users;
select * from state;



--delete 

delete from state ;
delete from users;

*/

--state

insert into state(id,name, description)
values
(1, 'en recherche', 'en phase de recherche de travail'),
(2, 'chomage', ''),
(3, 'salarie', 'il travaille');

--country
insert into country(name)
values
('French');

-- users
insert into users ( last_name, first_name, phone, mobile, description, email, password,country_id, state_id, number, street_name, city, zip_code)
values
( 'nasser', 'ashraf', '0640354565', '0123456789', 'description','ashrad@gmail.com', 'password', 1,1, 22, 'street', 'Paris', 75015);






