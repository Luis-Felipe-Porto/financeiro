package com.api.financeiro.controller;

import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.service.PagamentoService;
import com.api.financeiro.service.UsuarioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/financeiro")
@Controller
public record PagamentoController (PagamentoService pagamentoService,UsuarioService usuarioService){

    @PostMapping()
//    @CircuitBreaker(name = "pagamento",fallbackMethod = "")
    public ResponseEntity<PagamentoDto> pagamento(@RequestBody DadosClientePagamento dadosClientePagamento)
            throws UserNotFoundException, InterruptedException {

        return ResponseEntity.ok(pagamentoService.realizarPagamento(dadosClientePagamento));
    }
}
