package com.github.youssfbr.voll.med.api.medicos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService implements IMedicoService {

    private final IMedicoRepository medicoRepository;

    public MedicoService(IMedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    @Transactional
    public void cadastrar(DadosCadastroMedicoDTO dados) {
        medicoRepository.save(new Medico(dados));
    }
}
