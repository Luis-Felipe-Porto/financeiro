package com.api.pagamento.service;


import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Produto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.exception.UserNotFoundException;
import com.api.pagamento.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
class PagamentoServiceTest {

    @Autowired
    private PagamentoService pagamentoService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @DisplayName("Deve realizar um pagamento passando Usuário e um pagamento")
    @Test
    public void teste_realizar_pagamento() throws UserNotFoundException {
        Usuario usuario = new Usuario("Felipe",1L);
        Produto caderno = new Produto("Caderno",29.00,"100@45");
        Pagamento pix = new Pagamento();
        usuario.comprarProduto(caderno);
        usuarioRepository.save(usuario);
        PagamentoDto pagamentoComPix = pagamentoService.realizarPagamento(usuario.getId(), pix);
        Assertions.assertThat(pagamentoComPix).isNotNull();
        Assertions.assertThat(pagamentoComPix.valor()).isEqualTo(caderno.getValor());
    }

}