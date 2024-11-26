package com.github.youssfbr.voll.med.api.pacientes;

public record DadosListagemPacienteDTO(

        Long id,
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPacienteDTO(Paciente entity) {
        this(
            entity.getId() ,
            entity.getNome() ,
            entity.getEmail() ,
            entity.getCpf()
        );
    }
}
