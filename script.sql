--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    aut_id integer NOT NULL,
    aut_nome character varying(40),
    aut_nacionalidade character varying(30)
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- Name: autor_aut_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autor_aut_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autor_aut_id_seq OWNER TO postgres;

--
-- Name: autor_aut_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autor_aut_id_seq OWNED BY public.autor.aut_id;


--
-- Name: capitulo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.capitulo (
    cap_id integer NOT NULL,
    cap_numero integer,
    cap_titulo character varying(40),
    liv_id integer
);


ALTER TABLE public.capitulo OWNER TO postgres;

--
-- Name: capitulo_cap_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.capitulo_cap_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.capitulo_cap_id_seq OWNER TO postgres;

--
-- Name: capitulo_cap_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.capitulo_cap_id_seq OWNED BY public.capitulo.cap_id;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cli_id integer NOT NULL,
    cli_nome character varying(40)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_cli_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_cli_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_cli_id_seq OWNER TO postgres;

--
-- Name: cliente_cli_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_cli_id_seq OWNED BY public.cliente.cli_id;


--
-- Name: editora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editora (
    edi_id integer NOT NULL,
    edi_nome character varying(25),
    edi_local character varying(20)
);


ALTER TABLE public.editora OWNER TO postgres;

--
-- Name: editora_edi_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.editora_edi_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.editora_edi_id_seq OWNER TO postgres;

--
-- Name: editora_edi_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.editora_edi_id_seq OWNED BY public.editora.edi_id;


--
-- Name: emprestimo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprestimo (
    emp_id integer NOT NULL,
    emp_data date,
    cli_id integer,
    emp_status boolean
);


ALTER TABLE public.emprestimo OWNER TO postgres;

--
-- Name: emprestimo_emp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprestimo_emp_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.emprestimo_emp_id_seq OWNER TO postgres;

--
-- Name: emprestimo_emp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprestimo_emp_id_seq OWNED BY public.emprestimo.emp_id;


--
-- Name: emprestimo_livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprestimo_livro (
    el_id integer NOT NULL,
    emp_id integer,
    liv_id integer,
    el_dias integer
);


ALTER TABLE public.emprestimo_livro OWNER TO postgres;

--
-- Name: emprestimo_livro_el_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprestimo_livro_el_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.emprestimo_livro_el_id_seq OWNER TO postgres;

--
-- Name: emprestimo_livro_el_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprestimo_livro_el_id_seq OWNED BY public.emprestimo_livro.el_id;


--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    liv_id integer NOT NULL,
    liv_titulo character varying(30),
    edi_id integer
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- Name: livro_autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro_autor (
    la_id integer NOT NULL,
    liv_id integer,
    aut_id integer
);


ALTER TABLE public.livro_autor OWNER TO postgres;

--
-- Name: livro_autor_la_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_autor_la_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_autor_la_id_seq OWNER TO postgres;

--
-- Name: livro_autor_la_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_autor_la_id_seq OWNED BY public.livro_autor.la_id;


--
-- Name: livro_liv_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_liv_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_liv_id_seq OWNER TO postgres;

--
-- Name: livro_liv_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_liv_id_seq OWNED BY public.livro.liv_id;


--
-- Name: autor aut_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor ALTER COLUMN aut_id SET DEFAULT nextval('public.autor_aut_id_seq'::regclass);


--
-- Name: capitulo cap_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capitulo ALTER COLUMN cap_id SET DEFAULT nextval('public.capitulo_cap_id_seq'::regclass);


--
-- Name: cliente cli_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cli_id SET DEFAULT nextval('public.cliente_cli_id_seq'::regclass);


--
-- Name: editora edi_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editora ALTER COLUMN edi_id SET DEFAULT nextval('public.editora_edi_id_seq'::regclass);


--
-- Name: emprestimo emp_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo ALTER COLUMN emp_id SET DEFAULT nextval('public.emprestimo_emp_id_seq'::regclass);


--
-- Name: emprestimo_livro el_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo_livro ALTER COLUMN el_id SET DEFAULT nextval('public.emprestimo_livro_el_id_seq'::regclass);


--
-- Name: livro liv_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro ALTER COLUMN liv_id SET DEFAULT nextval('public.livro_liv_id_seq'::regclass);


--
-- Name: livro_autor la_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor ALTER COLUMN la_id SET DEFAULT nextval('public.livro_autor_la_id_seq'::regclass);


