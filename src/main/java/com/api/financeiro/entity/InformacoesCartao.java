package com.api.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InformacoesCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeResponsavelCartao;
    private Double numeroCartao;
    private Integer mesCartaoExpiracao;
    private Integer anoExpiracaoCartao;
    private Integer codigoDeSeguranca;

    public InformacoesCartao(Long id, String nomeResponsavelCartao, Double numeroCartao, Integer mesCartaoExpiracao, Integer anoExpiracaoCartao, Integer codigoDeSeguranca) {
        this.id = id;
        this.nomeResponsavelCartao = nomeResponsavelCartao;
        this.numeroCartao = numeroCartao;
        this.mesCartaoExpiracao = mesCartaoExpiracao;
        this.anoExpiracaoCartao = anoExpiracaoCartao;
        this.codigoDeSeguranca = codigoDeSeguranca;
    }

    public InformacoesCartao() {

    }

    public String getNomeResponsavelCartao() {
        return nomeResponsavelCartao;
    }

    public Double getNumeroCartao() {
        return numeroCartao;
    }

    public Integer getMesCartaoExpiracao() {
        return mesCartaoExpiracao;
    }

    public Integer getAnoExpiracaoCartao() {
        return anoExpiracaoCartao;
    }

    public Integer getCodigoDeSeguranca() {
        return codigoDeSeguranca;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
