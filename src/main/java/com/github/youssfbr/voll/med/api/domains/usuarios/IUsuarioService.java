package com.github.youssfbr.voll.med.api.domains.usuarios;

import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosAtualizacaoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosCadastroUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosDetalhamentoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosListagemUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioService {

    Page<DadosListagemUsuarioDTO> paginar(Pageable paginacao);
    List<DadosListagemUsuarioDTO> listar();
    DadosDetalhamentoUsuarioDTO listarPorId(Long id);
    DadosDetalhamentoUsuarioDTO cadastrar(DadosCadastroUsuarioDTO dados);
    DadosDetalhamentoUsuarioDTO atualizarInformacoes(DadosAtualizacaoUsuarioDTO dados);
    void remover(Long id);

}
