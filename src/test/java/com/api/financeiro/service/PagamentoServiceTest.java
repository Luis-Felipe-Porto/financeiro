package com.api.financeiro.service;


import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.*;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.repository.UsuarioRepository;
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
    public void teste_realizar_pagamento() throws UserNotFoundException, InterruptedException {
        Usuario usuario = new Usuario("Felipe",1L);
        Produto caderno = new Produto("Caderno",29.00,"100@45");
        Pagamento pix = new Pagamento();
        usuario.comprarProduto(caderno);
        usuarioRepository.save(usuario);
        InformacoesCartao felipe = new InformacoesCartao(1L, "Felipe", 2762.0, 2656, 265, 45);
        PagamentoDto pagamentoComPix = pagamentoService.realizarPagamento(
                new DadosClientePagamento(1L,"56445435",felipe,"luis.felipe@gmail.com",100.0));
        Assertions.assertThat(pagamentoComPix).isNotNull();
        Assertions.assertThat(pagamentoComPix.valor()).isEqualTo(caderno.getValor());
    }

}