package com.github.youssfbr.voll.med.api.domains.medicos;

import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosAtualizacaoMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosDetalhamentoMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosListagemMedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicoService {

    Page<DadosListagemMedicoDTO> paginar(Pageable paginacao);
    List<DadosListagemMedicoDTO> listar();
    DadosDetalhamentoMedicoDTO detalhar(Long id);
    DadosDetalhamentoMedicoDTO cadastrar(DadosCadastroMedicoDTO dados);
    DadosDetalhamentoMedicoDTO atualizarInformacoes(DadosAtualizacaoMedicoDTO dados);
    void excluir(Long id);
}
