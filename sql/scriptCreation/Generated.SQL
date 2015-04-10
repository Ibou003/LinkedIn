/*
Created: 06/03/2015
Modified: 02/04/2015
Project: dant
Model: Linkedin
Company: naaf.com
Author: naaf
Version: 1.0
Database: PostgreSQL 9.2
*/


-- Create tables section -------------------------------------------------

-- Table message_state

CREATE TABLE "message_state"(
 "id" Smallint NOT NULL,
 "create_date" Timestamp NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256)
)
WITH (OIDS=FALSE)
;

-- Add keys for table message_state

ALTER TABLE "message_state" ADD CONSTRAINT "message_state_pkey" PRIMARY KEY ("id")
;

-- Table document_type

CREATE TABLE "document_type"(
 "id" Smallint NOT NULL,
 "create_date" Timestamp NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256)
)
WITH (OIDS=FALSE)
;

-- Add keys for table document_type

ALTER TABLE "document_type" ADD CONSTRAINT "document_type_pkey" PRIMARY KEY ("id")
;

-- Table message

CREATE TABLE "message"(
 "id" Serial NOT NULL,
 "create_date" Timestamp NOT NULL,
 "create_uid" Integer NOT NULL,
 "subject" Character varying(256) NOT NULL,
 "body" Text NOT NULL,
 "state_date" Timestamp NOT NULL,
 "response_code" Character varying(16),
 "response_message" Character varying(256),
 "from_id" Integer,
 "to_id" Integer,
 "state_id" Smallint,
 "document_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table message

CREATE INDEX "IX_Relationship12" ON "message" ("from_id")
;

CREATE INDEX "IX_Relationship13" ON "message" ("to_id")
;

CREATE INDEX "IX_Relationship14" ON "message" ("state_id")
;

CREATE INDEX "IX_Relationship15" ON "message" ("document_id")
;

-- Add keys for table message

ALTER TABLE "message" ADD CONSTRAINT "message_pkey" PRIMARY KEY ("id")
;

-- Table document

CREATE TABLE "document"(
 "id" Serial NOT NULL,
 "create_date" Timestamp NOT NULL,
 "write_date" Timestamp NOT NULL,
 "name" Character varying(128) NOT NULL,
 "type_id" Smallint NOT NULL,
 "is_verified" Boolean DEFAULT false NOT NULL,
 "path" Character varying(256) NOT NULL,
 "company_id" Integer,
 "document_type_id" Smallint
)
WITH (OIDS=FALSE)
;

-- Create indexes for table document

CREATE INDEX "IX_document_company_fkey" ON "document" ("company_id")
;

CREATE INDEX "IX_document_document_type_fkey" ON "document" ("document_type_id")
;

-- Add keys for table document

ALTER TABLE "document" ADD CONSTRAINT "document_pkey" PRIMARY KEY ("id")
;

-- Table users

CREATE TABLE "users"(
 "id" Serial NOT NULL,
 "last_name" Character varying(128) NOT NULL,
 "first_name" Character varying(128) NOT NULL,
 "phone" Character varying(64),
 "mobile" Character varying(64),
 "description" Text,
 "email" Character varying(128) NOT NULL,
 "password" Character varying(128) NOT NULL,
 "country_id" Smallint,
 "state_id" Smallint,
 "number" Integer,
 "street_name" Character varying(256),
 "city" Character varying(256),
 "zip_code" Character varying(128)
)
WITH (OIDS=FALSE)
;

-- Create indexes for table users

CREATE INDEX "IX_user_country" ON "users" ("country_id")
;

CREATE INDEX "IX_user_state" ON "users" ("state_id")
;

-- Add keys for table users

ALTER TABLE "users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id")
;

ALTER TABLE "users" ADD CONSTRAINT "login_users" UNIQUE ("email")
;

-- Table company

