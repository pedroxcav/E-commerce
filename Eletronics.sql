create database if not exists Eletronics default character set utf8mb3 default collate utf8mb3_general_ci;

use Eletronics;

create table if not exists Customers (
	nome varchar(50) not null,
    usuario varchar(50) not null primary key,
    email varchar(50) not null unique,
    senha varchar(50) not null,
    celular char(11) unique,
    CPF char(11) unique,
    endereco varchar(100)
);

create table if not exists Administrators (
	nome varchar(50) not null,
    usuario varchar(50) not null primary key,
    senha varchar(50) not null,
    CPF char(11) unique
);