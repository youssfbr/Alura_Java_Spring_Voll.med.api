package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.domains.usuarios.IUsuarioService;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosAtualizacaoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosCadastroUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosDetalhamentoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosListagemUsuarioDTO;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<DadosListagemUsuarioDTO>> paginar(
            @PageableDefault(size = 10 , page = 0 , sort = {"login"}) Pageable pageable) {
        return ResponseEntity.ok(usuarioService.paginar(pageable));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemUsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuarioDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.listarPorId(id));
    }

    @PostMapping
    public  ResponseEntity<DadosDetalhamentoUsuarioDTO> cadastrar(@RequestBody @Valid DadosCadastroUsuarioDTO dados) {

        final DadosDetalhamentoUsuarioDTO usuarioCadastrado = usuarioService.cadastrar(dados);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(usuarioCadastrado.id()).toUri();

        return ResponseEntity.created(uri).body(usuarioCadastrado);
    }

    @PutMapping
    public  ResponseEntity<DadosDetalhamentoUsuarioDTO> atualizar(@RequestBody @Valid DadosAtualizacaoUsuarioDTO dados) {
        return ResponseEntity.ok(usuarioService.atualizarInformacoes(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
