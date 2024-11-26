package com.github.youssfbr.voll.med.api.pacientes;

import com.github.youssfbr.voll.med.api.enderecos.DadosEnderecoDTO;
import jakarta.validation.Valid;

public record DadosAtualizacaoPacienteDTO(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEnderecoDTO endereco
) {
}
