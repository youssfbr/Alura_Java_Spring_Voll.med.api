package com.github.youssfbr.voll.med.api.domains.consultas;

import java.time.LocalDateTime;

public record DadosDethamentoConsulta(

        Long id ,
        Long medicoId ,
        Long pacienteId ,
        LocalDateTime data
) {
}
