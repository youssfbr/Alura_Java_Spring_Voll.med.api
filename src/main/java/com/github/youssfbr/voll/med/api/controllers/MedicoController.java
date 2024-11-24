package com.github.youssfbr.voll.med.api.controllers;

import com.github.youssfbr.voll.med.api.medicos.DadosCadastroMedicoDTO;
import com.github.youssfbr.voll.med.api.medicos.IMedicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final IMedicoService medicoService;

    public MedicoController(IMedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        medicoService.cadastrar(dados);
    }
}
