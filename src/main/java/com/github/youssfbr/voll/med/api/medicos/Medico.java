package com.github.youssfbr.voll.med.api.medicos;

import com.github.youssfbr.voll.med.api.enderecos.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_medicos")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String nome;

    @Column(length = 100 , nullable = false , unique = true)
    private String email;

    @Column(length = 6 , nullable = false , unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(length = 100 , nullable = false)
    private Especialidade especialidade;

    @Column(length = 20 , nullable = false)
    private String whatsapp;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedicoDTO dados) {
        nome = dados.nome();
        email = dados.email();
        crm = dados.crm();
        especialidade = dados.especialidade();
        whatsapp =dados.whatsapp();
        telefone = dados.telefone();
        endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicoDTO dados) {

        if (dados.nome() != null) {
            nome = dados.nome();
        }

        if (dados.whatsapp() != null) {
            whatsapp = dados.whatsapp();
        }

        if (dados.telefone() != null) {
            telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }




}
