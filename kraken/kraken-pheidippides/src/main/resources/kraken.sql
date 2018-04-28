create database `prometheus`;

create user 'prometheus'@'localhost' identified by 'prometheus';

grant all on `prometheus`.* to 'prometheus'@'localhost';