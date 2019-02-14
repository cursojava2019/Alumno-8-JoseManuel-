
CREATE TABLE public.alumno (
    nombre character varying(100),
    apellido1 character varying(100),
    apellido2 character varying(100),
    nif character varying(9),
    telefono character varying(9),
    correo character varying(100),
    repetidor boolean NOT NULL,
    observaciones character varying(100),
    id bigint NOT NULL,
    fechaalta timestamp with time zone,
    fechabaja timestamp with time zone,
    responsable bigint
);


ALTER TABLE public.alumno OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16618)
-- Name: alumno_clase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumno_clase (
    id_alumno bigint NOT NULL,
    id_clase bigint NOT NULL
);


ALTER TABLE public.alumno_clase OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16548)
-- Name: alumno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alumno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumno_id_seq OWNER TO postgres;

--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 197
-- Name: alumno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumno_id_seq OWNED BY public.alumno.id;


--
-- TOC entry 210 (class 1259 OID 16645)
-- Name: asignatura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignatura (
    id bigint NOT NULL,
    nombre character varying(100) NOT NULL,
    id_curso bigint
);


ALTER TABLE public.asignatura OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16643)
-- Name: asignatura_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asignatura_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asignatura_id_seq OWNER TO postgres;

--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 209
-- Name: asignatura_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asignatura_id_seq OWNED BY public.asignatura.id;


--
-- TOC entry 207 (class 1259 OID 16612)
-- Name: clase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clase (
    id bigint NOT NULL,
    id_profesor bigint,
    id_tarifa bigint,
    id_asignatura bigint
);


ALTER TABLE public.clase OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16610)
-- Name: clase_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clase_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clase_id_seq OWNER TO postgres;

--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 206
-- Name: clase_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clase_id_seq OWNED BY public.clase.id;


--
-- TOC entry 201 (class 1259 OID 16581)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    id bigint NOT NULL,
    nivel character varying(50) NOT NULL,
    etapa character varying(50) NOT NULL
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16579)
-- Name: curso_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.curso_id_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 200
-- Name: curso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curso_id_seq OWNED BY public.curso.id;


--
-- TOC entry 198 (class 1259 OID 16561)
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    nombre character varying(100),
    apellido1 character varying(100),
    apellido2 character varying(100),
    nif character varying(9),
    telefono character varying(9),
    correo character varying(100),
    titulacion character varying(100),
    id bigint NOT NULL
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16568)
-- Name: profesor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesor_id_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 199
-- Name: profesor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesor_id_seq OWNED BY public.profesor.id;


--
-- TOC entry 203 (class 1259 OID 16595)
-- Name: responsable_alumno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsable_alumno (
    id bigint NOT NULL,
    nombre character varying(100),
    apellido1 character varying(100),
    apellido2 character varying(100),
    nif character varying(9),
    telefono character varying(20),
    correo character varying(100)
);


ALTER TABLE public.responsable_alumno OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16593)
-- Name: responsable_alumno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsable_alumno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsable_alumno_id_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 202
-- Name: responsable_alumno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.responsable_alumno_id_seq OWNED BY public.responsable_alumno.id;


--
-- TOC entry 205 (class 1259 OID 16603)
-- Name: tarifa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarifa (
    id bigint NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(200) NOT NULL,
    precio double precision NOT NULL
);


ALTER TABLE public.tarifa OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16601)
-- Name: tarifa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tarifa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarifa_id_seq OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 204
-- Name: tarifa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarifa_id_seq OWNED BY public.tarifa.id;


--
-- TOC entry 2727 (class 2604 OID 16550)
-- Name: alumno id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno ALTER COLUMN id SET DEFAULT nextval('public.alumno_id_seq'::regclass);


--
-- TOC entry 2733 (class 2604 OID 16648)
-- Name: asignatura id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura ALTER COLUMN id SET DEFAULT nextval('public.asignatura_id_seq'::regclass);


--
-- TOC entry 2732 (class 2604 OID 16615)
-- Name: clase id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clase ALTER COLUMN id SET DEFAULT nextval('public.clase_id_seq'::regclass);


--
-- TOC entry 2729 (class 2604 OID 16584)
-- Name: curso id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN id SET DEFAULT nextval('public.curso_id_seq'::regclass);


--
-- TOC entry 2728 (class 2604 OID 16570)
-- Name: profesor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor ALTER COLUMN id SET DEFAULT nextval('public.profesor_id_seq'::regclass);


