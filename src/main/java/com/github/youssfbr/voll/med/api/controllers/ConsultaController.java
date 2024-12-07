package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.domains.consultas.DadosAgendamentoConsulta;
import com.github.youssfbr.voll.med.api.domains.consultas.DadosDethamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {

        return ResponseEntity.ok(new DadosDethamentoConsulta(null , null , null, null));
    }
}
