--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: administrative; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE administrative (
    id_administrative integer NOT NULL,
    id_person integer,
    id_position integer NOT NULL
);


ALTER TABLE administrative OWNER TO turn4u;

--
-- Name: administrative_id_administrative_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE administrative_id_administrative_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE administrative_id_administrative_seq OWNER TO turn4u;

--
-- Name: administrative_id_administrative_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE administrative_id_administrative_seq OWNED BY administrative.id_administrative;


--
-- Name: area; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE area (
    id_area integer NOT NULL,
    name_area character varying(100)
);


ALTER TABLE area OWNER TO turn4u;

--
-- Name: area_id_area_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE area_id_area_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE area_id_area_seq OWNER TO turn4u;

--
-- Name: area_id_area_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE area_id_area_seq OWNED BY area.id_area;


--
-- Name: commentary; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE commentary (
    id_comment integer NOT NULL,
    id_turn integer,
    description character varying(250)
);


ALTER TABLE commentary OWNER TO turn4u;

--
-- Name: commentary_id_comment_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE commentary_id_comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE commentary_id_comment_seq OWNER TO turn4u;

--
-- Name: commentary_id_comment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE commentary_id_comment_seq OWNED BY commentary.id_comment;


--
-- Name: job; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE job (
    id_job integer NOT NULL,
    name_job character varying(100),
    description character varying(250)
);


ALTER TABLE job OWNER TO turn4u;

--
-- Name: job_id_job_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE job_id_job_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE job_id_job_seq OWNER TO turn4u;

--
-- Name: job_id_job_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE job_id_job_seq OWNED BY job.id_job;


--
-- Name: payment; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE payment (
    id_payment integer NOT NULL,
    confirmation_number integer,
    date_payment character varying(10),
    type_card character varying(50),
    numbers_card integer,
    expiration_card character varying(10)
);


ALTER TABLE payment OWNER TO turn4u;

--
-- Name: payment_id_payment_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE payment_id_payment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payment_id_payment_seq OWNER TO turn4u;

--
-- Name: payment_id_payment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE payment_id_payment_seq OWNED BY payment.id_payment;


--
-- Name: penalty; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE penalty (
    id_penalty integer NOT NULL,
    id_payment integer,
    id_turn integer
);


ALTER TABLE penalty OWNER TO turn4u;

--
-- Name: penalty_id_penalty_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE penalty_id_penalty_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE penalty_id_penalty_seq OWNER TO turn4u;

--
-- Name: penalty_id_penalty_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE penalty_id_penalty_seq OWNED BY penalty.id_penalty;


--
-- Name: person; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE person (
    id_person integer NOT NULL,
    first_name character varying(100),
    middle_name character varying(100),
    last_name character varying(100),
    date_birth character varying(10),
    phone character varying(50),
    email character varying(100),
    password character varying(255),
    rum_id character varying(20)
);


ALTER TABLE person OWNER TO turn4u;

--
-- Name: person_id_person_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE person_id_person_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE person_id_person_seq OWNER TO turn4u;

--
-- Name: person_id_person_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE person_id_person_seq OWNED BY person.id_person;


--
-- Name: place; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE place (
    id_place integer NOT NULL,
    office character varying(50),
    building character varying(100),
    longitude character varying(100),
    latitude character varying(100)
);


ALTER TABLE place OWNER TO turn4u;

--
-- Name: place_id_place_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE place_id_place_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE place_id_place_seq OWNER TO turn4u;

--
-- Name: place_id_place_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE place_id_place_seq OWNED BY place.id_place;


--
-- Name: position_type; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE position_type (
    id_position integer NOT NULL,
    id_area integer,
    id_job integer,
    id_place integer
);


ALTER TABLE position_type OWNER TO turn4u;

--
-- Name: position_type_id_position_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE position_type_id_position_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE position_type_id_position_seq OWNER TO turn4u;

--
-- Name: position_type_id_position_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE position_type_id_position_seq OWNED BY position_type.id_position;


--
-- Name: student; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE student (
    id_student integer NOT NULL,
    id_person integer,
    handiecap boolean
);


ALTER TABLE student OWNER TO turn4u;

--
-- Name: student_id_student_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE student_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE student_id_student_seq OWNER TO turn4u;

