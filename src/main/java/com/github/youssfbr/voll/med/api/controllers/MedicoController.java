package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.medicos.IMedicoService;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosAtualizacaoMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosDetalhamentoMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.dtos.DadosListagemMedicoDTO;
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
@RequestMapping("/medicos")
public class MedicoController {

    private final IMedicoService medicoService;

    public MedicoController(IMedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<DadosListagemMedicoDTO>> paginar(@PageableDefault(size = 10 , page = 0 , sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok(medicoService.paginar(pageable));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemMedicoDTO>> listar() {
        return ResponseEntity.ok(medicoService.listar());
    }

    @PostMapping
    public  ResponseEntity<DadosDetalhamentoMedicoDTO> cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        final DadosDetalhamentoMedicoDTO medicoCadastrado = medicoService.cadastrar(dados);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(medicoCadastrado.id()).toUri();

        return ResponseEntity.created(uri).body(medicoCadastrado);
    }

    @PutMapping
    public  ResponseEntity<DadosDetalhamentoMedicoDTO> atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDTO dados) {
        return ResponseEntity.ok(medicoService.atualizarInformacoes(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        medicoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
