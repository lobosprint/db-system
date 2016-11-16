-- Database: turn4u

-- DROP DATABASE turn4u;

--CREATE DATABASE turn4u
 -- WITH OWNER = postgres
  --     ENCODING = 'UTF8'
   --    TABLESPACE = pg_default
    --   LC_COLLATE = 'es_PR.UTF-8'
     --  LC_CTYPE = 'es_PR.UTF-8'
      -- CONNECTION LIMIT = -1;

--DROP TABLE turn;
--DROP TABLE payment;
--DROP TABLE penalty;
--DROP TABLE commentary;
--DROP TABLE administrative;
--DROP TABLE position_type;
--DROP TABLE area;
--DROP TABLE job;
--DROP TABLE student;
--DROP TABLE place;
--DROP TABLE person;

CREATE TABLE person
(
id_person serial primary key,
first_name varchar(100),
middle_name varchar(100),
last_name varchar(100),
date_birth date,
phone varchar(50),
email varchar(100),
password varchar(255),
rum_id varchar(20)
);

CREATE TABLE student
(
id_student serial primary key,
id_person int references person(id_person) unique,
handiecap boolean
);

CREATE TABLE job
(
id_job serial primary key,
name_job varchar(100),
description varchar(250)
);

CREATE TABLE area
(
id_area serial primary key,
name_area varchar(100)
);
CREATE TABLE place
(
id_place serial primary key,
office varchar(50),
building varchar(100),
longitude varchar(100),
latitude varchar(100)
);
CREATE TABLE position_type
(
id_position serial,
id_area int,
id_job int,
id_place int,
PRIMARY KEY (id_position),
FOREIGN KEY (id_area) references area (id_area),
FOREIGN KEY (id_job) references job (id_job),
FOREIGN KEY (id_place) references place (id_place)
);
CREATE TABLE administrative
(
id_administrative serial,
id_person int,
id_position int,
FOREIGN KEY (id_person) references person (id_person),
FOREIGN KEY (id_position) references position_type (id_position),
PRIMARY KEY (id_administrative, id_position)
);

CREATE TABLE turn
(
id_turn serial primary key,
id_student int,
id_administrative int,
id_position int,
start_time timestamp,
finish_time timestamp,
penalty_cost int,
description varchar(255),
attended boolean default false,
FOREIGN KEY (id_student) references student (id_student),
FOREIGN KEY (id_administrative, id_position) references administrative (id_administrative, id_position)
);

CREATE TABLE payment
(
id_payment serial primary key,
confirmation_number int,
date_payment date,
type_card varchar(50),
numbers_card int,
expiration_card date
);

CREATE TABLE penalty
(
id_penalty serial primary key,
id_payment int,
id_turn int,
FOREIGN KEY (id_payment) references payment (id_payment),
FOREIGN KEY (id_turn) references turn (id_turn)
);

CREATE TABLE commentary
(
id_comment serial primary key,
id_turn int,
description varchar(250),
FOREIGN KEY (id_turn) references turn (id_turn)
);
