package com.api.pagamento.service;

import com.api.pagamento.entity.Produto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.repository.ProdutoRepository;
import com.api.pagamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProdutoService(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Produto comprarProduto(Long usuarioId, Produto produto){
        Optional<Usuario> cliente = usuarioRepository.findById(usuarioId);
        cliente.ifPresent(value -> {
            value.comprarProduto(produto);
            produtoRepository.save(produto);
        });
        return produto;
    }
}
