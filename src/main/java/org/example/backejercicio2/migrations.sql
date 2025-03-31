\c react_spring


CREATE USER react_spring WITH PASSWORD 'postgres';

GRANT CONNECT ON DATABASE react_spring TO react_spring;

GRANT USAGE ON SCHEMA public TO react_spring;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO react_spring;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO react_spring;

ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO react_spring;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE, SELECT ON SEQUENCES TO react_spring;

create table productos (
                           id_producto serial primary key,
                           codigo_ean varchar(13) not null,
                           nombre_producto varchar(100) not null,
                           descripcion_producto text,
                           tipo varchar(50),
                           marca varchar(50),
                           precio_unitario numeric(10,2),
                           stock int
);

create table clientes (
                          id_cliente serial primary key,
                          nombre_cliente varchar(100),
                          apellido_cliente varchar(100),
                          fecha_ingreso varchar(15),
                          telefono_cliente varchar(9),
                          direccion_cliente varchar(100)
);
insert into productos (codigo_ean, nombre_producto, descripcion_producto, tipo, marca, precio_unitario, stock) values
                                                                                                                   ('1234567890123', 'Producto 1', 'Descripcion del producto 1', 'Tipo 1', 'Marca 1', 100.00, 10),
                                                                                                                   ('1234567890124', 'Producto 2', 'Descripcion del producto 2', 'Tipo 2', 'Marca 2', 200.00, 20),
                                                                                                                   ('1234567890125', 'Producto 3', 'Descripcion del producto 3', 'Tipo 3', 'Marca 3', 300.00, 30),
                                                                                                                   ('1234567890126', 'Producto 4', 'Descripcion del producto 4', 'Tipo 4', 'Marca 4', 400.00, 40),
                                                                                                                   ('1234567890127', 'Producto 5', 'Descripcion del producto 5', 'Tipo 5', 'Marca 5', 500.00, 50);
