package com.github.youssfbr.voll.med.api.domains.medicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMedicoRepository extends JpaRepository<Medico , Long> {

    Page<Medico> findAllPageByAtivoTrue(Pageable paginacao);
    List<Medico> findAllByAtivoTrue();
}
