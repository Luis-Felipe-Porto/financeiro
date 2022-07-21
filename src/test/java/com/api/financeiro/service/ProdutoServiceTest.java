package com.api.financeiro.service;

import com.api.financeiro.entity.Produto;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutoServiceTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @DisplayName("Usuário realiza a comprar de um produto adicionando em uma lista")
    @Test
    public void teste_comprar_produto(){
        Usuario usuario = new Usuario("Felipe",1L);
        usuarioRepository.save(usuario);
        Produto caneta = new Produto("Caneta",9.00,"87876");
        Produto produtoComprado = usuario.comprarProduto(caneta);
        Assertions.assertThat(produtoComprado).isNotNull();
        Assertions.assertThat(produtoComprado.getNome()).isEqualTo(caneta.getNome());
    }

}