package com.github.youssfbr.voll.med.api.domains.medicos.dtos;

import com.github.youssfbr.voll.med.api.domains.enderecos.DadosEnderecoDTO;
import jakarta.validation.constraints.*;

public record DadosAtualizacaoMedicoDTO(

        @NotNull
        Long id ,

        String nome ,

        String whatsapp ,

        String telefone ,

        DadosEnderecoDTO endereco
) {
}
