CREATE DATABASE Bank

CREATE TABLE cdivision
 (id_division integer NOT NULL,
  name_division varchar(50) NOT NULL,
  telephone_division varchar(20),
  CONSTRAINT id_division_pk PRIMARY KEY(id_division),
  CONSTRAINT name_division_uk UNIQUE(name_division));
 CREATE SEQUENCE division_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/

CREATE TABLE cposition
 (id_position integer NOT NULL,
  name_position varchar(50) NOT NULL,
  salary integer NOT NULL,
  CONSTRAINT id_position_pk PRIMARY KEY(id_position),
  CONSTRAINT name_position_uk UNIQUE(name_position));
 CREATE SEQUENCE position_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/

CREATE TABLE rclient
 (id_client integer NOT NULL,
  login_client varchar(20) NOT NULL,
  password_client varchar(10) NOT NULL,
  full_name_client varchar(100) NOT NULL,
  passport_number varchar(20) NOT NULL,
  telephone_client varchar(20) NOT NULL,
  gender varchar(1) NOT NULL,
  CONSTRAINT id_client_pk PRIMARY KEY(id_client),
  CONSTRAINT login_client_uk UNIQUE(login_client, passport_number));
 CREATE SEQUENCE client_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/
 
CREATE TABLE jaccount
 (id_account integer NOT NULL,
  id_client integer NOT NULL,
  account_number varchar(50) NOT NULL,
  amount numeric (15, 2) NOT NULL CHECK (amount >= 0),
  currency varchar(10) NOT NULL,
  CONSTRAINT id_account_pk PRIMARY KEY(id_account),
  CONSTRAINT id_client_fk FOREIGN KEY(id_client) REFERENCES rclient(id_client));
 CREATE SEQUENCE account_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/

CREATE TABLE jtransaction
 (id_transaction integer NOT NULL,
  payee integer NOT NULL,
  payment_amount numeric (15, 2) NOT NULL CHECK (payment_amount > 0),
  CONSTRAINT id_transaction_pk PRIMARY KEY(id_transaction),
  CONSTRAINT payee_pk FOREIGN KEY(payee) REFERENCES rclient(id_client));
 CREATE SEQUENCE transaction_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/
 
CREATE TABLE remployee
 (id_employee integer NOT NULL,
  id_division integer NOT NULL,
  id_position integer NOT NULL,
  full_name_employee varchar(100) NOT NULL,
  address varchar(200) NOT NULL,
  telephone_employee varchar(20) NOT NULL,
  birth_date date NOT NULL,
  gender varchar(1) NOT NULL,
  family_status varchar(10),
  kids varchar(3),
  CONSTRAINT id_employee_pk PRIMARY KEY(id_employee),
  CONSTRAINT id_division_fk FOREIGN KEY(id_division) REFERENCES cdivision(id_division),
  CONSTRAINT id_position_fk FOREIGN KEY(id_position) REFERENCES cposition(id_position));
 CREATE SEQUENCE employee_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/
 
CREATE TABLE jtransfer
 (id_transfer integer NOT NULL,
  payee integer NOT NULL,
  sender integer NOT NULL,
  id_transaction integer NOT NULL,
  id_employee integer NOT NULL,
  CONSTRAINT id_transfer_pk PRIMARY KEY(id_transfer),
  CONSTRAINT id_payee_fk FOREIGN KEY(payee) REFERENCES rclient(id_client),
  CONSTRAINT id_sender_fk FOREIGN KEY(sender) REFERENCES rclient(id_client),
  CONSTRAINT id_transaction_fk FOREIGN KEY(id_transaction) REFERENCES jtransaction(id_transaction),
  CONSTRAINT id_employee_fk FOREIGN KEY(id_employee) REFERENCES remployee(id_employee));
 CREATE SEQUENCE transfer_id_seq START WITH 1 INCREMENT 1; /*Тут внимательно*/