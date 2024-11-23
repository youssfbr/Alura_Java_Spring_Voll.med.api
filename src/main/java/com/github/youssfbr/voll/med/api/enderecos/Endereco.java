package com.github.youssfbr.voll.med.api.enderecos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Column(length = 100 , nullable = false)
    private String logradouro;

    @Column(length = 100 , nullable = false)
    private String bairro;

    @Column(length = 9 , nullable = false)
    private String cep;

    @Column(length = 100 , nullable = false)
    private String cidade;

    @Column(length = 2 , nullable = false)
    private String uf;

    @Column(length = 20 , nullable = false)
    private String numero;

    @Column(length = 100 , nullable = false)
    private String complemento;

    public Endereco(DadosEnderecoDTO dados) {
        logradouro = dados.logradouro();
        bairro = dados.bairro();
        cep = dados.cep();
        cidade = dados.cidade();
        uf = dados.uf();
        numero = dados.numero();
        complemento = dados.complemento();
    }
}
