CREATE TABLE IF NOT EXISTS tb_usuarios (
	
	id bigint CONSTRAINT pk_tb_usuarios_id PRIMARY KEY generated by default as identity,
	login VARCHAR(100) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	observacao TEXT,
	ativo BOOLEAN NOT NULL,
	created_at TIMESTAMP WITHOUT TIME ZONE,
	updated_at TIMESTAMP WITHOUT TIME ZONE
);