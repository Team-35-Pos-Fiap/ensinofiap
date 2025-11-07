---- perfis ----

insert into perfil (nome) values ('Aluno');
insert into perfil (nome) values ('Administrador');

---- usuários ---- 

insert into usuario (id, nome, email, senha, ativo, id_perfil)
values ('b249b761-acdd-46d1-8c1c-7517b1ffdc3a', 'Arthur', 'arthur@ensinofiap.com', '1234', 1, 1);
    
insert into usuario (id, nome, email, senha, ativo, id_perfil)
values ('516dfc3e-cc76-40f1-80a0-a73243620fbf', 'Jedaias', 'jedaias@ensinofiap.com', '1234', 1, 1);

insert into usuario (id, nome, email, senha, ativo, id_perfil)
values ('72b855c9-10bc-444c-9862-be4d733b462b', 'Matheus', 'matheus@ensinofiap.com', '1234', 1, 1);

insert into usuario (id, nome, email, senha, ativo, id_perfil)
values ('a372d3ae-3fae-4f95-94a5-ea439fb493d0', 'Thiago', 'thiago.motta.souza.23@gmail.com', '1234', 1, 2);

insert into usuario (id, nome, email, senha, ativo, id_perfil)
values ('a372d3ae-3fae-4f95-94a5-ea439fb493d0', 'Thiago', 'posfiapteam35@gmail.com', '1234', 1, 2);

---- cursos ----

insert into curso values ('70caa7df-8caa-49e4-bffd-bfee7471045c', 'Culinária');
insert into curso values ('7ca149df-726c-44c1-887e-a42f7be8dc46', 'Aministração');
insert into curso values ('5e6111d3-ccdc-4dca-a6ff-0fe6338d6bd8', 'Informática');
insert into curso values ('b0323a59-df20-49a5-a66f-1bc165f2d06c', 'Artesanato');

---- avaliações ----

-- curso de culinária

insert into avaliacao values (random_uuid(), 'O curso foi muito bom.', '70caa7df-8caa-49e4-bffd-bfee7471045c', 'b249b761-acdd-46d1-8c1c-7517b1ffdc3a', current_timestamp, 0, 5);
insert into avaliacao values (random_uuid(), 'O curso foi muito bom.', '70caa7df-8caa-49e4-bffd-bfee7471045c', '516dfc3e-cc76-40f1-80a0-a73243620fbf', current_timestamp, 0, 5);
insert into avaliacao values (random_uuid(), 'O curso foi muito horrível.', '70caa7df-8caa-49e4-bffd-bfee7471045c', '72b855c9-10bc-444c-9862-be4d733b462b', current_timestamp, 1, 1);

-- curso de administração

insert into avaliacao values (random_uuid(), 'O curso foi muito bom.', '7ca149df-726c-44c1-887e-a42f7be8dc46', '516dfc3e-cc76-40f1-80a0-a73243620fbf', current_timestamp, 0, 5);
insert into avaliacao values (random_uuid(), 'O curso foi muito horrível.', '7ca149df-726c-44c1-887e-a42f7be8dc46', '72b855c9-10bc-444c-9862-be4d733b462b', current_timestamp, 1, 1);
insert into avaliacao values (random_uuid(), 'O curso foi muito razoável.', '7ca149df-726c-44c1-887e-a42f7be8dc46', 'b249b761-acdd-46d1-8c1c-7517b1ffdc3a', current_timestamp, 0, 3);

-- curso de informática

insert into avaliacao values (random_uuid(), 'O curso foi muito bom.', '5e6111d3-ccdc-4dca-a6ff-0fe6338d6bd8', '72b855c9-10bc-444c-9862-be4d733b462b', current_timestamp, 0, 5);
insert into avaliacao values (random_uuid(), 'O curso foi muito horrível.', '5e6111d3-ccdc-4dca-a6ff-0fe6338d6bd8', '516dfc3e-cc76-40f1-80a0-a73243620fbf', current_timestamp, 1, 1);
insert into avaliacao values (random_uuid(), 'O curso foi muito razoável.', '5e6111d3-ccdc-4dca-a6ff-0fe6338d6bd8', 'b249b761-acdd-46d1-8c1c-7517b1ffdc3a', current_timestamp, 0, 3);

-- curso de artesanato.

insert into avaliacao values (random_uuid(), 'O curso foi muito bom.', 'b0323a59-df20-49a5-a66f-1bc165f2d06c', '72b855c9-10bc-444c-9862-be4d733b462b', current_timestamp, 0, 5);
insert into avaliacao values (random_uuid(), 'O curso foi muito horrível.', 'b0323a59-df20-49a5-a66f-1bc165f2d06c', '516dfc3e-cc76-40f1-80a0-a73243620fbf', current_timestamp, 1, 1);
insert into avaliacao values (random_uuid(), 'O curso foi muito razoável.', 'b0323a59-df20-49a5-a66f-1bc165f2d06c', '976ff2c7-0ad5-4d18-88c0-719e1939182d', current_timestamp, 0, 3);