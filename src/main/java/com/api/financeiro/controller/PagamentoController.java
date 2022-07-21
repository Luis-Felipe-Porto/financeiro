package com.api.financeiro.controller;

import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.service.PagamentoService;
import com.api.financeiro.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/pagamentos")
@Controller
public record PagamentoController (PagamentoService pagamentoService,UsuarioService usuarioService){

    @PostMapping("/{usuarioId}/pagar")
    public ResponseEntity<PagamentoDto> pagamento(@PathVariable Long usuarioId, @RequestBody Pagamento pagamento) throws UserNotFoundException {
        return ResponseEntity.ok(pagamentoService.realizarPagamento(usuarioId,pagamento));
        // comunicação assincrona com api estoque

    }
}
