package com.github.youssfbr.voll.med.api.domains.medicos.dtos;

import com.github.youssfbr.voll.med.api.domains.enderecos.Endereco;
import com.github.youssfbr.voll.med.api.domains.medicos.Especialidade;
import com.github.youssfbr.voll.med.api.domains.medicos.Medico;

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
