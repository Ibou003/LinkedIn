CREATE TABLE "users"(
 "id" serial NOT NULL,
 "name" Character varying(28) NOT NULL,
 "first_name" Character varying(28) NOT NULL,
 "email" Character varying(28) NOT NULL,
 "mobile" Character varying(10) NOT NULL,
 "phone" Character varying(10) NOT NULL,

 -- table jointure user amis user
 
 "adress_id" integer NOT NULL,
 "password" Character varying(28) NOT NULL,
 "photo" Smallint NOT NULL,
 "description" Character varying(256),
 "cv_id"  int,
 "comment" Character varying(256)
);

CREATE TABLE "adress"(
 id Serial NOT NULL,
 number int NOT NULL,
 name Character varying(256) NOT NULL,
 zip_code Integer NOT NULL,
 city Character varying(256) NOT NULL
);

CREATE TABLE "company"(
  id serial NOT NULL,
  name character varying(128) NOT NULL,
  mail character varying(128),
  phone character varying(64),
  mobile character varying(64),
  adress_id integer NOT NULL,
  password Character varying(28) NOT NULL,
  --photo
  description Character varying(256),
  siren character varying(14),
  naf character varying(50),
  
  create_date timestamp without time zone NOT NULL,
  write_date timestamp without time zone NOT NULL,
  create_uid integer NOT NULL,
  write_uid integer NOT NULL
 
);


CREATE TABLE "comment"(
  id serial NOT NULL,
  create_uid integer NOT NULL,
  create_date timestamp without time zone NOT NULL,
  
  description Character varying(256),
  -- table joiture entre like_user comment
);

CREATE TABLE "message"(
  id serial NOT NULL,
  create_uid integer NOT NULL,
  create_date timestamp without time zone NOT NULL,
  message_type_id integer NOT NULL,
  "to" integer NOT NULL,
  description Character varying(256),
  comment_id integer
  -- table joiture entre like_user comment
);

CREATE TABLE  message_type(
  id serial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256)
);


CREATE TABLE  message_type(
  id serial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256)
);


CREATE TABLE  offer(
  id serial NOT NULL,
  create_date timestamp without time zone NOT NULL,
  available Boolean,
  -- table jointure entre offre et user
  fin_date timestamp without time zone NOT NULL,
  number_view integer,
  company_id integer not null,
  title Character varying(128) NOT NULL,
 "description" Character varying(256)
);

CREATE TABLE image
(
  id integer NOT NULL,
  name character varying(255),
  image bytea,
)


