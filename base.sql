DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS clients;

CREATE TABLE pizzas
(
    id      SERIAL      not null primary key,
    name    varchar(50) NOT NULL,
    cost    INT not null
);
CREATE TABLE clients
(
    id      SERIAL       not null primary key,
    client  varchar(50)  NOT NULL,
    phone   varchar(13)  NOT NULL,
    email   varchar(30)  NOT NULL UNIQUE,
    address varchar(100) NOT NULL
);
CREATE TABLE orders
(
    id SERIAL not null primary key,
    client_id INT not null REFERENCES clients(id),
    pizza_id INT not null REFERENCES pizzas(id),
    size varchar(1)  NOT NULL CHECK (size = 'S' OR size = 'M' OR size = 'L'),
    topping varchar(50),
    price INT not null

);
INSERT INTO pizzas
VALUES (1, 'Маргарита', 400),
       (2, 'Четыре сыра', 550),
       (3, 'Гавайская', 650),
       (4, 'Каприччиоза', 700);
INSERT INTO clients
VALUES (1,'Bob Thomas', '8916123456', 'bob@mail.ru', 'Москва, Ленинский пр-т, 1'),
       (2, 'John Rambo', '8916123499', 'john@mail.ru', 'Москва, Ленинградский пр-т, 1');