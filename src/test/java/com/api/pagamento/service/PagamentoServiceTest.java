package com.api.pagamento.service;


import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Produto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PagamentoServiceTest {

    @Autowired
    private PagamentoService pagamentoService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @DisplayName("Deve realizar um pagamento passando Usuário e um pagamento")
    @Test
    public void teste_realizar_pagamento(){
        Usuario usuario = new Usuario("Felipe",1L);
        Produto caderno = new Produto("Caderno",29.00);
        Pagamento pix = new Pagamento();
        usuario.comprarProduto(caderno);
        usuarioRepository.save(usuario);
        Pagamento pagamentoComPix = pagamentoService.realizarPagamento(usuario.getId(), pix);
        Assertions.assertThat(pagamentoComPix).isNotNull();
        Assertions.assertThat(pagamentoComPix.getValor()).isEqualTo(caderno.getValor());
    }
    @DisplayName("Usuário realiza a comprar de um produto adicionando em uma lista")
    @Test
    public void teste_comprar_produto(){
        Usuario usuario = new Usuario("Felipe",1L);
        usuarioRepository.save(usuario);
        Produto caneta = new Produto("Caneta",9.00);
        Produto produtoComprado = usuario.comprarProduto(caneta);
        Assertions.assertThat(produtoComprado).isNotNull();
        Assertions.assertThat(produtoComprado.getNome()).isEqualTo(caneta.getNome());
    }

}