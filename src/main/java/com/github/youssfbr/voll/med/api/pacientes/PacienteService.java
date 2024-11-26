package com.github.youssfbr.voll.med.api.pacientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DadosListagemPacienteDTO> paginar(Pageable paginacao) {
        return pacienteRepository.findAllPageByAtivoTrue(paginacao)
                .map(DadosListagemPacienteDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosListagemPacienteDTO> listar() {
        return pacienteRepository.findAllByAtivoTrue().stream()
                .map(DadosListagemPacienteDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public void cadastrar(DadosCadastroPacienteDTO dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @Override
    @Transactional
    public void atualizarInformacoes(DadosAtualizacaoPacienteDTO dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.inativar();
    }

}
