package com.api.financeiro.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Double valor;
    @NotBlank
    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn
    private DadosClientePagamento dadosClientePagamento;

    public Pagamento(Long id, Double valor, String descricao, DadosClientePagamento dadosClientePagamento) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.dadosClientePagamento = dadosClientePagamento;
    }

    public Pagamento(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Pagamento(Double valor, String descricao, DadosClientePagamento dadosClientePagamento) {
        this.valor = valor;
        this.descricao = descricao;
        this.dadosClientePagamento = dadosClientePagamento;
    }

    public Pagamento(){
    }
    public Double getValor() {
        return valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public Pagamento pagar (Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
        return this;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDadosClientePagamento(DadosClientePagamento dadosClientePagamento) {
        this.dadosClientePagamento = dadosClientePagamento;
    }

    public DadosClientePagamento getDadosClientePagamento() {
        return dadosClientePagamento;
    }
}
