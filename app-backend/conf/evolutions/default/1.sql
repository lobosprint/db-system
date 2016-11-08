# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table area (
  id_area                       integer,
  name                          varchar(255)
);

create table comment (
  id_comment                    integer,
  description                   varchar(255)
);

create table job (
  id_job                        integer,
  name                          varchar(255),
  description                   varchar(255)
);

create table location (
  id_location                   integer,
  office                        varchar(255),
  building                      varchar(255),
  longitude                     varchar(255),
  latitude                      varchar(255)
);

create table login (
  mail                          varchar(255),
  pass                          varchar(255)
);

create table payment (
  id_payment                    integer,
  confirmation_number           integer,
  date                          timestamp
);

create table penalty (
  id_penalty                    integer,
  description                   varchar(255),
  cost                          integer
);

create table person (
  id_person                     integer,
  name                          varchar(255),
  middle_name                   varchar(255),
  last_name                     varchar(255),
  birth_date                    timestamp,
  phone                         varchar(255),
  mail                          varchar(255),
  pass                          varchar(255),
  rum_id                        varchar(255)
);

create table position (
  id_position                   integer
);

create table turn (
  id_turn                       integer,
  description                   varchar(255),
  start_time                    timestamp,
  end_time                      timestamp,
  penalty_cost                  integer
);

create table turn_db (
  id_turn                       integer,
  id_student                    integer,
  id_administrative             integer,
  time_min                      integer,
  penalty_cost                  integer
);


# --- !Downs

drop table if exists area cascade;

drop table if exists comment cascade;

drop table if exists job cascade;

drop table if exists location cascade;

drop table if exists login cascade;

drop table if exists payment cascade;

drop table if exists penalty cascade;

drop table if exists person cascade;

drop table if exists position cascade;

drop table if exists turn cascade;

drop table if exists turn_db cascade;

