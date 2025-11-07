create table perfil (
	id int not null auto_increment,
	nome varchar(150) null,
	primary key (id)
);

create table usuario (
	id uuid not null,
    nome varchar(150) not null,
    email varchar(50) not null,
    senha varchar(10) not null,
    ativo tinyint not null default 1,
    id_perfil int not null,
    primary key (id),
    foreign key (id_perfil) references perfil (id)
);

create table curso(
	id uuid,
	nome varchar(30) not null,
	primary key(id)
);

create table avaliacao(
	id uuid,
	descricao varchar(150) not null,
	id_curso uuid not null,
	id_aluno uuid not null,
	data_criacao timestamp not null default current_timestamp,
	is_urgente tinyint(1) default 0,
	nota tinyint(1),
	primary key(id)
);