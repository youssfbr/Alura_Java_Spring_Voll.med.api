package com.github.youssfbr.voll.med.api.domains.pacientes;

import com.github.youssfbr.voll.med.api.domains.enderecos.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "tb_pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String nome;

    @Column(length = 100 , nullable = false , unique = true)
    private String email;

    @Column(length = 14 , nullable = false , unique = true)
    private String cpf;

    @Column(length = 20 , nullable = false)
    private String whatsapp;

    private String telefone;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPacienteDTO dados) {
        ativo = true;
        nome = dados.nome();
        email = dados.email();
        whatsapp = dados.whatsapp();
        telefone = dados.telefone();
        cpf = dados.cpf();
        endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPacienteDTO dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        if (dados.endereco() != null)
            endereco.atualizarInformacoesEndereco(dados.endereco());
    }

    public void inativar() {
        this.ativo = false;
    }

}