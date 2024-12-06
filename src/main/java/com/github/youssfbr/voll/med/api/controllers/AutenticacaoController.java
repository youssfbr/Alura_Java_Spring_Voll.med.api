package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.domains.usuarios.DadosAutenticacaoDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.Usuario;
import com.github.youssfbr.voll.med.api.infra.security.DadosTokenJWT;
import com.github.youssfbr.voll.med.api.infra.security.TokenService;
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
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager , TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(dados.login() , dados.senha());
        final Authentication authentication = manager.authenticate(authenticationToken);

        final String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
