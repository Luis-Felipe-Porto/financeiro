package com.api.pagamento.service;

import com.api.pagamento.entity.Produto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.repository.UsuarioRepository;
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
        Produto caneta = new Produto("Caneta",9.00);
        Produto produtoComprado = usuario.comprarProduto(caneta);
        Assertions.assertThat(produtoComprado).isNotNull();
        Assertions.assertThat(produtoComprado.getNome()).isEqualTo(caneta.getNome());
    }

}