package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.medicos.DadosAtualizacaoMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.DadosListagemMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.IMedicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        medicoService.cadastrar(dados);
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDTO dados) {
        medicoService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        medicoService.excluir(id);
    }
}
