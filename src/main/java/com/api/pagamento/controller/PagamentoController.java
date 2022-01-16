package com.api.pagamento.controller;

import com.api.pagamento.adapter.ClientPagamento;
import com.api.pagamento.adapter.ClienteServicePagamento;
import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.exception.UserNotFoundException;
import com.api.pagamento.service.PagamentoService;
import com.api.pagamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/pagamentos")
@Controller
public record PagamentoController (PagamentoService pagamentoService, UsuarioService usuarioService,
                                   ClientPagamento clientPagamento){

    @PostMapping("/{usuarioId}/pagar")
    public ResponseEntity<PagamentoDto> pagamento(@PathVariable Long usuarioId, @RequestBody Pagamento pagamento) throws UserNotFoundException {

        return ResponseEntity.ok(pagamentoService.realizarPagamento(usuarioId,pagamento));
        // comunicação assincrona com api estoque

    }
}
