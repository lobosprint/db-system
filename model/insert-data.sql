/***** INSERT JOBS *****/
insert into job
(name_job, description)
values ('Secretario', 'El puesto de secretario se encarga de recibir al público interesado en ser atendido por el servicio administrativo. Son los encargados de administrar y tramitar las peticiones para ser atendidos.');

insert into job
(name_job, description)
values ('Profesor', 'El puesto de profeso consiste en atender a los alumnos por los distintos motivos que sean necesario como podrían ser las tutorías, revisión de notas, justificar ausencias y más temas académicos.');

insert into job
(name_job, description)
values ('Consejero', 'El puesto de consejero es un personal especializado en aconsejar con la trayectoria académica y las distintas asignaturas que se deben de tomar.');
/***** END INSERT JOBS *****/

/***** INSERT AREA *****/
insert into area
(name_area)
values ('ADMIN');

insert into area
(name_area)
values ('ICOM');

insert into area
(name_area)
values ('COMP');

insert into area
(name_area)
values ('ININ');
/***** END INSERT AREA *****/

/***** INSERT PLACE *****/
insert into place
(office, building, longitude, latitude)
values ('223-S', 'Luis Stefani', '18.210287', '-67.140331');

insert into place
(office, building, longitude, latitude)
values ('2-S', 'Luis Stefani', '18.210287', '-67.140331');

insert into place
(office, building, longitude, latitude)
values ('165-S', 'Luis Stefani', '18.210287', '-67.140331');

insert into place
(office, building, longitude, latitude)
values ('22-M', 'Luis Monzón', '18.210287', '-67.140331');

insert into place
(office, building, longitude, latitude)
values ('15-CM', 'Coliseo Mangual', '18.210287', '-67.140331');

insert into place
(office, building, longitude, latitude)
values ('156-AE', 'Administración de Empresas', '18.210287', '-67.140331');
/***** END INSERT PLACE *****/

/***** INSERT STUDENT *****/
insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Marcos', 'Pepito', 'Antolí', '1995-08-22', '7872224400', 'marcos.antoli@upr.edu', md5('pass1234'), '702160341');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Luis', 'Alfonso', 'Luisa', '1985-04-21', '7872224321', 'alfonso.luisa@upr.edu', md5('pass1234'), '702160342');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Raul', 'Camilo', 'Gonzalez', '1992-08-12', '7872224425', 'raul.camilo@upr.edu', md5('pass1234'), '702160343');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Natalie', 'Nicole', 'Martinez', '1987-01-18', '7872224439', 'natalie.nicole@upr.edu', md5('pass1234'), '702160344');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Carlos', 'Benito', 'Camela', '1991-06-19', '7872224424', 'carlos.benito@upr.edu', md5('pass1234'), '702160345');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), true);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Cristian', 'Sinchan', 'Clas', '1993-07-14', '7872224412', 'cristian.sicnchan@upr.edu', md5('pass1234'), '702160346');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Roberto', 'Nico', 'Perez', '1981-04-17', '7872224411', 'nico.perez@upr.edu', md5('pass1234'), '702160347');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), true);

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Julen', 'Alan', 'Nicolas', '1981-04-19', '7872224446', 'julen.alan@upr.edu', md5('pass1234'), '702160348');

insert into student
(id_person, handiecap)
values ((select id_person from person order by id_person desc limit 1), false);
/***** END INSERT STUDENTS *****/


/** Puestos de trabajo **/
/**
insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ADMIN' limit 1), (select id_job from job where name_job = 'Profesor' limit 1), (select id_place from place where office='156-AE' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ADMIN' limit 1), (select id_job from job where name_job = 'Secretario' limit 1), (select id_place from place where office='156-AE' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ADMIN' limit 1), (select id_job from job where name_job = 'Consejero' limit 1), (select id_place from place where office='156-AE' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ICOM' limit 1), (select id_job from job where name_job = 'Profesor' limit 1), (select id_place from place where office='223-S' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ICOM' limit 1), (select id_job from job where name_job = 'Secretario' limit 1), (select id_place from place where office='223-S' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ININ' limit 1), (select id_job from job where name_job = 'Profesor' limit 1), (select id_place from place where office='15-M' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'COMP' limit 1), (select id_job from job where name_job = 'Secretario' limit 1), (select id_place from place where office='22-M' limit 1));

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'COMP' limit 1), (select id_job from job where name_job = 'Consejero' limit 1), (select id_place from place where office='22-M' limit 1));
**/







/***** INSERT ADMIN ******/

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ININ' limit 1), (select id_job from job where name_job = 'Profesor' limit 1), (select id_place from place where office='15-M' limit 1));

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Humberto', 'Pepinillo', 'Blas', '1993-07-14', '7872224412', 'pepinillo.blas@upr.edu', md5('pass1234'), '702160349');

insert into administrative
(id_person, id_position)
values ((select id_person from person order by id_person desc limit 1), (select id_position from position_type order by id_position desc limit 1));

insert into person
(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id)
values ('Colifornio', 'Jangueador', 'Amo', '1981-04-17', '7872224411', 'jangueador.amo@upr.edu', md5('pass1234'), '702160310');

insert into position_type
(id_area, id_job, id_place)
values ((select id_area from area where name_area = 'ININ' limit 1), (select id_job from job where name_job = 'Secretario' limit 1), (select id_place from place where office='15-M' limit 1));

insert into administrative
(id_person, id_position)
values ((select id_person from person order by id_person desc limit 1), (select id_position from position_type order by id_position desc limit 1));

/** INSER TURN **/
insert into turn
(id_student, id_administrative, start_time, finish_time, penalty_cost,description, attended)
values (2,(select id_administrative from administrative order by id_administrative asc limit 1),now(),now(),52,'Quiero ver la nota del examen parcial de ICOM 5016', true);
insert into turn
(id_student, id_administrative, start_time, finish_time, penalty_cost,description, attended)
values (2,(select id_administrative from administrative order by id_administrative asc limit 1),now(),now(),52,'Quiero ver la revisión del examen parcial de ICOM 5016', false);
(id_student, id_administrative, start_time, finish_time, penalty_cost,description, attended)
values (1,(select id_administrative from administrative order by id_administrative asc limit 1),now(),now(),52,'Ejercicios revisión de ICOM 5016', false);

/*** INSERT PENALTIES ***/
insert into penalty
(id_payment, id_turn)
values(null,(select id_turn from turn order by id_turn desc limit 1));

insert into payment
(confirmation_number, date_payment)
values(6564565,now());

update penalty set id_payment = (select id_payment from payment order by id_payment limit 1) where id_penalty = (select id_penalty from penalty order by id_penalty limit 1);

insert into commentary
(id_turn, description)
values((select id_turn from turn order by id_turn desc limit 1), 'No ha traido los papeles necesarios');
insert into commentary
(id_turn, description)
values((select id_turn from turn order by id_turn desc limit 1), 'Tiene que hablar menos de su vida');
insert into commentary
(id_turn, description)
values((select id_turn from turn order by id_turn desc limit 1), 'Es un pesado');
