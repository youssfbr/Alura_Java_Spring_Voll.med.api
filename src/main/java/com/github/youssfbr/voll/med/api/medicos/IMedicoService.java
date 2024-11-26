package com.github.youssfbr.voll.med.api.medicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicoService {

    Page<DadosListagemMedicoDTO> paginar(Pageable paginacao);
    List<DadosListagemMedicoDTO> listar();
    void cadastrar(DadosCadastroMedicoDTO dados);
    void atualizarInformacoes(DadosAtualizacaoMedicoDTO dados);
    void remover(Long id);
}