--
-- Name: student_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE student_id_student_seq OWNED BY student.id_student;


--
-- Name: turn; Type: TABLE; Schema: public; Owner: turn4u
--

CREATE TABLE turn (
    id_turn integer NOT NULL,
    id_student integer,
    id_administrative integer,
    id_position integer,
    start_time timestamp without time zone,
    finish_time timestamp without time zone,
    penalty_cost integer,
    description character varying(255),
    attended boolean DEFAULT false
);


ALTER TABLE turn OWNER TO turn4u;

--
-- Name: turn_id_turn_seq; Type: SEQUENCE; Schema: public; Owner: turn4u
--

CREATE SEQUENCE turn_id_turn_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE turn_id_turn_seq OWNER TO turn4u;

--
-- Name: turn_id_turn_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: turn4u
--

ALTER SEQUENCE turn_id_turn_seq OWNED BY turn.id_turn;


--
-- Name: id_administrative; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY administrative ALTER COLUMN id_administrative SET DEFAULT nextval('administrative_id_administrative_seq'::regclass);


--
-- Name: id_area; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY area ALTER COLUMN id_area SET DEFAULT nextval('area_id_area_seq'::regclass);


--
-- Name: id_comment; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY commentary ALTER COLUMN id_comment SET DEFAULT nextval('commentary_id_comment_seq'::regclass);


--
-- Name: id_job; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY job ALTER COLUMN id_job SET DEFAULT nextval('job_id_job_seq'::regclass);


--
-- Name: id_payment; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY payment ALTER COLUMN id_payment SET DEFAULT nextval('payment_id_payment_seq'::regclass);


--
-- Name: id_penalty; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY penalty ALTER COLUMN id_penalty SET DEFAULT nextval('penalty_id_penalty_seq'::regclass);


--
-- Name: id_person; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY person ALTER COLUMN id_person SET DEFAULT nextval('person_id_person_seq'::regclass);


--
-- Name: id_place; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY place ALTER COLUMN id_place SET DEFAULT nextval('place_id_place_seq'::regclass);


--
-- Name: id_position; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY position_type ALTER COLUMN id_position SET DEFAULT nextval('position_type_id_position_seq'::regclass);


--
-- Name: id_student; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY student ALTER COLUMN id_student SET DEFAULT nextval('student_id_student_seq'::regclass);


--
-- Name: id_turn; Type: DEFAULT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY turn ALTER COLUMN id_turn SET DEFAULT nextval('turn_id_turn_seq'::regclass);


--
-- Data for Name: administrative; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY administrative (id_administrative, id_person, id_position) FROM stdin;
4	1	4
5	1	5
6	1	6
9	2	7
10	2	5
11	2	15
12	3	10
13	3	11
16	3	18
17	4	12
20	4	13
23	4	14
24	4	15
25	5	6
26	5	8
27	5	10
28	5	13
29	5	15
30	5	16
31	5	18
\.


--
-- Name: administrative_id_administrative_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('administrative_id_administrative_seq', 31, true);


--
-- Data for Name: area; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY area (id_area, name_area) FROM stdin;
1	ADMIN
2	ICOM
3	COMP
4	ININ
5	INGE
6	INME
7	INCI
8	CISO
9	INQU
\.


--
-- Name: area_id_area_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('area_id_area_seq', 7, true);


--
-- Data for Name: commentary; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY commentary (id_comment, id_turn, description) FROM stdin;
31	64	Comenzar
32	64	Comenzar ya se hizo
33	64	Otro comentario
\.


--
-- Name: commentary_id_comment_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('commentary_id_comment_seq', 33, true);


--
-- Data for Name: job; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY job (id_job, name_job, description) FROM stdin;
1	Secretario	El puesto de secretario se encarga de recibir al público interesado en ser atendido por el servicio administrativo. Son los encargados de administrar y tramitar las peticiones para ser atendidos.
2	Profesor	El puesto de profeso consiste en atender a los alumnos por los distintos motivos que sean necesario como podrían ser las tutorías, revisión de notas, justificar ausencias y más temas académicos.
3	Consejero	El puesto de consejero es un personal especializado en aconsejar con la trayectoria académica y las distintas asignaturas que se deben de tomar.
\.


