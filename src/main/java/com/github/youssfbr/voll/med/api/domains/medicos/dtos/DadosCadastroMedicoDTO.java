package com.github.youssfbr.voll.med.api.domains.medicos.dtos;

import com.github.youssfbr.voll.med.api.domains.enderecos.DadosEnderecoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroMedicoDTO(

        Long id ,

        @NotBlank @Size(max = 100)
        String nome ,

        @Email
        @NotBlank
        @Size(max = 100)
        String email ,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm ,

        @NotNull
        Especialidade especialidade ,

        @NotBlank
        String whatsapp ,

        String telefone ,

        @Valid
        @NotNull
        DadosEnderecoDTO endereco
) {
}
