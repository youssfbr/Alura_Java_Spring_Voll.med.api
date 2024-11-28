package com.github.youssfbr.voll.med.api.domains.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllPageByAtivoTrue(Pageable paginacao);
    List<Usuario> findAllByAtivoTrueOrderById();


    Optional<Usuario> getReferenceByIdAndAtivoTrue(Long id);

    UserDetails findByLogin(String login);
}
