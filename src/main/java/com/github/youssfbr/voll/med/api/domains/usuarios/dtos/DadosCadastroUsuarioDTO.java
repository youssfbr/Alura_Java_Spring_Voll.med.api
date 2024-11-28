package com.github.youssfbr.voll.med.api.domains.usuarios.dtos;

import com.github.youssfbr.voll.med.api.domains.roles.RoleDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record DadosCadastroUsuarioDTO(

        @NotBlank String login ,
        @NotBlank String senha ,
        String observacao ,

        Set<RoleDTO> roles
) {
}
