package com.github.youssfbr.voll.med.api.domains.pacientes;

import com.github.youssfbr.voll.med.api.domains.enderecos.DadosEnderecoDTO;
import jakarta.validation.Valid;

public record DadosAtualizacaoPacienteDTO(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEnderecoDTO endereco
) {
}