--
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.autor VALUES (1, 'Herbert Schildt', 'americana');
INSERT INTO public.autor VALUES (2, 'Jose Deitel', 'americana');
INSERT INTO public.autor VALUES (3, 'Francisco Deitel', NULL);


--
-- Data for Name: capitulo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.capitulo VALUES (1, 1, 'Introdução', 1);
INSERT INTO public.capitulo VALUES (2, 2, 'Capitulo Inicial', 1);
INSERT INTO public.capitulo VALUES (3, 3, 'Referencias', 1);


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente VALUES (1, 'Geraldo');
INSERT INTO public.cliente VALUES (2, 'Gabryelli');


--
-- Data for Name: editora; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.editora VALUES (1, 'cultura', 'São Paulo');
INSERT INTO public.editora VALUES (2, 'Makron Books', 'New York');
INSERT INTO public.editora VALUES (3, 'Pearson', 'Rio de Janeiro');


--
-- Data for Name: emprestimo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.emprestimo VALUES (1, '2023-10-18', 1, false);


--
-- Data for Name: emprestimo_livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.emprestimo_livro VALUES (1, 1, 1, 10);
INSERT INTO public.emprestimo_livro VALUES (2, 1, 2, 8);


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livro VALUES (1, 'Java: Como Programar', 3);
INSERT INTO public.livro VALUES (2, 'Programando em C++', 2);
INSERT INTO public.livro VALUES (4, 'Aprendendo java em 21 dias', 2);
INSERT INTO public.livro VALUES (5, 'Dominando Java Script', 2);


--
-- Data for Name: livro_autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livro_autor VALUES (1, 1, 2);
INSERT INTO public.livro_autor VALUES (2, 1, 3);
INSERT INTO public.livro_autor VALUES (3, 2, 1);


--
-- Name: autor_aut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autor_aut_id_seq', 3, true);


--
-- Name: capitulo_cap_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.capitulo_cap_id_seq', 3, true);


--
-- Name: cliente_cli_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cli_id_seq', 2, true);


--
-- Name: editora_edi_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.editora_edi_id_seq', 3, true);


--
-- Name: emprestimo_emp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprestimo_emp_id_seq', 1, true);


--
-- Name: emprestimo_livro_el_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprestimo_livro_el_id_seq', 2, true);


--
-- Name: livro_autor_la_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_autor_la_id_seq', 3, true);


--
-- Name: livro_liv_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_liv_id_seq', 5, true);


--
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (aut_id);


--
-- Name: capitulo capitulo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capitulo
    ADD CONSTRAINT capitulo_pkey PRIMARY KEY (cap_id);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cli_id);


--
-- Name: editora editora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editora
    ADD CONSTRAINT editora_pkey PRIMARY KEY (edi_id);


--
-- Name: emprestimo_livro emprestimo_livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo_livro
    ADD CONSTRAINT emprestimo_livro_pkey PRIMARY KEY (el_id);


--
-- Name: emprestimo emprestimo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (emp_id);


--
-- Name: livro_autor livro_autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_pkey PRIMARY KEY (la_id);


--
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (liv_id);


--
-- Name: emprestimo emprestimo_cli_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_cli_id_fkey FOREIGN KEY (cli_id) REFERENCES public.cliente(cli_id) NOT VALID;


--
-- Name: emprestimo_livro emprestimo_livro_emp_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo_livro
    ADD CONSTRAINT emprestimo_livro_emp_id_fkey FOREIGN KEY (emp_id) REFERENCES public.emprestimo(emp_id);


--
-- Name: emprestimo_livro emprestimo_livro_liv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo_livro
    ADD CONSTRAINT emprestimo_livro_liv_id_fkey FOREIGN KEY (liv_id) REFERENCES public.livro(liv_id);


--
-- Name: livro_autor livro_autor_aut_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_aut_id_fkey FOREIGN KEY (aut_id) REFERENCES public.autor(aut_id) NOT VALID;


--
-- Name: livro_autor livro_autor_liv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_liv_id_fkey FOREIGN KEY (liv_id) REFERENCES public.livro(liv_id) NOT VALID;


--
-- Name: livro livro_edi_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_edi_id_fkey FOREIGN KEY (edi_id) REFERENCES public.editora(edi_id) NOT VALID;


--
-- PostgreSQL database dump complete
--