--
-- Name: job_id_job_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('job_id_job_seq', 3, true);


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY payment (id_payment, confirmation_number, date_payment, type_card, numbers_card, expiration_card) FROM stdin;
1	6564565	2016-12-06	VISA	12345678	2017-12-01
2	0	2016-12-05	Master Card	23424324	2016-12-21
3	0	2016-12-05	Visa	23213213	2016-12-27
4	0	2016-12-05	Master Card	2342423	2016-12-26
5	0	2016-12-05	Visa	323242	2016-12-22
6	83672739	2016-12-05	Visa	234243232	2016-12-20
7	88068349	2016-12-05	Visa	24322	2016-12-28
8	95630237	2016-12-05	Master Card	2342432	2016-12-21
9	81931869	2016-12-05	Visa	0	2016-12-27
10	15017594	2016-12-12	Visa	342423	2016-12-30
11	89413772	2016-12-12	Visa	2312	2016-12-27
12	40638815	2016-12-12	Visa	987	2016-12-20
\.


--
-- Name: payment_id_payment_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('payment_id_payment_seq', 12, true);


--
-- Data for Name: penalty; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY penalty (id_penalty, id_payment, id_turn) FROM stdin;
45	11	61
47	12	62
48	\N	63
\.


--
-- Name: penalty_id_penalty_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('penalty_id_penalty_seq', 48, true);


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY person (id_person, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id) FROM stdin;
1	Marcos	Pepito	Antolí	1995-08-22	7872224400	marcos.antoli@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160341
2	Luis	Alfonso	Luisa	1985-04-21	7872224321	alfonso.luisa@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160342
3	Raul	Camilo	Gonzalez	1992-08-12	7872224425	raul.camilo@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160343
4	Natalie	Nicole	Martinez	1987-01-18	7872224439	natalie.nicole@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160344
5	Carlos	Benito	Camela	1991-06-19	7872224424	carlos.benito@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160345
6	Cristian	Sinchan	Clas	1993-07-14	7872224412	cristian.sicnchan@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160346
7	Roberto	Nico	Perez	1981-04-17	7872224411	nico.perez@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160347
8	Julen	Alan	Nicolas	1981-04-19	7872224446	julen.alan@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	702160348
18	Pedro	Pablo	Perez	2016-12-12	787123456	ppp.ppp@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	11223344
19	Cristian	Alfonso	Garzon	2016-12-14	7871234567	cristian.garzon@upr.edu	b4af804009cb036a4ccdc33431ef9ac9	502161887
40	Manuel		Rodriguez HappyHour	1984-01-09	7871234567	carlosdfuentes@gmail.com	b4af804009cb036a4ccdc33431ef9ac9	802161234
\.


--
-- Name: person_id_person_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('person_id_person_seq', 40, true);


--
-- Data for Name: place; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY place (id_place, office, building, longitude, latitude) FROM stdin;
1	223-S	Luis Stefani	18.210287	-67.140331
2	2-S	Luis Stefani	18.210287	-67.140331
3	165-S	Luis Stefani	18.210287	-67.140331
4	22-M	Luis Monzón	18.210287	-67.140331
5	15-CM	Coliseo Mangual	18.210287	-67.140331
6	156-AE	Administración de Empresas	18.210287	-67.140331
\.


--
-- Name: place_id_place_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('place_id_place_seq', 6, true);


--
-- Data for Name: position_type; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY position_type (id_position, id_area, id_job, id_place) FROM stdin;
4	1	1	\N
5	1	2	\N
6	1	3	\N
7	2	1	\N
8	2	2	\N
9	2	3	\N
10	3	2	\N
11	3	3	\N
12	4	1	\N
13	4	2	\N
14	4	3	\N
15	5	3	\N
16	6	1	\N
18	7	2	\N
\.


--
-- Name: position_type_id_position_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('position_type_id_position_seq', 18, true);


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY student (id_student, id_person, handiecap) FROM stdin;
38	40	f
\.


--
-- Name: student_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('student_id_student_seq', 38, true);


--
-- Data for Name: turn; Type: TABLE DATA; Schema: public; Owner: turn4u
--

