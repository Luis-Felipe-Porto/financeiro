package com.api.pagamento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    private Double valor;

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public Produto() {
    }
    public String getNome() {
        return nome;
    }
    public Double getValor() {
        return valor;
    }
}
