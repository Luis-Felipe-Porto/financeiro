package com.api.pagamento.controller;

import com.api.pagamento.entity.Produto;
import com.api.pagamento.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public record ProdutoController(ProdutoService produtoService) {

    @PostMapping("/{usuarioId}/comprar")
    public ResponseEntity<Produto> comprar(@PathVariable Long usuarioId, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.comprarProduto(usuarioId, produto));
    }
}
