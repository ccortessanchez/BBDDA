--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: cadastre; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cadastre (
    ref_cadastral integer NOT NULL,
    inmoble_id integer NOT NULL,
    propietari_id character(9) NOT NULL,
    sol_id integer NOT NULL,
    us_id integer NOT NULL,
    geolocalitzacio_id integer NOT NULL,
    fecha_id integer NOT NULL,
    ciutat character varying(25)
);


ALTER TABLE public.cadastre OWNER TO postgres;

--
-- Name: fecha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fecha (
    id_fecha integer NOT NULL,
    id_anyo integer NOT NULL,
    desc_anyo character varying(20),
    id_mes integer NOT NULL,
    desc_mes character varying(20),
    id_dia integer NOT NULL,
    desc_dia character varying(20)
);


ALTER TABLE public.fecha OWNER TO postgres;

--
-- Name: geolocalitzacio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE geolocalitzacio (
    id_geolocalitzacio integer NOT NULL,
    x integer,
    y integer,
    z integer
);


ALTER TABLE public.geolocalitzacio OWNER TO postgres;

--
-- Name: inmoble; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE inmoble (
    id_inmoble integer NOT NULL,
    superficie integer,
    estat character varying(50),
    internet boolean DEFAULT false NOT NULL,
    num_residents integer,
    planta integer,
    subtipus_inmoble integer
);


ALTER TABLE public.inmoble OWNER TO postgres;

--
-- Name: propietari; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE propietari (
    dni character(9) NOT NULL,
    nom character varying(25),
    cognom1 character varying(25),
    cognom2 character varying(25),
    telefon integer
);


ALTER TABLE public.propietari OWNER TO postgres;

--
-- Name: sol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sol (
    id_sol integer NOT NULL,
    superficie integer,
    tipus_sol integer
);


ALTER TABLE public.sol OWNER TO postgres;

--
-- Name: subtipus_inmoble; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE subtipus_inmoble (
    id_subtipus integer NOT NULL,
    nom character varying(50),
    descripcio character varying(200),
    tipus_inmoble integer
);


ALTER TABLE public.subtipus_inmoble OWNER TO postgres;

--
-- Name: tipus_inmoble; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipus_inmoble (
    id_tipusinmoble integer NOT NULL,
    nom character varying(50),
    descripcio character varying(200)
);


ALTER TABLE public.tipus_inmoble OWNER TO postgres;

--
-- Name: tipus_sol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipus_sol (
    id_tipussol integer NOT NULL,
    nom character varying(50),
    descripcio character varying(200)
);


ALTER TABLE public.tipus_sol OWNER TO postgres;

--
-- Name: us; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE us (
    id_us integer NOT NULL,
    nom character varying(50),
    descripcio character varying(200)
);


ALTER TABLE public.us OWNER TO postgres;

--
-- Data for Name: cadastre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cadastre (ref_cadastral, inmoble_id, propietari_id, sol_id, us_id, geolocalitzacio_id, fecha_id, ciutat) FROM stdin;
1	2	39225154B	1	2	1	2	Barcelona
2	3	39825154D	1	3	2	5	Girona
3	1	39425754H	1	1	3	9	Tarragona
4	3	39825154D	2	3	4	1	Barcelona
5	2	39125154E	2	2	4	6	Lleida
6	2	59425154G	2	2	2	7	Lleida
7	1	39225154B	1	1	1	3	Madrid
\.


--
-- Data for Name: fecha; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fecha (id_fecha, id_anyo, desc_anyo, id_mes, desc_mes, id_dia, desc_dia) FROM stdin;
1	2013	Anyo 2013	3	2013/10	1	2013/10/04
2	2013	Anyo 2013	5	2013/05	2	2013/05/16
3	2013	Anyo 2013	8	2013/08	3	2013/08/09
4	2013	Anyo 2013	12	2013/12	4	2013/12/14
5	2013	Anyo 2013	7	2013/08	5	2013/08/18
6	2013	Anyo 2013	66	2013/10	6	2013/10/08
7	2013	Anyo 2013	23	2013/03	7	2013/03/08
8	2013	Anyo 2013	11	2013/06	8	2013/06/29
9	2013	Anyo 2013	42	2013/05	9	2013/05/05
\.


--
-- Data for Name: geolocalitzacio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY geolocalitzacio (id_geolocalitzacio, x, y, z) FROM stdin;
1	200	300	29
2	150	139	80
3	25	100	47
4	60	200	50
\.


--
-- Data for Name: inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY inmoble (id_inmoble, superficie, estat, internet, num_residents, planta, subtipus_inmoble) FROM stdin;
1	200	en condicions	t	50	5	1
2	150	en condicions	f	3	1	2
3	1000	en obres	f	0	10	3
\.


