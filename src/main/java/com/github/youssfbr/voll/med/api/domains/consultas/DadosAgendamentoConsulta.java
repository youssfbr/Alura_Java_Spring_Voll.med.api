package com.github.youssfbr.voll.med.api.domains.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(

        Long medicoId ,

        @NotNull
        Long pacienteId ,

        @NotNull
        @Future
        LocalDateTime data
) {
}
