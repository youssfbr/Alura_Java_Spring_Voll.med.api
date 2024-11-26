package com.github.youssfbr.voll.med.api.medicos;

import com.github.youssfbr.voll.med.api.medicos.dtos.DadosAtualizacaoMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosDetalhamentoMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosListagemMedicoDTO;
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
