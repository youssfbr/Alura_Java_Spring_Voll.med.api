package com.github.youssfbr.voll.med.api.medicos.dtos;

import com.github.youssfbr.voll.med.api.enderecos.Endereco;
import com.github.youssfbr.voll.med.api.medicos.Especialidade;
import com.github.youssfbr.voll.med.api.medicos.Medico;

public record DadosDetalhamentoMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        String whatsapp ,
        String telefone ,
        Endereco endereco
) {
    public DadosDetalhamentoMedicoDTO(Medico medico) {
        this(
                medico.getId() ,
                medico.getNome() ,
                medico.getEmail() ,
                medico.getCrm() ,
                medico.getEspecialidade() ,
                medico.getWhatsapp() ,
                medico.getTelefone() ,
                medico.getEndereco()
        );
    }
}
