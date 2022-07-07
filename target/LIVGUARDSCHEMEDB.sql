-- admin_user
CREATE TABLE public.admin_user
(
    id SERIAL NOT NULL PRIMARY KEY,
    role character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    emp_code character varying(255) COLLATE pg_catalog."default",
    entry_date timestamp without time zone,
    msisdn character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default"
);





--api_batterymodelseligiblescheme
CREATE TABLE public.api_batterymodelseligiblescheme
(
    id SERIAL NOT NULL PRIMARY KEY,
    product_name character varying(256) COLLATE pg_catalog."default",
    brand_name character varying(256) COLLATE pg_catalog."default",
    range character varying(256) COLLATE pg_catalog."default",
    product_desc character varying(256) COLLATE pg_catalog."default",
    loyalty_points character varying(256) COLLATE pg_catalog."default",
    battery_scheme_id integer
);



--api_batteryscheme
CREATE TABLE public.api_batteryscheme
(
    id SERIAL NOT NULL PRIMARY KEY,
    scheme_name character varying(100) COLLATE pg_catalog."default",
    scheme_detail character varying(256) COLLATE pg_catalog."default",
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone,
    conversion_ratio double precision NOT NULL,
    is_manual character varying(255) COLLATE pg_catalog."default" NOT NULL,
    end_timestamp timestamp with time zone,
    start_timestamp timestamp with time zone,
    scheme_scandate date
);



--api_dealerproduct
CREATE TABLE public.api_dealerproduct
(
    id SERIAL NOT NULL PRIMARY KEY,
    unique_code character varying(256) COLLATE pg_catalog."default" NOT NULL,
    comment character varying(256) COLLATE pg_catalog."default",
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone,
    product_id integer,
    user_id integer NOT NULL,
    serial_number character varying(256) COLLATE pg_catalog."default" NOT NULL,
    offer_id integer,
    distributor_name character varying(256) COLLATE pg_catalog."default",
    distributor_code bigint
);




--api_specialserialno
CREATE TABLE public.api_specialserialno
(
    id SERIAL NOT NULL PRIMARY KEY,
    serial_number character varying(256) COLLATE pg_catalog."default" NOT NULL,
    entry_date timestamp without time zone,
    status character varying(255) COLLATE pg_catalog."default"
);



