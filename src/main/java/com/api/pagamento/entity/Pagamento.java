package com.api.pagamento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Double valor;
    @NotBlank
    @NotNull
    private String descricao;

    public Pagamento(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
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
}
