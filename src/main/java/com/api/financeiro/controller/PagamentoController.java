package com.api.financeiro.controller;

import com.api.financeiro.config.logger.LoggerFinanceiroApplication;
import com.api.financeiro.config.rabbitmq.enums.RabbitMQConstantes;
import com.api.financeiro.config.rabbitmq.service.RabbitMQService;
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
public class PagamentoController{

    private final PagamentoService pagamentoService;
    private final UsuarioService usuarioService;

    public PagamentoController(PagamentoService pagamentoService, UsuarioService usuarioService) {
        this.pagamentoService = pagamentoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    @CircuitBreaker(name = "pagamentoTest",fallbackMethod = "agendarLiberacaoDeMatricula")
    public ResponseEntity<PagamentoDto> pagamento(@RequestBody DadosClientePagamento dadosClientePagamento)
            throws UserNotFoundException, InterruptedException {
        return ResponseEntity.ok(pagamentoService.realizarPagamento(dadosClientePagamento));
    }
    public ResponseEntity<PagamentoDto> agendarLiberacaoDeMatricula(DadosClientePagamento dadosClientePagamento,Exception exception){
        pagamentoService.agendarMatriculaDoAluno(dadosClientePagamento);
        LoggerFinanceiroApplication.logger.error(exception.getMessage());
        LoggerFinanceiroApplication.logger.warn("Agendamento de Matricula".concat(dadosClientePagamento.getEmail()));
        return ResponseEntity.ok(new PagamentoDto(1L,20.0,"Teste"));
    }
}
