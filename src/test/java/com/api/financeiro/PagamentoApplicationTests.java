package com.api.financeiro;

import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.entity.Produto;
import com.api.financeiro.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PagamentoApplicationTests {

    @Test
    @DisplayName("Deve realizar varios comprar de produtos")
    void teste_compra_varios_produtos() {
        Usuario usuario = new Usuario("Felipe");
        Produto lapis = new Produto("Lapis",1.00,"300@44");
        Produto caneta = new Produto("Caneta",2.00,"355@097");
        Produto caderno = new Produto("Caderno",29.00,"7865@66");

        usuario.comprarProduto(lapis);
        usuario.comprarProduto(caderno);
        usuario.comprarProduto(caneta);

        Pagamento cartao = new Pagamento();
        Pagamento pagamento = usuario.realizarPagamento(cartao);
        Assertions.assertThat(pagamento.getValor()).isEqualTo(32.0);

    }
    @Test
    @DisplayName("Deve realizar uma compra de um produto")
    void teste_comprar_produto(){
        Usuario usuario = new Usuario("Felipe");
        Produto borracha = new Produto("borracha",1.50,"775@876");

        Produto produtoComprado =  usuario.comprarProduto(borracha);
        Assertions.assertThat(produtoComprado.getNome()).isEqualTo(borracha.getNome());
    }
    @Test
    @DisplayName("Deve pagar um produto")
    void teste_pagar_produto(){
        Usuario usuario = new Usuario("Felipe");
        Produto borracha = new Produto("borracha",1.50,"BOO@244");
        Produto produtoComprado =  usuario.comprarProduto(borracha);
        Pagamento boleto = new Pagamento();
        Pagamento pagamento = usuario.realizarPagamento(boleto);
        Assertions.assertThat(pagamento.getValor()).isEqualTo(1.50);
        Assertions.assertThat(produtoComprado.getNome()).isEqualTo(borracha.getNome());
    }
    @Test
    @DisplayName("Realizar pagamento sem produto")
    void teste_pagamento_sem_produto(){
        Usuario usuario = new Usuario("Felipe");
        Pagamento pix = new Pagamento();
        Pagamento pagamento = usuario.realizarPagamento(pix);
        Assertions.assertThat(pagamento.getValor()).isEqualTo(0.0);
    }

}
