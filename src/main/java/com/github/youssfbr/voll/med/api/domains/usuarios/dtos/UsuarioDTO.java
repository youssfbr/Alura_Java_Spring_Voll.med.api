package com.github.youssfbr.voll.med.api.domains.usuarios.dtos;

import com.github.youssfbr.voll.med.api.domains.roles.RoleDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record UsuarioDTO(

        @NotBlank String login ,

        Set<RoleDTO>roles
) {
}