COPY turn (id_turn, id_student, id_administrative, id_position, start_time, finish_time, penalty_cost, description, attended) FROM stdin;
61	38	17	12	2016-12-12 22:51:12.972742	\N	5	Testing Turn	f
62	38	20	13	2016-12-12 23:43:57.621527	\N	5	defrvgtbhynujki	f
65	38	20	13	\N	\N	5	Mirala profesora	f
66	38	17	12	2016-12-13 00:52:31.477497	2016-12-13 00:52:50.322669	5	Mira que bonitoo	t
63	38	23	14	2016-12-13 00:54:26.063837	\N	5	No sabemos que hacer	f
64	38	23	14	2016-12-13 00:58:51.554335	2016-12-13 00:59:11.071215	5	Segunda prueba	t
\.


--
-- Name: turn_id_turn_seq; Type: SEQUENCE SET; Schema: public; Owner: turn4u
--

SELECT pg_catalog.setval('turn_id_turn_seq', 66, true);


--
-- Name: administrative_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY administrative
    ADD CONSTRAINT administrative_pkey PRIMARY KEY (id_administrative, id_position);


--
-- Name: area_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY area
    ADD CONSTRAINT area_pkey PRIMARY KEY (id_area);


--
-- Name: commentary_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY commentary
    ADD CONSTRAINT commentary_pkey PRIMARY KEY (id_comment);


--
-- Name: job_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY job
    ADD CONSTRAINT job_pkey PRIMARY KEY (id_job);


--
-- Name: payment_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id_payment);


--
-- Name: penalty_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY penalty
    ADD CONSTRAINT penalty_pkey PRIMARY KEY (id_penalty);


--
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id_person);


--
-- Name: place_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY place
    ADD CONSTRAINT place_pkey PRIMARY KEY (id_place);


--
-- Name: position_type_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY position_type
    ADD CONSTRAINT position_type_pkey PRIMARY KEY (id_position);


--
-- Name: student_id_person_key; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_id_person_key UNIQUE (id_person);


--
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id_student);


--
-- Name: turn_pkey; Type: CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY turn
    ADD CONSTRAINT turn_pkey PRIMARY KEY (id_turn);


--
-- Name: administrative_id_person_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY administrative
    ADD CONSTRAINT administrative_id_person_fkey FOREIGN KEY (id_person) REFERENCES person(id_person);


--
-- Name: administrative_id_position_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY administrative
    ADD CONSTRAINT administrative_id_position_fkey FOREIGN KEY (id_position) REFERENCES position_type(id_position);


--
-- Name: commentary_id_turn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY commentary
    ADD CONSTRAINT commentary_id_turn_fkey FOREIGN KEY (id_turn) REFERENCES turn(id_turn);


--
-- Name: penalty_id_payment_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY penalty
    ADD CONSTRAINT penalty_id_payment_fkey FOREIGN KEY (id_payment) REFERENCES payment(id_payment);


--
-- Name: penalty_id_turn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY penalty
    ADD CONSTRAINT penalty_id_turn_fkey FOREIGN KEY (id_turn) REFERENCES turn(id_turn);


--
-- Name: position_type_id_area_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY position_type
    ADD CONSTRAINT position_type_id_area_fkey FOREIGN KEY (id_area) REFERENCES area(id_area);


--
-- Name: position_type_id_job_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY position_type
    ADD CONSTRAINT position_type_id_job_fkey FOREIGN KEY (id_job) REFERENCES job(id_job);


--
-- Name: position_type_id_place_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY position_type
    ADD CONSTRAINT position_type_id_place_fkey FOREIGN KEY (id_place) REFERENCES place(id_place);


--
-- Name: student_id_person_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_id_person_fkey FOREIGN KEY (id_person) REFERENCES person(id_person);


--
-- Name: turn_id_administrative_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY turn
    ADD CONSTRAINT turn_id_administrative_fkey FOREIGN KEY (id_administrative, id_position) REFERENCES administrative(id_administrative, id_position);


--
-- Name: turn_id_student_fkey; Type: FK CONSTRAINT; Schema: public; Owner: turn4u
--

ALTER TABLE ONLY turn
    ADD CONSTRAINT turn_id_student_fkey FOREIGN KEY (id_student) REFERENCES student(id_student);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

