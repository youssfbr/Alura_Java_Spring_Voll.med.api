package com.github.youssfbr.voll.med.api.domains.medicos;

import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosAtualizacaoMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosDetalhamentoMedicoDTO;
import com.github.youssfbr.voll.med.api.domains.medicos.dtos.DadosListagemMedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService implements IMedicoService {

    private final IMedicoRepository medicoRepository;

    public MedicoService(IMedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DadosListagemMedicoDTO> paginar(Pageable paginacao) {
        return medicoRepository.findAllPageByAtivoTrue(paginacao)
                .map(DadosListagemMedicoDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosListagemMedicoDTO> listar() {
        return medicoRepository.findAllByAtivoTrue().stream()
                .map(DadosListagemMedicoDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DadosDetalhamentoMedicoDTO detalhar(Long id) {
        final Medico medico = medicoRepository.getReferenceById(id);
        return new DadosDetalhamentoMedicoDTO(medico);
    }

    @Override
    @Transactional
    public DadosDetalhamentoMedicoDTO cadastrar(DadosCadastroMedicoDTO dados) {
        final Medico medicoCriado = medicoRepository.save(new Medico(dados));
        return new DadosDetalhamentoMedicoDTO(medicoCriado);
    }

    @Override
    @Transactional
    public DadosDetalhamentoMedicoDTO atualizarInformacoes(DadosAtualizacaoMedicoDTO dados) {
        final Medico medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return new DadosDetalhamentoMedicoDTO(medico);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        final Medico medico = medicoRepository.getReferenceById(id);
        medico.inativar();
    }

}
