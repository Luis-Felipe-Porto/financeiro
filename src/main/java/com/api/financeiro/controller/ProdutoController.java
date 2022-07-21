package com.api.financeiro.controller;

import com.api.financeiro.dto.ProdutoDto;
import com.api.financeiro.entity.Produto;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/pagamentos")
@Controller
public record ProdutoController(ProdutoService produtoService) {

    @PostMapping("/{usuarioId}/comprar")
    public ResponseEntity<ProdutoDto> comprar(@PathVariable Long usuarioId, @RequestBody Produto produto) throws UserNotFoundException {
        return ResponseEntity.ok(produtoService.comprarProduto(usuarioId, produto));
    }
}
