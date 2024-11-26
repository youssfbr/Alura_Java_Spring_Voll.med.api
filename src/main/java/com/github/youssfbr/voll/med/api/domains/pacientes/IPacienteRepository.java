package com.github.youssfbr.voll.med.api.domains.pacientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllPageByAtivoTrue(Pageable paginacao);
    List<Paciente> findAllByAtivoTrue();
}
