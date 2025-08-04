Проект "Цифровая мораль".

sudo su postgres
psql
create database hive;
CREATE USER hive WITH PASSWORD 'password';
\c hive
GRANT ALL ON SCHEMA public TO hive;


