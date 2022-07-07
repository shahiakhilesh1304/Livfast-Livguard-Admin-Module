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
    battery_scheme_id integer,
    brand_name character varying(255) COLLATE pg_catalog."default",
    loyalty_points integer,
    product_desc character varying(255) COLLATE pg_catalog."default",
    product_name character varying(255) COLLATE pg_catalog."default",
    range character varying(255) COLLATE pg_catalog."default"
);



--api_batteryscheme
CREATE TABLE public.api_batteryscheme
(
    id SERIAL NOT NULL PRIMARY KEY,
    conversion_ratio bigint,
    created_timestamp timestamp without time zone,
    end_timestamp date,
    is_manual character varying(255) COLLATE pg_catalog."default",
    scheme_detail character varying(255) COLLATE pg_catalog."default",
    scheme_name character varying(255) COLLATE pg_catalog."default",
    scheme_scandate date,
    start_timestamp date,
    updated_timestamp timestamp without time zone
);



--api_dealerproduct
CREATE TABLE public.api_dealerproduct
(
    id SERIAL NOT NULL PRIMARY KEY,
    comment character varying(255) COLLATE pg_catalog."default",
    created_timestamp timestamp without time zone,
    distributor_code integer,
    distributor_name character varying(255) COLLATE pg_catalog."default",
    offer_id character varying(255) COLLATE pg_catalog."default",
    product_id integer,
    serial_number character varying(255) COLLATE pg_catalog."default",
    unique_code character varying(255) COLLATE pg_catalog."default",
    updated_timestamp timestamp without time zone,
    user_id integer
);




--api_specialserialno
CREATE TABLE public.api_specialserialno
(
    id SERIAL NOT NULL PRIMARY KEY,
    entry_date timestamp without time zone,
    serial_number character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default"
);



--api_userdetail
CREATE TABLE public.api_userdetail
(
    id SERIAL NOT NULL PRIMARY KEY,
    large_image character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    pincode character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    created_timestamp timestamp without time zone,
    dealership_name character varying(255) COLLATE pg_catalog."default",
    distributor_code character varying(255) COLLATE pg_catalog."default",
    distributor_name character varying(255) COLLATE pg_catalog."default",
    distributor_zone character varying(255) COLLATE pg_catalog."default",
    erick_loyalty integer,
    erick_tert_loyalty integer,
    fourw_sec_loyalty integer,
    ibups_sec_loyalty integer,
    joining_bonus integer,
    phone character varying(255) COLLATE pg_catalog."default",
    salespersoncode character varying(255) COLLATE pg_catalog."default",
    salespersonname character varying(255) COLLATE pg_catalog."default",
    small_image character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    total_loyalty_tertiary integer,
    total_loyalty integer,
    type integer,
    updated_timestamp timestamp without time zone,
    verification_otp character varying(255) COLLATE pg_catalog."default",
    verification_status character varying(255) COLLATE pg_catalog."default",
    user_id integer NOT NULL,
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
       is_superuser timestamp without time zone,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    is_active boolean,
    is_staff boolean,
    last_login timestamp without time zone,
    last_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default"
);


--coupon_table
CREATE TABLE public.coupon_table
(
    coupon_status character varying(255) COLLATE pg_catalog."default",
    coupon_scratch_date timestamp without time zone,
    coupon_text character varying(255) COLLATE pg_catalog."default",
    created_timestamp timestamp without time zone,
    redeem_status character varying(255) COLLATE pg_catalog."default",
    user_id integer,
    username character varying(255) COLLATE pg_catalog."default"
    id SERIAL NOT NULL PRIMARY KEY
);


--detailproductloyalty_tbl
CREATE TABLE public.detailproductloyalty_tbl
(
    id SERIAL NOT NULL PRIMARY KEY,
    battery_model character varying(255) COLLATE pg_catalog."default",
    capacity integer,
    created_timestamp timestamp without time zone,
    fuel character varying(255) COLLATE pg_catalog."default",
    livguard_brand character varying(255) COLLATE pg_catalog."default",
    points integer,
    range character varying(255) COLLATE pg_catalog."default",
    scheme_id integer,
    segment character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    updated_timestamp timestamp without time zone,
    vehicle_manufacturer character varying(255) COLLATE pg_catalog."default",
    vehicle_model character varying(255) COLLATE pg_catalog."default",
    warranty_month character varying(255) COLLATE pg_catalog."default",
    without_otp_point integer
);


--monthly_slabs
CREATE TABLE public.monthly_slabs
(
    id SERIAL NOT NULL PRIMARY KEY,
     battery_scheme_id integer,
    created_timestamp timestamp without time zone,
    is_active boolean,
    loyalty_point integer,
    redeem_desc character varying(255) COLLATE pg_catalog."default",
    updated_timestamp timestamp without time zone
);



--productwarranty_tbl
CREATE TABLE public.productwarranty_tbl
(
    id SERIAL NOT NULL PRIMARY KEY,
    car_segment_id integer,
    city character varying(255) COLLATE pg_catalog."default",
    created_timestamp timestamp without time zone,
    customer_name character varying(255) COLLATE pg_catalog."default",
    dealer_product character varying(255) COLLATE pg_catalog."default",
    distributor_code character varying(255) COLLATE pg_catalog."default",
    distributor_name integer,
    exchange_qwicksilver integer,
    large_image character varying(255) COLLATE pg_catalog."default",
    loyalty_points integer,
    customer_phone character varying(255) COLLATE pg_catalog."default",
    pincode character varying(255) COLLATE pg_catalog."default",
    product_cat character varying(255) COLLATE pg_catalog."default",
    sell_date character varying(255) COLLATE pg_catalog."default",
    serial_number character varying(255) COLLATE pg_catalog."default",
    small_image character varying(255) COLLATE pg_catalog."default",
    state integer,
    updated_timestamp timestamp without time zone,
    user_id integer,
    vehicle_manufacturer_id integer,
    vehicle_model_id integer,
    vehicle_number character varying(255) COLLATE pg_catalog."default",
    warranty character varying(255) COLLATE pg_catalog."default",
    with_otp integer
);


--statewise_secondary
CREATE TABLE public.statewise_secondary
(
  	 erick_category integer,
    fourw_category integer,
    ib_ups_category integer,
    state character varying(255) COLLATE pg_catalog."default",
    id SERIAL NOT NULL PRIMARY KEY
);


--statewise_tertiary
CREATE TABLE public.statewise_tertiary
(
    erick_category integer,
    fourw_category integer,
    ib_ups_category integer,
    state character varying(255) COLLATE pg_catalog."default",
    id SERIAL NOT NULL PRIMARY KEY
);


