package com.github.youssfbr.voll.med.api.medicos;

import com.github.youssfbr.voll.med.api.enderecos.DadosEnderecoDTO;

public record DadosCadastroMedicoDTO(
        String nome ,
        String email ,
        String crm ,
        Especialidade especialidade ,
        String whatsapp ,
        String telefone ,
        DadosEnderecoDTO endereco
) {
}
