package com.github.youssfbr.voll.med.api.domains.pacientes;

import com.github.youssfbr.voll.med.api.domains.enderecos.DadosEnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPacienteDTO(
        @NotBlank String nome ,
        @NotBlank @Email String email ,
        @NotBlank String whatsapp ,
        String telefone ,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf ,
        @NotNull @Valid DadosEnderecoDTO endereco
) {
}
