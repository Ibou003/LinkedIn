/*
Created: 06/03/2015
Modified: 10/04/2015
Project: dant
Model: Linkedin
Company: naaf.com
Author: naaf
Version: 1.0
Database: PostgreSQL 9.2
*/


-- Create tables section -------------------------------------------------

-- Table message

CREATE TABLE "message"(
 "id" Serial NOT NULL,
 "create_date" Timestamp NOT NULL,
 "subject" Character varying(256),
 "body" Text,
 "from_id" Integer NOT NULL,
 "to_id" Integer NOT NULL,
 "document_id" Integer,
 "message_type" Character varying(128) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Create indexes for table message

CREATE INDEX "IX_Relationship12" ON "message" ("from_id")
;

CREATE INDEX "IX_Relationship113" ON "message" ("to_id")
;

CREATE INDEX "IX_Relationship15" ON "message" ("document_id")
;

-- Add keys for table message

ALTER TABLE "message" ADD CONSTRAINT "message_pkey" PRIMARY KEY ("id")
;

-- Table document

CREATE TABLE "document"(
 "id" Serial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "path" Character varying(256) NOT NULL,
 "document_type" Character varying(256) NOT NULL,
 "company_id" Integer,
 "user_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table document

CREATE INDEX "IX_document_company_fkey" ON "document" ("company_id")
;

CREATE INDEX "IX_Relationship20" ON "document" ("user_id")
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

-- Add keys for table users

ALTER TABLE "users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id")
;

ALTER TABLE "users" ADD CONSTRAINT "login_users" UNIQUE ("email")
;

-- Table company

CREATE TABLE "company"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "naf" Character varying(50) NOT NULL,
 "registeration_number" Character varying(50) NOT NULL,
 "company_creation_date" Timestamp with time zone NOT NULL,
 "phone" Character varying(20),
 "mobile" Character varying(20),
 "description" Text,
 "email" Character varying(128) NOT NULL,
 "password" Character varying(128) NOT NULL,
 "user_id" Integer NOT NULL,
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
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Create indexes for table comment

CREATE INDEX "IX_comment_post" ON "comment" ("post_id")
;

CREATE INDEX "IX_comment_user" ON "comment" ("user_id")
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

-- Table domain

CREATE TABLE "domain"(
 "id" Serial NOT NULL,
 "title" Character varying(256) NOT NULL,
 "description" Character varying(256),
 "company_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table domain

CREATE INDEX "IX_domain_company_fkey" ON "domain" ("company_id")
;

-- Add keys for table domain

ALTER TABLE "domain" ADD CONSTRAINT "type_domain_pkey" PRIMARY KEY ("id")
;

-- Table establishment

CREATE TABLE "establishment"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "description" Character varying(256),
 "number" Integer,
 "street_name" Character varying(256),
 "city" Character varying(256),
 "zip_code" Character(128)
)
WITH (OIDS=FALSE)
;

-- Add keys for table establishment

ALTER TABLE "establishment" ADD CONSTRAINT "type_establishment_pkey" PRIMARY KEY ("id")
;

-- Table training

CREATE TABLE "training"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "date_start" Timestamp NOT NULL,
 "date_end" Timestamp NOT NULL,
 "degree" Character varying(256) NOT NULL,
 "discipline" Character varying(256) NOT NULL,
 "description" Character varying(256),
 "user_id" Integer NOT NULL,
 "establishment_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table training

ALTER TABLE "training" ADD CONSTRAINT "type_training_pkey" PRIMARY KEY ("id")
;

-- Table liked_comment

CREATE TABLE "liked_comment"(
 "id" Serial NOT NULL,
 "comment_id" Integer NOT NULL,
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table liked_comment

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_pkey" PRIMARY KEY ("id")
;

-- Table liked_post

CREATE TABLE "liked_post"(
 "id" Serial NOT NULL,
 "user_id" Integer NOT NULL,
 "post_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table liked_post

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_pkey" PRIMARY KEY ("id")
;

-- Table post

CREATE TABLE "post"(
 "id" Serial NOT NULL,
 "create_date" Time with time zone NOT NULL,
 "content" Text NOT NULL,
 "user_id" Integer,
 "document_id" Integer,
 "company_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table post

CREATE INDEX "IX_post_user_fkey" ON "post" ("user_id")
;

CREATE INDEX "IX_post_document_fkey" ON "post" ("document_id")
;

CREATE INDEX "IX_Relationship21" ON "post" ("company_id")
;

-- Add keys for table post

ALTER TABLE "post" ADD CONSTRAINT "Key2" PRIMARY KEY ("id")
;

-- Table current_state

CREATE TABLE "current_state"(
 "id" Integer NOT NULL,
 "title" Character varying(256),
 "date_start" Timestamp,
 "date_end" Timestamp
)
WITH (OIDS=FALSE)
;

-- Add keys for table current_state

ALTER TABLE "current_state" ADD CONSTRAINT "Key3" PRIMARY KEY ("id")
;

-- Table competence

CREATE TABLE "competence"(
 "id" Serial NOT NULL,
 "name" Character varying(256) NOT NULL,
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table competence

ALTER TABLE "competence" ADD CONSTRAINT "Key4" PRIMARY KEY ("id")
;

-- Table language

CREATE TABLE "language"(
 "id" Serial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "description" Character varying(256),
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Create indexes for table language

CREATE INDEX "IX_Relationship13" ON "language" ("user_id")
;

-- Add keys for table language

ALTER TABLE "language" ADD CONSTRAINT "Key5" PRIMARY KEY ("id")
;

-- Table experience

CREATE TABLE "experience"(
 "id" Serial NOT NULL,
 "title" Character varying(128) NOT NULL,
 "date_start" Timestamp NOT NULL,
 "date_end" Timestamp NOT NULL,
 "description" Character varying(256),
 "user_id" Integer NOT NULL,
 "establishment_id" Integer NOT NULL,
 "current" Boolean
)
WITH (OIDS=FALSE)
;

-- Create indexes for table experience

CREATE INDEX "IX_Relationship55" ON "experience" ("user_id")
;

CREATE INDEX "IX_Relationship115" ON "experience" ("establishment_id")
;

-- Add keys for table experience

ALTER TABLE "experience" ADD CONSTRAINT "Key6" PRIMARY KEY ("id")
;

-- Table relation

CREATE TABLE "relation"(
 "id" Serial NOT NULL,
 "user_id" Integer NOT NULL,
 "friend_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Create indexes for table relation

CREATE INDEX "IX_Relationship16" ON "relation" ("user_id")
;

CREATE INDEX "IX_Relationship17" ON "relation" ("friend_id")
;

-- Add keys for table relation

ALTER TABLE "relation" ADD CONSTRAINT "Key7" PRIMARY KEY ("id")
;

-- Table subscriber

CREATE TABLE "subscriber"(
 "id" Serial NOT NULL,
 "company_id" Integer NOT NULL,
 "user_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Create indexes for table subscriber

CREATE INDEX "IX_Relationship18" ON "subscriber" ("company_id")
;

CREATE INDEX "IX_Relationship19" ON "subscriber" ("user_id")
;

-- Add keys for table subscriber

ALTER TABLE "subscriber" ADD CONSTRAINT "Key8" PRIMARY KEY ("id")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "company" ADD CONSTRAINT "company_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "document" ADD CONSTRAINT "document_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "company" ADD CONSTRAINT "company_country_fkey" FOREIGN KEY ("country_id") REFERENCES "country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "domain" ADD CONSTRAINT "domain_company_pkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "offer" ADD CONSTRAINT "offer_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "offer" ADD CONSTRAINT "offre_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "users" ADD CONSTRAINT "user_country_fkey" FOREIGN KEY ("country_id") REFERENCES "country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "training" ADD CONSTRAINT "training_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "training" ADD CONSTRAINT "training_establishment_fkey" FOREIGN KEY ("establishment_id") REFERENCES "establishment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "post" ADD CONSTRAINT "post_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "post" ADD CONSTRAINT "post_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "comment" ADD CONSTRAINT "comment_post_fkey" FOREIGN KEY ("post_id") REFERENCES "post" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "comment" ADD CONSTRAINT "comment_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_fkey" FOREIGN KEY ("comment_id") REFERENCES "comment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_comment" ADD CONSTRAINT "liked_comment_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "liked_post" ADD CONSTRAINT "liked_post_fkey" FOREIGN KEY ("post_id") REFERENCES "post" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_users_sender_fkey" FOREIGN KEY ("from_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_users_receiver_fkey" FOREIGN KEY ("to_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "message_document_fkey" FOREIGN KEY ("document_id") REFERENCES "document" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "competence" ADD CONSTRAINT "competence_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "experience" ADD CONSTRAINT "experience_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "language" ADD CONSTRAINT "language_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "current_state" ADD CONSTRAINT "Relationship14" FOREIGN KEY ("id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "experience" ADD CONSTRAINT "experience_establishment_fkey" FOREIGN KEY ("establishment_id") REFERENCES "establishment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "relation" ADD CONSTRAINT "Relationship16" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "relation" ADD CONSTRAINT "Relationship17" FOREIGN KEY ("friend_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "subscriber" ADD CONSTRAINT "subscriber_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "subscriber" ADD CONSTRAINT "subscriber_user_fkey" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "document" ADD CONSTRAINT "Relationship20" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "post" ADD CONSTRAINT "post_company_fkey" FOREIGN KEY ("company_id") REFERENCES "company" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;





