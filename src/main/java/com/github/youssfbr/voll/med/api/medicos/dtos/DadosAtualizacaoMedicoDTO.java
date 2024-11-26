package com.github.youssfbr.voll.med.api.medicos.dtos;

import com.github.youssfbr.voll.med.api.enderecos.DadosEnderecoDTO;
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
