package com.github.youssfbr.voll.med.api.domains.usuarios.dtos;

import com.github.youssfbr.voll.med.api.domains.roles.RoleDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record DadosListagemUsuarioDTO(

        Long id ,
        String login ,

        Set<RoleDTO> roles
) {
    public DadosListagemUsuarioDTO(Usuario entity) {
        this(
                entity.getId() ,
                entity.getLogin() ,

                entity.getRoles()
                        .stream()
                        .map(RoleDTO::new)
                        .collect(Collectors.toSet())
        );
    }
}