--
-- Data for Name: propietari; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY propietari (dni, nom, cognom1, cognom2, telefon) FROM stdin;
39425154A	Carlos	Cortes	Sanchez	722719699
39225154B	Pere	Marques	Jornet	635719699
39625154C	Joan	Dalmau	Carmona	698719699
39825154D	Carla	Girones	Sanz	743719699
39125154E	Laia	Carpena	Mas	621719699
39425159F	Manuel	Sanchez	Garcia	799719699
59425154G	Pau	Antequera	Gomez	633719699
39425754H	Claudia	Duran	Martin	689719699
\.


--
-- Data for Name: sol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sol (id_sol, superficie, tipus_sol) FROM stdin;
1	200	1
2	500	1
3	150	2
4	300	1
\.


--
-- Data for Name: subtipus_inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY subtipus_inmoble (id_subtipus, nom, descripcio, tipus_inmoble) FROM stdin;
1	bloc	bloc de vivendes	1
2	botiga	comerci de barri	2
3	hospital	ambulatori	3
\.


--
-- Data for Name: tipus_inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipus_inmoble (id_tipusinmoble, nom, descripcio) FROM stdin;
1	vivenda	vivenda de persones
2	comerci	local comercial
3	servei	servei public
\.


--
-- Data for Name: tipus_sol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipus_sol (id_tipussol, nom, descripcio) FROM stdin;
1	public	sol public
2	privat	sol privat
\.


--
-- Data for Name: us; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY us (id_us, nom, descripcio) FROM stdin;
1	vivenda	per construir vivendes
2	comerci	per construir comercis
3	servei	per construir serveis
\.


--
-- Name: cadastre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_pkey PRIMARY KEY (ref_cadastral, inmoble_id, propietari_id, sol_id, us_id, geolocalitzacio_id, fecha_id);


--
-- Name: fecha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fecha
    ADD CONSTRAINT fecha_pkey PRIMARY KEY (id_fecha);


--
-- Name: geolocalitzacio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY geolocalitzacio
    ADD CONSTRAINT geolocalitzacio_pkey PRIMARY KEY (id_geolocalitzacio);


--
-- Name: inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY inmoble
    ADD CONSTRAINT inmoble_pkey PRIMARY KEY (id_inmoble);


--
-- Name: propietari_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY propietari
    ADD CONSTRAINT propietari_pkey PRIMARY KEY (dni);


--
-- Name: sol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT sol_pkey PRIMARY KEY (id_sol);


--
-- Name: subtipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY subtipus_inmoble
    ADD CONSTRAINT subtipus_inmoble_pkey PRIMARY KEY (id_subtipus);


--
-- Name: tipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipus_inmoble
    ADD CONSTRAINT tipus_inmoble_pkey PRIMARY KEY (id_tipusinmoble);


--
-- Name: tipus_sol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipus_sol
    ADD CONSTRAINT tipus_sol_pkey PRIMARY KEY (id_tipussol);


--
-- Name: us_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY us
    ADD CONSTRAINT us_pkey PRIMARY KEY (id_us);


--
-- Name: cadastre_fecha_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_fecha_id_fkey FOREIGN KEY (fecha_id) REFERENCES fecha(id_fecha);


--
-- Name: cadastre_geolocalitzacio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_geolocalitzacio_id_fkey FOREIGN KEY (geolocalitzacio_id) REFERENCES geolocalitzacio(id_geolocalitzacio);


--
-- Name: cadastre_inmoble_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_inmoble_id_fkey FOREIGN KEY (inmoble_id) REFERENCES inmoble(id_inmoble);


--
-- Name: cadastre_propietari_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_propietari_id_fkey FOREIGN KEY (propietari_id) REFERENCES propietari(dni);


--
-- Name: cadastre_sol_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_sol_id_fkey FOREIGN KEY (sol_id) REFERENCES sol(id_sol);


--
-- Name: cadastre_us_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT cadastre_us_id_fkey FOREIGN KEY (us_id) REFERENCES us(id_us);


--
-- Name: inmoble_subtipus_inmoble_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY inmoble
    ADD CONSTRAINT inmoble_subtipus_inmoble_fkey FOREIGN KEY (subtipus_inmoble) REFERENCES subtipus_inmoble(id_subtipus);


--
-- Name: sol_tipus_sol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT sol_tipus_sol_fkey FOREIGN KEY (tipus_sol) REFERENCES tipus_sol(id_tipussol);


--
-- Name: subtipus_inmoble_tipus_inmoble_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY subtipus_inmoble
    ADD CONSTRAINT subtipus_inmoble_tipus_inmoble_fkey FOREIGN KEY (tipus_inmoble) REFERENCES tipus_inmoble(id_tipusinmoble);


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

