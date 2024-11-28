package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.domains.usuarios.DadosAutenticacaoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    public AutenticacaoController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<Void> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        Authentication token = new UsernamePasswordAuthenticationToken(dados.login() , dados.senha());
        final Authentication authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
