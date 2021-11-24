CREATE TABLE address
(
    "id"     bigserial   NOT NULL,
    town     varchar(50) NOT NULL,
    street   varchar(50) NOT NULL,
    building bigint      NOT NULL,
    CONSTRAINT PK_12 PRIMARY KEY ("id")
);

CREATE TABLE client
(
    "id"         bigserial          NOT NULL,
    name         varchar(50)        NOT NULL,
    last_name    varchar(50)        NOT NULL,
    email        varchar(50) unique NOT NULL,
    password     varchar(50)        NOT NULL,
    phone_number varchar(50)        NOT NULL,
    CONSTRAINT PK_18 PRIMARY KEY ("id")
);

CREATE TABLE driver
(
    "id"         bigserial          NOT NULL,
    name         varchar(50)        NOT NULL,
    last_name    varchar(50)        NOT NULL,
    email        varchar(50) unique NOT NULL,
    password     varchar(50)        NOT NULL,
    phone_number varchar(50)        NOT NULL,
    car_number   varchar(50)        NOT NULL,
    CONSTRAINT PK_5 PRIMARY KEY ("id")
);

CREATE TABLE taxi_order
(
    "id"      bigserial   NOT NULL,
    data      varchar(50) NOT NULL,
    driver_id bigserial ,
    client_id bigserial   NOT NULL,
    CONSTRAINT PK_29 PRIMARY KEY ("id"),
    CONSTRAINT FK_51 FOREIGN KEY (client_id) REFERENCES client ("id") ON DELETE SET NULL ,
    CONSTRAINT FK_54 FOREIGN KEY (driver_id) REFERENCES driver ("id") ON DELETE SET NULL
);

CREATE INDEX fkIdx_53 ON taxi_order
    (
     client_id
        );

CREATE INDEX fkIdx_56 ON taxi_order
    (
     driver_id
        );


CREATE TABLE ride
(
    "id"            bigserial NOT NULL,
    address_id_from bigserial NOT NULL,
    address_id_to   bigserial NOT NULL,
    order_id        bigserial NOT NULL,
    CONSTRAINT PK_26 PRIMARY KEY ("id"),
    CONSTRAINT FK_35 FOREIGN KEY (address_id_from) REFERENCES address ("id"),
    CONSTRAINT FK_38 FOREIGN KEY (address_id_to) REFERENCES address ("id"),
    CONSTRAINT FK_41 FOREIGN KEY (order_id) REFERENCES taxi_order ("id")
);

CREATE INDEX fkIdx_37 ON ride
    (
     address_id_from
        );

CREATE INDEX fkIdx_40 ON ride
    (
     address_id_to
        );

CREATE INDEX fkIdx_43 ON ride
    (
     order_id
        );



CREATE TABLE transaction
(
    "id"     bigserial NOT NULL,
    cash     boolean   NOT NULL,
    order_id bigserial NOT NULL,
    amount   decimal   NOT NULL,
    CONSTRAINT PK_32 PRIMARY KEY ("id"),
    CONSTRAINT FK_44 FOREIGN KEY (order_id) REFERENCES taxi_order ("id")
);

CREATE INDEX fkIdx_46 ON transaction
    (
     order_id
        );


-- ************************************** owner

CREATE TABLE owner
(
    "id"       bigserial NOT NULL,
    userName varchar(50) unique NOT NULL,
    password varchar(50) unique NOT NULL,
    CONSTRAINT PK_9 PRIMARY KEY ( "id" )
);


