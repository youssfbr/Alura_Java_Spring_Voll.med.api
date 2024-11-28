package com.github.youssfbr.voll.med.api.domains.roles;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_roles")
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    public Role(RoleDTO dto) {
        id = dto.id();
        authority = dto.authority();
    }

    public Role(Long id) {
        this.id = id;
    }
}
