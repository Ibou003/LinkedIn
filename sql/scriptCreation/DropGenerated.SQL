/*
Created: 24/05/2015
Modified: 31/05/2015
Model: VR
Database: PostgreSQL 9.2
*/


-- Drop relationships section -------------------------------------------------

ALTER TABLE "depot" DROP CONSTRAINT "depot_user_fk"
;
ALTER TABLE "fil_actualite" DROP CONSTRAINT "from_fk"
;
ALTER TABLE "message" DROP CONSTRAINT "to_fk"
;
ALTER TABLE "message" DROP CONSTRAINT "from_fk"
;
ALTER TABLE "depot" DROP CONSTRAINT "depot_residence_fk"
;
ALTER TABLE "fil_actualite" DROP CONSTRAINT "actualite_residence_fk"
;
ALTER TABLE "utilisateur" DROP CONSTRAINT "user_residence_fk"
;




-- Drop keys for tables section -------------------------------------------------

ALTER TABLE "depot" DROP CONSTRAINT "Key5"
;
ALTER TABLE "message" DROP CONSTRAINT "Key4"
;
ALTER TABLE "fil_actualite" DROP CONSTRAINT "Key3"
;
ALTER TABLE "utilisateur" DROP CONSTRAINT "Key2"
;
ALTER TABLE "residence" DROP CONSTRAINT "users_pkey"
;


-- Drop indexes section -------------------------------------------------

DROP INDEX "depot_residence_IX"
;
DROP INDEX "depot_user_IX"
;
DROP INDEX "message_user_from_IX"
;
DROP INDEX "message_user_to_IX"
;
DROP INDEX "actualite_residence_IX"
;
DROP INDEX "actualite_user_IX"
;
DROP INDEX "user_residence_IX"
;

-- Drop tables section ---------------------------------------------------

DROP TABLE "depot"
;
DROP TABLE "message"
;
DROP TABLE "fil_actualite"
;
DROP TABLE "utilisateur"
;
DROP TABLE "residence"
;


-- Create tables section -------------------------------------------------

-- Table residence

CREATE TABLE "residence"(
 "id" Serial NOT NULL,
 "name" Character varying(128),
 "number" Integer NOT NULL,
 "street_name" Character varying(256) NOT NULL,
 "city" Character varying(256) NOT NULL,
 "zip_code" Character varying(128) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table residence

ALTER TABLE "residence" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id")
;

-- Table utilisateur

CREATE TABLE "utilisateur"(
 "id" Serial NOT NULL,
 "name" Character varying(64) NOT NULL,
 "surname" Character varying(64) NOT NULL,
 "email" Character varying(128) NOT NULL,
 "password" Character varying(256) NOT NULL,
 "role" Character varying(32) NOT NULL,
 "type_habitant" Character varying(32),
 "residence_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table utilisateur

CREATE INDEX "user_residence_IX" ON "utilisateur" ("residence_id")
;

-- Add keys for table utilisateur

ALTER TABLE "utilisateur" ADD CONSTRAINT "Key2" PRIMARY KEY ("id")
;

-- Table fil_actualite

CREATE TABLE "fil_actualite"(
 "id" Serial NOT NULL,
 "suject" Character varying(256) NOT NULL,
 "date_creation" Character varying(256) NOT NULL,
 "body" Text,
 "residence_id" Integer,
 "from_id" Integer,
 "name" Character varying(128)
)
WITH (OIDS=FALSE)
;

-- Create indexes for table fil_actualite

CREATE INDEX "actualite_residence_IX" ON "fil_actualite" ("residence_id")
;

CREATE INDEX "actualite_user_IX" ON "fil_actualite" ("from_id")
;

-- Add keys for table fil_actualite

ALTER TABLE "fil_actualite" ADD CONSTRAINT "Key3" PRIMARY KEY ("id")
;

-- Table message

CREATE TABLE "message"(
 "id" Serial NOT NULL,
 "suject" Character varying(256),
 "body" Text,
 "date_creation" Character varying(256) NOT NULL,
 "from_id" Integer,
 "to_id" Integer,
 "name" Character varying(128)
)
WITH (OIDS=FALSE)
;

-- Create indexes for table message

CREATE INDEX "message_user_from_IX" ON "message" ("from_id")
;

CREATE INDEX "message_user_to_IX" ON "message" ("to_id")
;

-- Add keys for table message

ALTER TABLE "message" ADD CONSTRAINT "Key4" PRIMARY KEY ("id")
;

-- Table depot

CREATE TABLE "depot"(
 "id" Serial NOT NULL,
 "image" Bytea NOT NULL,
 "suject" Character varying(256) NOT NULL,
 "body" Text NOT NULL,
 "disponibiilte" Character varying(15) NOT NULL,
 "date_creation" Character varying(256) NOT NULL,
 "residence_id" Integer,
 "name" Character varying(128),
 "from_id" Integer
)
WITH (OIDS=FALSE)
;

-- Create indexes for table depot

CREATE INDEX "depot_residence_IX" ON "depot" ("residence_id")
;

CREATE INDEX "depot_user_IX" ON "depot" ("from_id")
;

-- Add keys for table depot

ALTER TABLE "depot" ADD CONSTRAINT "Key5" PRIMARY KEY ("id")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "utilisateur" ADD CONSTRAINT "user_residence_fk" FOREIGN KEY ("residence_id") REFERENCES "residence" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "fil_actualite" ADD CONSTRAINT "actualite_residence_fk" FOREIGN KEY ("residence_id") REFERENCES "residence" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "depot" ADD CONSTRAINT "depot_residence_fk" FOREIGN KEY ("residence_id") REFERENCES "residence" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "from_fk" FOREIGN KEY ("from_id") REFERENCES "utilisateur" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "message" ADD CONSTRAINT "to_fk" FOREIGN KEY ("to_id") REFERENCES "utilisateur" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "fil_actualite" ADD CONSTRAINT "from_fk" FOREIGN KEY ("from_id") REFERENCES "utilisateur" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "depot" ADD CONSTRAINT "depot_user_fk" FOREIGN KEY ("from_id") REFERENCES "utilisateur" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;