CREATE TABLE "company"(
 "id" Serial NOT NULL,
 "creation_date" Time with time zone NOT NULL,
 "update_date" Time with time zone NOT NULL,
 "name" Character varying(256) NOT NULL,
 "naf" Character varying(50) NOT NULL,
 "registeration_number" Character varying(50) NOT NULL,
 "company_creation_date" Timestamp with time zone NOT NULL,
 "phone" Character varying(20),
 "mobile" Character varying(20),
 "description" Text,
 "email" Character varying(128) NOT NULL,
 "password" Character varying(128),
 "user_id" Integer,
 "country_id" Smallint,
 "number" Integer,
 "street_name" Character varying(256),
 "city" Character varying(256),
 "zip_code" Character varying(128)
)
WITH (OIDS=FALSE)
;

-- Create indexes for table company

CREATE INDEX "IX_company_user" ON "company" ("user_id")
;

CREATE INDEX "IX_company_country_fkey" ON "company" ("country_id")
;

-- Add keys for table company

ALTER TABLE "company" ADD CONSTRAINT "company_pkey" PRIMARY KEY ("id")
;

ALTER TABLE "company" ADD CONSTRAINT "login_company" UNIQUE ("email")
;

-- Table offer

CREATE TABLE "offer"(
 "id" Serial NOT NULL,
 "create_date" Time with time zone NOT NULL,
 "validate_date" Time with time zone NOT NULL,
 "end_date" Time with time zone NOT NULL,
 "nb_view" Integer,
 "title" Character varying(256) NOT NULL,
 "company_id" Integer,
 "document_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table offer

CREATE INDEX "IX_offer_company" ON "offer" ("company_id")
;

CREATE INDEX "IX_offer_document" ON "offer" ("document_id")
;

-- Add keys for table offer

ALTER TABLE "offer" ADD CONSTRAINT "offer_pkey" PRIMARY KEY ("id")
;

-- Table comment

CREATE TABLE "comment"(
 "id" Serial NOT NULL,
 "create_date" Time with time zone NOT NULL,
 "content" Text NOT NULL,
 "post_id" Integer,
 "id_user" Integer NOT NULL,
 "offer_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table comment

CREATE INDEX "IX_comment_post" ON "comment" ("post_id")
;

CREATE INDEX "IX_comment_user" ON "comment" ("id_user")
;

CREATE INDEX "IX_comment_offer" ON "comment" ("offer_id")
;

-- Add keys for table comment

ALTER TABLE "comment" ADD CONSTRAINT "id" PRIMARY KEY ("id")
;

-- Table country

CREATE TABLE "country"(
 "id" Smallserial NOT NULL,
 "name" Character varying(256) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table country

ALTER TABLE "country" ADD CONSTRAINT "country_pkey" PRIMARY KEY ("id")
;

-- Table state

CREATE TABLE "state"(
 "id" Smallserial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256)
)
WITH (OIDS=FALSE)
;

-- Add keys for table state

ALTER TABLE "state" ADD CONSTRAINT "state_pkey" PRIMARY KEY ("id")
;

-- Table type_domain

CREATE TABLE "type_domain"(
 "id" Serial NOT NULL,
 "title" Character varying(256) NOT NULL,
 "description" Character varying(256),
 "company_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table type_domain

CREATE INDEX "IX_domain_company_fkey" ON "type_domain" ("company_id")
;

-- Add keys for table type_domain

ALTER TABLE "type_domain" ADD CONSTRAINT "type_domain_pkey" PRIMARY KEY ("id")
;

-- Table type_profession

CREATE TABLE "type_profession"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "description" Character varying(256)
)
WITH (OIDS=FALSE)
;

-- Add keys for table type_profession

ALTER TABLE "type_profession" ADD CONSTRAINT "type_profession_pkey" PRIMARY KEY ("id")
;

-- Table type_establishment

CREATE TABLE "type_establishment"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "description" Character varying(256)
)
WITH (OIDS=FALSE)
;

-- Add keys for table type_establishment

ALTER TABLE "type_establishment" ADD CONSTRAINT "type_establishment_pkey" PRIMARY KEY ("id")
;

-- Table type_training

CREATE TABLE "type_training"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "date_training" Timestamp NOT NULL,
 "description" Character varying(256),
 "user_id" Integer,
 "establishment_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table type_training

CREATE INDEX "IX_Relationship10" ON "type_training" ("user_id")
;

CREATE INDEX "IX_Relationship11" ON "type_training" ("establishment_id")
;

-- Add keys for table type_training

ALTER TABLE "type_training" ADD CONSTRAINT "type_training_pkey" PRIMARY KEY ("id")
;

-- Table liked_comment

CREATE TABLE "liked_comment"(
 "comment_id" Integer NOT NULL,
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table liked_comment

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_pkey" PRIMARY KEY ("comment_id","user_id")
;

-- Table liked_offer

CREATE TABLE "liked_offer"(
 "offer_id" Integer NOT NULL,
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table liked_offer

ALTER TABLE "liked_offer" ADD CONSTRAINT "liked_offer_pkey" PRIMARY KEY ("offer_id","user_id")
;

-- Table liked_post

CREATE TABLE "liked_post"(
 "user_id" Integer NOT NULL,
 "post_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table liked_post

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_pkey" PRIMARY KEY ("user_id","post_id")
;

-- Table post

CREATE TABLE "post"(
 "id" Serial NOT NULL,
 "create_date" Time with time zone NOT NULL,
 "content" Text NOT NULL,
 "user_id" Integer NOT NULL,
 "document_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table post

CREATE INDEX "IX_post_user_fkey" ON "post" ("user_id")
;

CREATE INDEX "IX_post_document_fkey" ON "post" ("document_id")
;

-- Add keys for table post

ALTER TABLE "post" ADD CONSTRAINT "Key2" PRIMARY KEY ("id")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "company" ADD CONSTRAINT "company_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "document" ADD CONSTRAINT "document_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "company" ADD CONSTRAINT "company_country_fkey" FOREIGN KEY ("country_id") REFERENCES "country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "type_domain" ADD CONSTRAINT "domain_company_pkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "offer" ADD CONSTRAINT "offer_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "offer" ADD CONSTRAINT "offre_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "users" ADD CONSTRAINT "user_country_fkey" FOREIGN KEY ("country_id") REFERENCES "country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "users" ADD CONSTRAINT "user_state_fkey" FOREIGN KEY ("state_id") REFERENCES "state" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "type_training" ADD CONSTRAINT "training_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "type_training" ADD CONSTRAINT "training_type_establishment_fkey" FOREIGN KEY ("establishment_id") REFERENCES "type_establishment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "post" ADD CONSTRAINT "post_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "document" ADD CONSTRAINT "document_document_type_fkey" FOREIGN KEY ("document_type_id") REFERENCES "document_type" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "post" ADD CONSTRAINT "post_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "comment" ADD CONSTRAINT "comment_post_fkey" FOREIGN KEY ("post_id") REFERENCES "post" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "comment" ADD CONSTRAINT "comment_user_fkey" FOREIGN KEY ("id_user") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "comment" ADD CONSTRAINT "comment_offer_fkey" FOREIGN KEY ("offer_id") REFERENCES "offer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_fkey" FOREIGN KEY ("comment_id") REFERENCES "comment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_fkey" FOREIGN KEY ("post_id") REFERENCES "post" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_offer" ADD CONSTRAINT "Relationship9" FOREIGN KEY ("offer_id") REFERENCES "offer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_offer" ADD CONSTRAINT "Relationship10" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_users_sender_fkey" FOREIGN KEY ("from_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_users_receiver_fkey" FOREIGN KEY ("to_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_message_state_fkey" FOREIGN KEY ("state_id") REFERENCES "message_state" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;





