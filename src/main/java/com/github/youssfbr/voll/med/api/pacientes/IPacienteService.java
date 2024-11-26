package com.github.youssfbr.voll.med.api.pacientes;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPacienteService {

    Page<DadosListagemPacienteDTO> paginar(Pageable paginacao);
    List<DadosListagemPacienteDTO> listar();
    void cadastrar(DadosCadastroPacienteDTO dados);
    void atualizarInformacoes(@Valid DadosAtualizacaoPacienteDTO dados);
    void remover(Long id);

}