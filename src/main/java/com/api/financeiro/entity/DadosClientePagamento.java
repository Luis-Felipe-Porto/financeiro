package com.api.financeiro.entity;

import javax.persistence.*;

@Entity
public class DadosClientePagamento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documentoCliente;
    @OneToOne
    private InformacoesCartao informacoesCartao;
    private String email;
    private Double valorCompra;

    public DadosClientePagamento(Long id, String documentoCliente, InformacoesCartao informacoesCartao, String email, Double valorCompra) {
        this.id = id;
        this.documentoCliente = documentoCliente;
        this.informacoesCartao = informacoesCartao;
        this.email = email;
        this.valorCompra = valorCompra;
    }

    public DadosClientePagamento() {
    }

    public Long getId() {
        return id;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public InformacoesCartao getInformacoesCartao() {
        return informacoesCartao;
    }

    public String getEmail() {
        return email;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public void setInformacoesCartao(InformacoesCartao informacoesCartao) {
        this.informacoesCartao = informacoesCartao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

}
