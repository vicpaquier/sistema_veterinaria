PGDMP     "    /                {            jveterinariaDB    13.10    13.10 N               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16568    jveterinariaDB    DATABASE     l   CREATE DATABASE "jveterinariaDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
     DROP DATABASE "jveterinariaDB";
                postgres    false            �            1259    16569    agendamientos    TABLE     �   CREATE TABLE public.agendamientos (
    idagendamiento integer NOT NULL,
    fecha_agendamiento timestamp without time zone,
    idcliente integer,
    idempleado integer,
    idestadoagendamiento integer
);
 !   DROP TABLE public.agendamientos;
       public         heap    postgres    false            �            1259    16572     agendamientos_idagendamiento_seq    SEQUENCE     �   CREATE SEQUENCE public.agendamientos_idagendamiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.agendamientos_idagendamiento_seq;
       public          postgres    false    200                       0    0     agendamientos_idagendamiento_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.agendamientos_idagendamiento_seq OWNED BY public.agendamientos.idagendamiento;
          public          postgres    false    201            �            1259    16574    clientes    TABLE       CREATE TABLE public.clientes (
    idcliente integer NOT NULL,
    nombre_cliente character varying(45),
    apellido_cliente character varying(45),
    celular_cliente character varying(45),
    direccion_cliente character varying(45),
    ruc_cliente character varying(45)
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            �            1259    16577    clientes_idcliente_seq    SEQUENCE        CREATE SEQUENCE public.clientes_idcliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.clientes_idcliente_seq;
       public          postgres    false    202                       0    0    clientes_idcliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.clientes_idcliente_seq OWNED BY public.clientes.idcliente;
          public          postgres    false    203            �            1259    16579    detallefacturacion    TABLE     �   CREATE TABLE public.detallefacturacion (
    cantidad_detallefacturacion integer,
    idservicio integer,
    idfacturacion integer,
    iddetallefacturacion integer NOT NULL
);
 &   DROP TABLE public.detallefacturacion;
       public         heap    postgres    false            �            1259    16582 +   detallefacturacion_iddetallefacturacion_seq    SEQUENCE     �   CREATE SEQUENCE public.detallefacturacion_iddetallefacturacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 B   DROP SEQUENCE public.detallefacturacion_iddetallefacturacion_seq;
       public          postgres    false    204                       0    0 +   detallefacturacion_iddetallefacturacion_seq    SEQUENCE OWNED BY     {   ALTER SEQUENCE public.detallefacturacion_iddetallefacturacion_seq OWNED BY public.detallefacturacion.iddetallefacturacion;
          public          postgres    false    205            �            1259    16584 	   empleados    TABLE     �   CREATE TABLE public.empleados (
    idempleado integer NOT NULL,
    nombre_empleado character varying(45),
    apellido_empleado character varying(45),
    ruc_empleado character varying(35),
    celular_empleado character varying(30)
);
    DROP TABLE public.empleados;
       public         heap    postgres    false                       0    0    COLUMN empleados.ruc_empleado    COMMENT     8   COMMENT ON COLUMN public.empleados.ruc_empleado IS '
';
          public          postgres    false    206            �            1259    16587    empleados_idempleado_seq    SEQUENCE     �   CREATE SEQUENCE public.empleados_idempleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.empleados_idempleado_seq;
       public          postgres    false    206                       0    0    empleados_idempleado_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.empleados_idempleado_seq OWNED BY public.empleados.idempleado;
          public          postgres    false    207            �            1259    16589    estadoagendamiento    TABLE     �   CREATE TABLE public.estadoagendamiento (
    idestado_agendamiento integer NOT NULL,
    descripcion_estadoagendamiento character varying(9)
);
 &   DROP TABLE public.estadoagendamiento;
       public         heap    postgres    false            �            1259    16592 ,   estadoagendamiento_idestado_agendamiento_seq    SEQUENCE     �   CREATE SEQUENCE public.estadoagendamiento_idestado_agendamiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 C   DROP SEQUENCE public.estadoagendamiento_idestado_agendamiento_seq;
       public          postgres    false    208                       0    0 ,   estadoagendamiento_idestado_agendamiento_seq    SEQUENCE OWNED BY     }   ALTER SEQUENCE public.estadoagendamiento_idestado_agendamiento_seq OWNED BY public.estadoagendamiento.idestado_agendamiento;
          public          postgres    false    209            �            1259    16594    facturacion    TABLE       CREATE TABLE public.facturacion (
    idfacturacion integer NOT NULL,
    idusuario integer,
    idcliente integer,
    condicion_facturacion character varying(30),
    fecha_facturacion date,
    numero_facturacion character varying(45),
    estado_facturacion character varying(30)
);
    DROP TABLE public.facturacion;
       public         heap    postgres    false            �            1259    16597    facturacion_idfacturacion_seq    SEQUENCE     �   CREATE SEQUENCE public.facturacion_idfacturacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.facturacion_idfacturacion_seq;
       public          postgres    false    210                       0    0    facturacion_idfacturacion_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.facturacion_idfacturacion_seq OWNED BY public.facturacion.idfacturacion;
          public          postgres    false    211            �            1259    16599    mascotas    TABLE     $  CREATE TABLE public.mascotas (
    nombre_mascota character varying(45),
    especie_mascota character varying(45),
    raza_mascota character varying(45),
    colorpelo_mascota character varying(45),
    fechanacimiento_mascota date,
    idcliente integer,
    idmascota integer NOT NULL
);
    DROP TABLE public.mascotas;
       public         heap    postgres    false            �            1259    16602    mascotas_idmascota_seq    SEQUENCE        CREATE SEQUENCE public.mascotas_idmascota_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.mascotas_idmascota_seq;
       public          postgres    false    212                       0    0    mascotas_idmascota_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.mascotas_idmascota_seq OWNED BY public.mascotas.idmascota;
          public          postgres    false    213            �            1259    16604 	   servicios    TABLE     �   CREATE TABLE public.servicios (
    idservicio integer NOT NULL,
    descripcion_servicio character varying(45),
    precio_servicio integer,
    iva_servicio integer
);
    DROP TABLE public.servicios;
       public         heap    postgres    false            �            1259    16607    servicios_idservicio_seq    SEQUENCE     �   CREATE SEQUENCE public.servicios_idservicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.servicios_idservicio_seq;
       public          postgres    false    214                       0    0    servicios_idservicio_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.servicios_idservicio_seq OWNED BY public.servicios.idservicio;
          public          postgres    false    215            �            1259    16609    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    idusuario integer NOT NULL,
    tipo_usuario character varying(20),
    contra_usuario character varying(32),
    empleados_idempleados_fk integer,
    login_usuario character varying(25)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false                       0    0    COLUMN usuarios.idusuario    COMMENT     4   COMMENT ON COLUMN public.usuarios.idusuario IS '
';
          public          postgres    false    216            �            1259    16612    usuarios_idusuario_seq    SEQUENCE        CREATE SEQUENCE public.usuarios_idusuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuarios_idusuario_seq;
       public          postgres    false    216                       0    0    usuarios_idusuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuarios_idusuario_seq OWNED BY public.usuarios.idusuario;
          public          postgres    false    217            R           2604    16614    agendamientos idagendamiento    DEFAULT     �   ALTER TABLE ONLY public.agendamientos ALTER COLUMN idagendamiento SET DEFAULT nextval('public.agendamientos_idagendamiento_seq'::regclass);
 K   ALTER TABLE public.agendamientos ALTER COLUMN idagendamiento DROP DEFAULT;
       public          postgres    false    201    200            S           2604    16615    clientes idcliente    DEFAULT     x   ALTER TABLE ONLY public.clientes ALTER COLUMN idcliente SET DEFAULT nextval('public.clientes_idcliente_seq'::regclass);
 A   ALTER TABLE public.clientes ALTER COLUMN idcliente DROP DEFAULT;
       public          postgres    false    203    202            T           2604    16616 '   detallefacturacion iddetallefacturacion    DEFAULT     �   ALTER TABLE ONLY public.detallefacturacion ALTER COLUMN iddetallefacturacion SET DEFAULT nextval('public.detallefacturacion_iddetallefacturacion_seq'::regclass);
 V   ALTER TABLE public.detallefacturacion ALTER COLUMN iddetallefacturacion DROP DEFAULT;
       public          postgres    false    205    204            U           2604    16617    empleados idempleado    DEFAULT     |   ALTER TABLE ONLY public.empleados ALTER COLUMN idempleado SET DEFAULT nextval('public.empleados_idempleado_seq'::regclass);
 C   ALTER TABLE public.empleados ALTER COLUMN idempleado DROP DEFAULT;
       public          postgres    false    207    206            V           2604    16618 (   estadoagendamiento idestado_agendamiento    DEFAULT     �   ALTER TABLE ONLY public.estadoagendamiento ALTER COLUMN idestado_agendamiento SET DEFAULT nextval('public.estadoagendamiento_idestado_agendamiento_seq'::regclass);
 W   ALTER TABLE public.estadoagendamiento ALTER COLUMN idestado_agendamiento DROP DEFAULT;
       public          postgres    false    209    208            W           2604    16619    facturacion idfacturacion    DEFAULT     �   ALTER TABLE ONLY public.facturacion ALTER COLUMN idfacturacion SET DEFAULT nextval('public.facturacion_idfacturacion_seq'::regclass);
 H   ALTER TABLE public.facturacion ALTER COLUMN idfacturacion DROP DEFAULT;
       public          postgres    false    211    210            X           2604    16620    mascotas idmascota    DEFAULT     x   ALTER TABLE ONLY public.mascotas ALTER COLUMN idmascota SET DEFAULT nextval('public.mascotas_idmascota_seq'::regclass);
 A   ALTER TABLE public.mascotas ALTER COLUMN idmascota DROP DEFAULT;
       public          postgres    false    213    212            Y           2604    16621    servicios idservicio    DEFAULT     |   ALTER TABLE ONLY public.servicios ALTER COLUMN idservicio SET DEFAULT nextval('public.servicios_idservicio_seq'::regclass);
 C   ALTER TABLE public.servicios ALTER COLUMN idservicio DROP DEFAULT;
       public          postgres    false    215    214            Z           2604    16622    usuarios idusuario    DEFAULT     x   ALTER TABLE ONLY public.usuarios ALTER COLUMN idusuario SET DEFAULT nextval('public.usuarios_idusuario_seq'::regclass);
 A   ALTER TABLE public.usuarios ALTER COLUMN idusuario DROP DEFAULT;
       public          postgres    false    217    216            �          0    16569    agendamientos 
   TABLE DATA           x   COPY public.agendamientos (idagendamiento, fecha_agendamiento, idcliente, idempleado, idestadoagendamiento) FROM stdin;
    public          postgres    false    200   ma       �          0    16574    clientes 
   TABLE DATA           �   COPY public.clientes (idcliente, nombre_cliente, apellido_cliente, celular_cliente, direccion_cliente, ruc_cliente) FROM stdin;
    public          postgres    false    202   �a       �          0    16579    detallefacturacion 
   TABLE DATA           z   COPY public.detallefacturacion (cantidad_detallefacturacion, idservicio, idfacturacion, iddetallefacturacion) FROM stdin;
    public          postgres    false    204   �b       �          0    16584 	   empleados 
   TABLE DATA           s   COPY public.empleados (idempleado, nombre_empleado, apellido_empleado, ruc_empleado, celular_empleado) FROM stdin;
    public          postgres    false    206   �b                  0    16589    estadoagendamiento 
   TABLE DATA           c   COPY public.estadoagendamiento (idestado_agendamiento, descripcion_estadoagendamiento) FROM stdin;
    public          postgres    false    208   bc                 0    16594    facturacion 
   TABLE DATA           �   COPY public.facturacion (idfacturacion, idusuario, idcliente, condicion_facturacion, fecha_facturacion, numero_facturacion, estado_facturacion) FROM stdin;
    public          postgres    false    210   �c                 0    16599    mascotas 
   TABLE DATA           �   COPY public.mascotas (nombre_mascota, especie_mascota, raza_mascota, colorpelo_mascota, fechanacimiento_mascota, idcliente, idmascota) FROM stdin;
    public          postgres    false    212   d                 0    16604 	   servicios 
   TABLE DATA           d   COPY public.servicios (idservicio, descripcion_servicio, precio_servicio, iva_servicio) FROM stdin;
    public          postgres    false    214   }d                 0    16609    usuarios 
   TABLE DATA           t   COPY public.usuarios (idusuario, tipo_usuario, contra_usuario, empleados_idempleados_fk, login_usuario) FROM stdin;
    public          postgres    false    216   �d                  0    0     agendamientos_idagendamiento_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.agendamientos_idagendamiento_seq', 9, true);
          public          postgres    false    201                       0    0    clientes_idcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.clientes_idcliente_seq', 2, true);
          public          postgres    false    203                       0    0 +   detallefacturacion_iddetallefacturacion_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.detallefacturacion_iddetallefacturacion_seq', 14, true);
          public          postgres    false    205                       0    0    empleados_idempleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.empleados_idempleado_seq', 4, true);
          public          postgres    false    207                       0    0 ,   estadoagendamiento_idestado_agendamiento_seq    SEQUENCE SET     [   SELECT pg_catalog.setval('public.estadoagendamiento_idestado_agendamiento_seq', 1, false);
          public          postgres    false    209                        0    0    facturacion_idfacturacion_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.facturacion_idfacturacion_seq', 50, true);
          public          postgres    false    211            !           0    0    mascotas_idmascota_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.mascotas_idmascota_seq', 1, false);
          public          postgres    false    213            "           0    0    servicios_idservicio_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.servicios_idservicio_seq', 9, true);
          public          postgres    false    215            #           0    0    usuarios_idusuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuarios_idusuario_seq', 1, false);
          public          postgres    false    217            b           2606    16624 !   empleados empleados_idempleado_pk 
   CONSTRAINT     g   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_idempleado_pk PRIMARY KEY (idempleado);
 K   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_idempleado_pk;
       public            postgres    false    206            f           2606    16626 (   facturacion facturacion_idfacturacion_pk 
   CONSTRAINT     q   ALTER TABLE ONLY public.facturacion
    ADD CONSTRAINT facturacion_idfacturacion_pk PRIMARY KEY (idfacturacion);
 R   ALTER TABLE ONLY public.facturacion DROP CONSTRAINT facturacion_idfacturacion_pk;
       public            postgres    false    210            \           2606    16628    agendamientos idagendamiento 
   CONSTRAINT     f   ALTER TABLE ONLY public.agendamientos
    ADD CONSTRAINT idagendamiento PRIMARY KEY (idagendamiento);
 F   ALTER TABLE ONLY public.agendamientos DROP CONSTRAINT idagendamiento;
       public            postgres    false    200            ^           2606    16630    clientes idcliente_PK 
   CONSTRAINT     \   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT "idcliente_PK" PRIMARY KEY (idcliente);
 A   ALTER TABLE ONLY public.clientes DROP CONSTRAINT "idcliente_PK";
       public            postgres    false    202            `           2606    16632 *   detallefacturacion iddetallefacturacion_pk 
   CONSTRAINT     z   ALTER TABLE ONLY public.detallefacturacion
    ADD CONSTRAINT iddetallefacturacion_pk PRIMARY KEY (iddetallefacturacion);
 T   ALTER TABLE ONLY public.detallefacturacion DROP CONSTRAINT iddetallefacturacion_pk;
       public            postgres    false    204            d           2606    16634    estadoagendamiento idestado 
   CONSTRAINT     l   ALTER TABLE ONLY public.estadoagendamiento
    ADD CONSTRAINT idestado PRIMARY KEY (idestado_agendamiento);
 E   ALTER TABLE ONLY public.estadoagendamiento DROP CONSTRAINT idestado;
       public            postgres    false    208            h           2606    16636    mascotas idmascota_PK 
   CONSTRAINT     \   ALTER TABLE ONLY public.mascotas
    ADD CONSTRAINT "idmascota_PK" PRIMARY KEY (idmascota);
 A   ALTER TABLE ONLY public.mascotas DROP CONSTRAINT "idmascota_PK";
       public            postgres    false    212            j           2606    16638    servicios idservicio_PK 
   CONSTRAINT     _   ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT "idservicio_PK" PRIMARY KEY (idservicio);
 C   ALTER TABLE ONLY public.servicios DROP CONSTRAINT "idservicio_PK";
       public            postgres    false    214            l           2606    16640    usuarios usuarios_idusuario_pk 
   CONSTRAINT     c   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_idusuario_pk PRIMARY KEY (idusuario);
 H   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_idusuario_pk;
       public            postgres    false    216            m           2606    16641 "   agendamientos cliente_idcliente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamientos
    ADD CONSTRAINT cliente_idcliente_fk FOREIGN KEY (idcliente) REFERENCES public.clientes(idcliente);
 L   ALTER TABLE ONLY public.agendamientos DROP CONSTRAINT cliente_idcliente_fk;
       public          postgres    false    202    2910    200            t           2606    16646    mascotas clientes_idcliente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.mascotas
    ADD CONSTRAINT clientes_idcliente_fk FOREIGN KEY (idcliente) REFERENCES public.clientes(idcliente) ON UPDATE CASCADE ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.mascotas DROP CONSTRAINT clientes_idcliente_fk;
       public          postgres    false    2910    212    202            r           2606    16651 !   facturacion clientes_idcliente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.facturacion
    ADD CONSTRAINT clientes_idcliente_fk FOREIGN KEY (idcliente) REFERENCES public.clientes(idcliente);
 K   ALTER TABLE ONLY public.facturacion DROP CONSTRAINT clientes_idcliente_fk;
       public          postgres    false    2910    202    210            u           2606    16656     usuarios empleados_idempleado_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT empleados_idempleado_fk FOREIGN KEY (empleados_idempleados_fk) REFERENCES public.empleados(idempleado);
 J   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT empleados_idempleado_fk;
       public          postgres    false    206    216    2914            n           2606    16661 %   agendamientos empleados_idempleado_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamientos
    ADD CONSTRAINT empleados_idempleado_fk FOREIGN KEY (idempleado) REFERENCES public.empleados(idempleado);
 O   ALTER TABLE ONLY public.agendamientos DROP CONSTRAINT empleados_idempleado_fk;
       public          postgres    false    200    2914    206            p           2606    16666 /   detallefacturacion facturacion_idfacturacion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.detallefacturacion
    ADD CONSTRAINT facturacion_idfacturacion_fk FOREIGN KEY (idfacturacion) REFERENCES public.facturacion(idfacturacion);
 Y   ALTER TABLE ONLY public.detallefacturacion DROP CONSTRAINT facturacion_idfacturacion_fk;
       public          postgres    false    204    2918    210            o           2606    16671    agendamientos idestado_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamientos
    ADD CONSTRAINT idestado_fk FOREIGN KEY (idestadoagendamiento) REFERENCES public.estadoagendamiento(idestado_agendamiento);
 C   ALTER TABLE ONLY public.agendamientos DROP CONSTRAINT idestado_fk;
       public          postgres    false    200    2916    208            q           2606    16676 *   detallefacturacion servicios_idservicio_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.detallefacturacion
    ADD CONSTRAINT servicios_idservicio_fk FOREIGN KEY (idservicio) REFERENCES public.servicios(idservicio);
 T   ALTER TABLE ONLY public.detallefacturacion DROP CONSTRAINT servicios_idservicio_fk;
       public          postgres    false    2922    214    204            s           2606    16681 !   facturacion usuarios_idusuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.facturacion
    ADD CONSTRAINT usuarios_idusuario_fk FOREIGN KEY (idusuario) REFERENCES public.usuarios(idusuario);
 K   ALTER TABLE ONLY public.facturacion DROP CONSTRAINT usuarios_idusuario_fk;
       public          postgres    false    210    2924    216            �   n   x�m��� E�o����s!ZK��#h21��ߙ�$��gnc�؋$���@zv5�zFK��eC��0v�����X�ϥɰ\(遶��Y�9�"�Ω�,�D��BD;J�+*      �   �   x�uOA�0<'�IR���-��E�^���!�f������^#T�k���	,�Ծ�lĠ�p�C�u�9>�/JjC]�z/�@Lk�4ڱ�,�Q-3�Q���e:�\뀄i2"!�1�&����v�-̫Y���o�lgʶ�� ��9�a�A��{\R,�P�z�]�{D|�D��      �   4   x�%��	  ���L1b�b/�_�+{{� 4��Q���"-Aj��:�����$~      �   Z   x�3�,�L.�/�,H,,�L-�45560��Ե�4��44�4�4��2�L�I��,��242a.c���d�e�!b�Y����X�������� O.$�          -   x�3�p�s�t�q�2�s�s�t��2�q���s�c���� ���         l   x�}λ� й��mx�h���a���C��G�����a^S̭#�&�l���~K*1�Ғ2�#s-m��;���Kh�A$�Б}!�޳��t4���A)��]@I         R   x������LK������KM/��F����@�i�iĕX�������&��\IE�@�`I*���[bӎ�64����� Z"�         &   x�3�tJ<�1��� ���s~QI*�)����� �l!         i   x���1�@k�1ȷg����|BJ� ���)-��N1��8�os���}B��4�Q��b�ک�{�����_��Xzj���!����L���lV?�3 $\+     