-- sql
create table perfil (
  id int IDENTITY(1,1) not null,
  nome varchar(150) null,
  primary key (id)
);

create table usuario (
  id uniqueidentifier not null default NEWID(),
  nome varchar(150) not null,
  email varchar(50) not null,
  senha varchar(10) not null,
  ativo tinyint not null default 1,
  id_perfil int not null,
  primary key (id),
  foreign key (id_perfil) references perfil (id)
);

create table curso(
  id uniqueidentifier not null default NEWID(),
  nome varchar(30) not null,
  primary key(id)
);

create table avaliacao(
  id uniqueidentifier not null default NEWID(),
  descricao varchar(150) not null,
  id_curso uniqueidentifier not null,
  id_aluno uniqueidentifier not null,
  data_criacao datetime2 not null default CURRENT_TIMESTAMP,
  is_urgente tinyint default 0,
  nota tinyint,
  primary key(id),
  foreign key (id_curso) references curso(id)
);
