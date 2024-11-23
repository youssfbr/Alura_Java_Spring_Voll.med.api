create table tb_medicos (

    id bigint generated by default as identity,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,

    whatsapp varchar(20) not null,
    telefone varchar(20),

    cep varchar(9) not null,
    logradouro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    uf varchar(2) not null,

    primary key (id)
);