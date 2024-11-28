package com.github.youssfbr.voll.med.api.domains.usuarios.dtos;

import com.github.youssfbr.voll.med.api.domains.roles.RoleDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.stream.Collectors;

public record DadosDetalhamentoUsuarioDTO(

        Long id ,
        String login ,
        String observacao ,

        Set<RoleDTO> roles
) {
    public DadosDetalhamentoUsuarioDTO(Usuario entity) {
        this(
                entity.getId() ,
                entity.getLogin() ,
                entity.getObservacao() , 
                entity.getRoles()
                        .stream()
                        .map(RoleDTO::new)
                        .collect(Collectors.toSet())
        );
    }
}
