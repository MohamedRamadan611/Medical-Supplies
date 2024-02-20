create table customer
(
   customer_id BIGINT auto_increment primary key,
   phone varchar (100),
   customer_name varchar (250),
   address varchar (250),
   creationDate date
);

create table invoices
(
   invoiceno BIGINT auto_increment primary key,
   payment_type int,
   payment_status varchar (2),
   auth_code varchar(250),
   delivery_price decimal(14,2),
   order_price decimal(14,2),
   amount decimal(14,2),
   discount decimal(14,2),
   order_address varchar(250),
   creation_date date ,
   customerno BIGINT,
   order_type varchar(2)
);
create table item
(
   itemno varchar(250) primary key,
   price decimal(14,2),
   details varchar(250),
   item_name varchar(250),
   company varchar(250),
   orderno BIGINT
);
create table orders
(
   orderno BIGINT auto_increment primary key,
   order_type varchar(2),
   customerno BIGINT,
   auth_code varchar(250),
   order_address varchar(250),
   delivery_price decimal(14,2),
   order_price decimal(14,2),
   amount decimal(14,2),
   discount decimal(14,2),
   invoiceno BIGINT
);
create table stock
(
   stockTransNo BIGINT auto_increment primary key,
   quantity int,
   sold_quantity int,
   remain_quantity int,
   inventory_branch int,
   itemno varchar(250)
);
