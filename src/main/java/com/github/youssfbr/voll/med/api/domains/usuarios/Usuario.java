package com.github.youssfbr.voll.med.api.domains.usuarios;

import com.github.youssfbr.voll.med.api.domains.roles.Role;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosAtualizacaoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosCadastroUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuario")
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String login;

    @Setter
    @Column(nullable = false)
    private String senha;

    @Column(columnDefinition = "text")
    private String observacao;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "tb_user_role" ,
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private Boolean ativo;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Usuario(DadosCadastroUsuarioDTO dto) {
        login = dto.login();
        observacao = dto.observacao();
    }

    @PrePersist
    public void prePersist() {
        ativo = true;
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuarioDTO dados) {

        if (dados.login() != null) {
            login = dados.login();
        }

        if (dados.senha() != null) {
            senha = dados.senha();
        }

        if (dados.observacao() != null) {
            observacao = dados.observacao();
        }

        if (dados.roles() != null) {
            dados.roles()
                    .stream()
                    .map(Role::new)
                    .collect(Collectors.toSet());
        }
    }

    public void inativar() {
        ativo = false;
    }
}