--
-- TOC entry 2730 (class 2604 OID 16598)
-- Name: responsable_alumno id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsable_alumno ALTER COLUMN id SET DEFAULT nextval('public.responsable_alumno_id_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 16606)
-- Name: tarifa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifa ALTER COLUMN id SET DEFAULT nextval('public.tarifa_id_seq'::regclass);


--
-- TOC entry 2878 (class 0 OID 16542)
-- Dependencies: 196
-- Data for Name: alumno; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('Juan', 'Periquillo', 'Periquilli', '87654321X', '94654654', 'ddsf@sdfsd.es', false, 'sdfsdfsdafasd', 6, '2019-01-25 00:00:00+01', NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'MARTINEZ', 'Sanchez', '75108883Z', '678659183', 'dvdtello@gmail.com', false, '', 14, '2019-01-28 00:00:00+01', NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'RUIZ', 'Sanchez', '751TYYXXZ', '678659183', 'dvdtello@gmail.com', false, '', 15, '2019-01-28 00:00:00+01', NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'MARTINEZ', 'MARTINEZ', '75108883Z', '678659183', 'dvdtello@gmail.com', false, 'null', 2, NULL, NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('Perico', 'PErez', 'Perez', '754444444', '454654564', NULL, true, NULL, 16, NULL, NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'Tello', 'Sanchez', '75111111H', '678659183', 'dvdtello@gmail.com', false, '', 11, NULL, NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('Pepe', 'Jose', 'Jose', '98765432X', '954654654', 'aa@sds.es', false, 'sdfadsfas', 17, '2019-01-28 00:00:00+01', NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'Tello', 'Sanchez', '751TYYXXZ', '678659183', 'dvdtello@gmail.com', false, '', 13, '2019-01-28 00:00:00+01', NULL, NULL);
INSERT INTO public.alumno (nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, id, fechaalta, fechabaja, responsable) VALUES ('David', 'Tello', '', '75111311H', '6564654', 'correo@correo.es', true, '', 19, NULL, NULL, NULL);


--
-- TOC entry 2890 (class 0 OID 16618)
-- Dependencies: 208
-- Data for Name: alumno_clase; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2892 (class 0 OID 16645)
-- Dependencies: 210
-- Data for Name: asignatura; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2889 (class 0 OID 16612)
-- Dependencies: 207
-- Data for Name: clase; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2883 (class 0 OID 16581)
-- Dependencies: 201
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2880 (class 0 OID 16561)
-- Dependencies: 198
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2885 (class 0 OID 16595)
-- Dependencies: 203
-- Data for Name: responsable_alumno; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2887 (class 0 OID 16603)
-- Dependencies: 205
-- Data for Name: tarifa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 197
-- Name: alumno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumno_id_seq', 19, true);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 209
-- Name: asignatura_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asignatura_id_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 206
-- Name: clase_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clase_id_seq', 1, false);


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 200
-- Name: curso_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.curso_id_seq', 1, false);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 199
-- Name: profesor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesor_id_seq', 1, false);


--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 202
-- Name: responsable_alumno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.responsable_alumno_id_seq', 1, false);


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 204
-- Name: tarifa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarifa_id_seq', 1, false);


--
-- TOC entry 2735 (class 2606 OID 16558)
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (id);


--
-- TOC entry 2747 (class 2606 OID 16622)
-- Name: alumno_clase alumnoclase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno_clase
    ADD CONSTRAINT alumnoclase_pkey PRIMARY KEY (id_alumno, id_clase);


--
-- TOC entry 2749 (class 2606 OID 16650)
-- Name: asignatura asignatura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT asignatura_pkey PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 16617)
-- Name: clase clase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clase
    ADD CONSTRAINT clase_pkey PRIMARY KEY (id);


--
-- TOC entry 2739 (class 2606 OID 16586)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 16578)
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 16600)
-- Name: responsable_alumno responsable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsable_alumno
    ADD CONSTRAINT responsable_pkey PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 16608)
-- Name: tarifa tarifa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifa
    ADD CONSTRAINT tarifa_pkey PRIMARY KEY (id);


--
-- TOC entry 2754 (class 2606 OID 16623)
-- Name: alumno_clase alumno_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno_clase
    ADD CONSTRAINT alumno_fk FOREIGN KEY (id_alumno) REFERENCES public.alumno(id);


--
-- TOC entry 2756 (class 2606 OID 16651)
-- Name: asignatura asig_curso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT asig_curso_fk FOREIGN KEY (id) REFERENCES public.curso(id);


--
-- TOC entry 2753 (class 2606 OID 16656)
-- Name: clase asignatura_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clase
    ADD CONSTRAINT asignatura_fk FOREIGN KEY (id_asignatura) REFERENCES public.asignatura(id);


--
-- TOC entry 2755 (class 2606 OID 16628)
-- Name: alumno_clase clase_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno_clase
    ADD CONSTRAINT clase_fk FOREIGN KEY (id_clase) REFERENCES public.clase(id);


--
-- TOC entry 2752 (class 2606 OID 16638)
-- Name: clase curso_tarifa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clase
    ADD CONSTRAINT curso_tarifa_fk FOREIGN KEY (id_tarifa) REFERENCES public.tarifa(id);


--
-- TOC entry 2751 (class 2606 OID 16633)
-- Name: clase profesor_clase_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clase
    ADD CONSTRAINT profesor_clase_fk FOREIGN KEY (id_profesor) REFERENCES public.profesor(id);


--
-- TOC entry 2750 (class 2606 OID 16661)
-- Name: alumno responsable_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT responsable_key FOREIGN KEY (responsable) REFERENCES public.responsable_alumno(id);


-- Completed on 2019-02-08 17:44:43

--
-- PostgreSQL database dump complete
--