--api_userdetail
CREATE TABLE public.api_userdetail
(
    id SERIAL NOT NULL PRIMARY KEY,
    phone bigint NOT NULL,
    address character varying(256) COLLATE pg_catalog."default",
    dealership_name character varying(256) COLLATE pg_catalog."default",
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone,
    user_id integer NOT NULL,
    verification_otp character varying(256) COLLATE pg_catalog."default",
    verification_status character varying(32) COLLATE pg_catalog."default" NOT NULL,
    large_image character varying(256) COLLATE pg_catalog."default",
    small_image character varying(256) COLLATE pg_catalog."default",
    total_loyalty integer NOT NULL,
    salespersonname character varying(100) COLLATE pg_catalog."default",
    city character varying(256) COLLATE pg_catalog."default",
    pincode character varying(20) COLLATE pg_catalog."default",
    salespersoncode character varying(50) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    distributor_code character varying(256) COLLATE pg_catalog."default",
    distributor_name character varying(256) COLLATE pg_catalog."default",
    type integer NOT NULL,
    distributor_zone character varying(256) COLLATE pg_catalog."default",
    erick_loyalty integer NOT NULL DEFAULT 0,
    total_loyalty_tertiary integer DEFAULT 0,
    erick_tert_loyalty integer DEFAULT 0,
    joining_bonus integer,
    ibups_sec_loyalty numeric DEFAULT 0,
    fourw_sec_loyalty numeric DEFAULT 0,
    CONSTRAINT uk_igbh4y8o9tlibneyiot7toldn UNIQUE (user_id),
    CONSTRAINT fkxxri4b1ww10t14b3h88q928j FOREIGN KEY (user_id)
        REFERENCES public.auth_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--auth_user
CREATE TABLE public.auth_user
(
    id SERIAL NOT NULL PRIMARY KEY,
    password character varying(128) COLLATE pg_catalog."default" NOT NULL,
    last_login timestamp with time zone,
    is_superuser boolean NOT NULL,
    username character varying(150) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(254) COLLATE pg_catalog."default" NOT NULL,
    is_staff boolean NOT NULL,
    is_active boolean NOT NULL,
    date_joined timestamp with time zone NOT NULL
);


--coupon_table
CREATE TABLE public.coupon_table
(
    username character varying(256) COLLATE pg_catalog."default",
    coupon_text character varying(256) COLLATE pg_catalog."default",
    redeem_status character varying(256) COLLATE pg_catalog."default",
    coupon_status character varying(255) COLLATE pg_catalog."default",
    coupon_scratch_date timestamp with time zone,
    created_timestamp timestamp with time zone,
    user_id integer,
    id SERIAL NOT NULL PRIMARY KEY
);


--detailproductloyalty_tbl
CREATE TABLE public.detailproductloyalty_tbl
(
    id SERIAL NOT NULL PRIMARY KEY,
    vehicle_manufacturer character varying(256) COLLATE pg_catalog."default" NOT NULL,
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone,
    segment character varying COLLATE pg_catalog."default",
    vehicle_model character varying(256) COLLATE pg_catalog."default",
    fuel character varying COLLATE pg_catalog."default",
    capacity numeric,
    livguard_brand character varying COLLATE pg_catalog."default",
    battery_model character varying COLLATE pg_catalog."default",
    warranty_month character varying COLLATE pg_catalog."default",
    range character varying COLLATE pg_catalog."default",
    points numeric,
    state character varying COLLATE pg_catalog."default",
    scheme_id numeric,
    without_otp_point numeric DEFAULT 0
);


--monthly_slabs
CREATE TABLE public.monthly_slabs
(
    id SERIAL NOT NULL PRIMARY KEY,
    loyalty_point integer NOT NULL,
    is_active boolean NOT NULL,
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone NOT NULL,
    battery_scheme_id integer NOT NULL,
    redeem_desc character varying(256) COLLATE pg_catalog."default"
);



--productwarranty_tbl
CREATE TABLE public.productwarranty_tbl
(
    id SERIAL NOT NULL PRIMARY KEY,
    customer_name character varying(256) COLLATE pg_catalog."default" NOT NULL,
    customer_phone bigint NOT NULL,
    vehicle_number character varying(256) COLLATE pg_catalog."default",
    created_timestamp timestamp with time zone NOT NULL,
    updated_timestamp timestamp with time zone,
    vehicle_model_id integer,
    large_image character varying(256) COLLATE pg_catalog."default",
    small_image character varying(256) COLLATE pg_catalog."default",
    warranty character varying(20) COLLATE pg_catalog."default",
    car_segment_id integer,
    vehicle_manufacturer_id integer,
    serial_number character varying COLLATE pg_catalog."default" NOT NULL,
    loyalty_points bigint,
    user_id numeric,
    dealer_product character varying(256) COLLATE pg_catalog."default",
    sell_date character varying COLLATE pg_catalog."default",
    pincode character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    state character varying COLLATE pg_catalog."default",
    distributor_code character varying COLLATE pg_catalog."default",
    distributor_name character varying COLLATE pg_catalog."default",
    product_cat character varying COLLATE pg_catalog."default",
    exchange_qwicksilver integer DEFAULT 0,
    with_otp boolean,
    rec_id bigint NOT NULL
);


--statewise_secondary
CREATE TABLE public.statewise_secondary
(
    state character varying COLLATE pg_catalog."default",
    ib_ups_category integer,
    fourw_category integer,
    erick_category integer,
    id SERIAL NOT NULL PRIMARY KEY
);


--statewise_tertiary
CREATE TABLE public.statewise_tertiary
(
    state character varying COLLATE pg_catalog."default",
    ib_ups_category integer,
    fourw_category integer,
    erick_category integer,
    id SERIAL NOT NULL PRIMARY KEY
);


