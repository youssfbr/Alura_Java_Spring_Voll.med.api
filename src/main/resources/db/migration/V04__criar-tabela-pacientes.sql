create table tb_pacientes (

    id bigint generated by default as identity,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(14) not null unique,
    whatsapp varchar(20) not null,
    telefone varchar(20),

    cep varchar(9) not null,
    logradouro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    uf char(2) not null,

    primary key (id)
);