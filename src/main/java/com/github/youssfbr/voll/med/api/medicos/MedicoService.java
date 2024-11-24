package com.github.youssfbr.voll.med.api.medicos;

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
        return medicoRepository.findAll(paginacao)
                .map(DadosListagemMedicoDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosListagemMedicoDTO> listar() {
        return medicoRepository.findAll().stream()
                .map(DadosListagemMedicoDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public void cadastrar(DadosCadastroMedicoDTO dados) {
        medicoRepository.save(new Medico(dados));
    }
}
