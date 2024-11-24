package com.github.youssfbr.voll.med.api.medicos;

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
