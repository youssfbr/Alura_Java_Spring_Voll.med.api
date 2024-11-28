package com.github.youssfbr.voll.med.api.domains.roles;

public record RoleDTO(
        Long id ,
        String authority
) {
    public RoleDTO (Role role){
        this(
                role.getId() ,
                role.getAuthority());
    }
}
