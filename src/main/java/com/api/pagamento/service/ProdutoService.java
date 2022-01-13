package com.api.pagamento.service;


import com.api.pagamento.dto.ProdutoDto;
import com.api.pagamento.entity.Produto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.exception.UserNotFoundException;
import com.api.pagamento.mappers.ProdutoMapper;
import com.api.pagamento.repository.ProdutoRepository;
import com.api.pagamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;


@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoMapper = produtoMapper;
    }
    @Transactional
    public ProdutoDto comprarProduto(Long usuarioId, @Valid Produto produto) throws UserNotFoundException {
        Usuario cliente = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
        cliente.comprarProduto(produto);
        produtoRepository.save(produto);
        return new ProdutoDto(produto.getId(),produto.getValor(),produto.getNome());
    }
}
