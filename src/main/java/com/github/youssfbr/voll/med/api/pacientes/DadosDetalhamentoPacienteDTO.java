package com.github.youssfbr.voll.med.api.pacientes;

import com.github.youssfbr.voll.med.api.enderecos.Endereco;

public record DadosDetalhamentoPacienteDTO(
        Long id ,
        String nome ,
        String email ,
        String cpf ,
        String whatsapp ,
        String telefone ,
        Endereco endereco
) {
    public DadosDetalhamentoPacienteDTO(Paciente paciente) {
        this(
                paciente.getId() ,
                paciente.getNome() ,
                paciente.getEmail() ,
                paciente.getCpf() ,
                paciente.getWhatsapp() ,
                paciente.getTelefone() ,
                paciente.getEndereco()
        );
    }
}
