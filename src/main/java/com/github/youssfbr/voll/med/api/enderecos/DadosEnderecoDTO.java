package com.github.youssfbr.voll.med.api.enderecos;

public record DadosEnderecoDTO(
        String logradouro ,
        String bairro ,
        String cep ,
        String cidade ,
        String uf ,
        String numero ,
        String complemento
) {
}
