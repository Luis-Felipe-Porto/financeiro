package com.api.financeiro.service;


import com.api.financeiro.dto.ProdutoDto;
import com.api.financeiro.entity.Produto;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.mappers.ProdutoMapper;
import com.api.financeiro.repository.ProdutoRepository;
import com.api.financeiro.repository.UsuarioRepository;
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
