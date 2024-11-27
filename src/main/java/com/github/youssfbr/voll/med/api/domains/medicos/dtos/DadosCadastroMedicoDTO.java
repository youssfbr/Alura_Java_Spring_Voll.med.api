package com.github.youssfbr.voll.med.api.domains.medicos.dtos;

import com.github.youssfbr.voll.med.api.domains.enderecos.DadosEnderecoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroMedicoDTO(

        Long id ,

        @NotBlank @Size(max = 100 , message = "Nome é obrigatório")
        String nome ,

        @Email(message = "Email é obrigatório")
        @NotBlank(message = "Email é obrigatório")
        @Size(max = 100)
        String email ,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}" , message = "Formato do CRM é inválido")
        String crm ,

        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade ,

        @NotBlank(message = "Número do WhatsApp é obrigatório")
        String whatsapp ,

        String telefone ,

        @Valid
        @NotNull(message = "Dados do endereço são obrigatórios")
        DadosEnderecoDTO endereco
) {
}
