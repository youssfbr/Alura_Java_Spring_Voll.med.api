package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.pacientes.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<DadosListagemPacienteDTO>> listar(
            @PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok(pacienteService.paginar(paginacao));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPacienteDTO>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoPacienteDTO>  cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados) {
        final DadosDetalhamentoPacienteDTO pacienteCadastrado = pacienteService.cadastrar(dados);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(pacienteCadastrado.id()).toUri();

        return ResponseEntity.created(uri).body(pacienteCadastrado);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoPacienteDTO> atualizar(@RequestBody @Valid DadosAtualizacaoPacienteDTO dados) {
        return ResponseEntity.ok(pacienteService.atualizarInformacoes(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        pacienteService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
