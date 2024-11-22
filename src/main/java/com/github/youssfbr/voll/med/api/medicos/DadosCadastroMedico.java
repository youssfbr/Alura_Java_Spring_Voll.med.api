package com.github.youssfbr.voll.med.api.medicos;

import com.github.youssfbr.voll.med.api.enderecos.DadosEndereco;

public record DadosCadastroMedico(
        String nome ,
        String email ,
        String crm ,
        Especialidade especialidade ,
        DadosEndereco endereco
) {
}
