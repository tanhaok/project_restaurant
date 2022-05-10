CREATE DATABASE restaurant_db;
USE restaurant_db;

CREATE TABLE employee(
	id int NOT NULL AUTO_INCREMENT,
    name nvarchar(255),
    address nvarchar(255),
    phone varchar(255),
    salary int,
    PRIMARY KEY(id)
);

CREATE TABLE customer(
	id int NOT NULL AUTO_INCREMENT,
    name nvarchar(255),
    address nvarchar(255),
    phone varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE account(
	username varchar(255),
    password varchar(255),
    usertype varchar(255)
);

CREATE TABLE dining_table(
	id int NOT NULL AUTO_INCREMENT,
    status nvarchar(255),
    cust_id int,
    FOREIGN KEY (cust_id) REFERENCES customer(id),
    PRIMARY KEY (id)
);

CREATE TABLE product_category(
	id int NOT NULL AUTO_INCREMENT,
    name nvarchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE product(
	id int NOT NULL AUTO_INCREMENT,
    name nvarchar(255),
    description nvarchar(255),
    img nvarchar(255),
    price int,
    amount int,
    cate_id int,
    FOREIGN KEY (cate_id) REFERENCES product_category(id),
    PRIMARY KEY (id)
);

CREATE TABLE cart(
	id int NOT NULL AUTO_INCREMENT,
	cust_id int,
	product_id int,
	product_amount int,
    FOREIGN KEY (cust_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (id)
);

CREATE TABLE invoice(
	id int NOT NULL AUTO_INCREMENT,
    cust_id int,
    emp_id int,
    cart_id int,
    total_cost int,
    create_date datetime,
    FOREIGN KEY (cust_id) REFERENCES customer(id),
    FOREIGN KEY (emp_id) REFERENCES employee(id),
    FOREIGN KEY (cart_id) REFERENCES cart(id),
    PRIMARY KEY (id)
);

create table booking_table(
id int NOT NULL AUTO_INCREMENT,
cust_id int,
table_id int,
arrival_date date,
arrival_time time,
number_peoples int,
booking_status nvarchar(255),
FOREIGN KEY (cust_id) REFERENCES customer(id),
FOREIGN KEY (table_id) REFERENCES dining_table(id),
PRIMARY KEY (id)
);
