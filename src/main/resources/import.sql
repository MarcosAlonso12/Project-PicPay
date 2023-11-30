insert into users (id, name, cpf, email, password, type, amount) values (1, 'Ana', '123.456.789-01', 'ana@example.com', 'ana123', 'COMMON', 1000.00);
insert into users (id, name, cpf, email, password, type, amount) values (2, 'Bruno', '123.456.789-02', 'bruno@example.com', 'bruno123', 'COMMON', 1500.00);
insert into users (id, name, cpf, email, password, type, amount) values (3, 'Carlos', '123.456.789-03', 'carlos@example.com', 'carlos123', 'COMMON', 3000.39);
insert into users (id, name, cpf, email, password, type, amount) values (4, 'Donald', '123.456.789-04', 'donald@example.com', 'donald123', 'COMMON', 500.50);
insert into users (id, name, cpf, email, password, type, amount) values (5, 'Edinaldo', '123.456.789-05', 'edinaldo@example.com', 'edinaldo123', 'COMMON', 1000.39);
insert into users (id, name, cpf, email, password, type, amount) values (6, 'Flávia', '123.456.789-06', 'flavia@example.com', 'flavia123', 'COMMON', 6000.50);

insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (1, 'Ana Comércios', '12.345.671/0001-00', 'ana.comercio@example.com', 'anac123', 'SHOPKEEPER', 10000.35);
insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (2, 'Bruno AutoPeças', '12.345.672/0001-00', 'b.autopecas@example.com', 'bruno123', 'SHOPKEEPER', 50000.20);
insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (3, 'Mercado Bom Jesus', '12.345.673/0001-00', 'merc.carlos@example.com', 'carlos123', 'SHOPKEEPER', 100000.00);
insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (4, 'Banco Santos', '12.345.674/0001-00', 'b.santos@example.com', 'santos.b123', 'SHOPKEEPER', 5000000.30);
insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (5, 'Assistencia Souza', '12.345.675/0001-00', 's.ass@example.com', 'souza123', 'SHOPKEEPER', 30000.00);
insert into shopkeepers (id, name, cnpj, email, password, type, amount) values (6, 'Borracharia Tours', '12.345.676/0001-00', 'tours@example.com', 'tours123', 'SHOPKEEPER', 1000.30);

insert into transfers (id, payer_id, receiver_id, value) values (1,2,11, 1000.00);
insert into transfers (id, payer_id, receiver_id, value) values (2,4,12, 2000.00);
insert into transfers (id, payer_id, receiver_id, value) values (3,6,13, 4000.00);
insert into transfers (id, payer_id, receiver_id, value) values (4,8,14, 5000.00);
insert into transfers (id, payer_id, receiver_id, value) values (5,10,15,6000.00);
insert into transfers (id, payer_id, receiver_id, value) values (6,1,16, 7000.00);


