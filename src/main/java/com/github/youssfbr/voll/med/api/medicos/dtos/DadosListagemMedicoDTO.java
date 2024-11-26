package com.github.youssfbr.voll.med.api.medicos.dtos;

import com.github.youssfbr.voll.med.api.medicos.Especialidade;
import com.github.youssfbr.voll.med.api.medicos.Medico;

public record DadosListagemMedicoDTO(

        Long id ,
        String nome ,
        String email ,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedicoDTO(Medico entity) {
        this(
            entity.getId() ,
            entity.getNome() ,
            entity.getEmail() ,
            entity.getCrm() ,
            entity.getEspecialidade());
    }
}
