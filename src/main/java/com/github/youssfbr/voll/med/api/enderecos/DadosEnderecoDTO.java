package com.github.youssfbr.voll.med.api.enderecos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEnderecoDTO(

        @NotBlank
        String logradouro ,

        @NotBlank
        String bairro ,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep ,

        @NotBlank
        String cidade ,

        @NotBlank
        String uf ,

        String numero ,
        String complemento
) {
}
