package com.api.pagamento.controller;

import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.service.PagamentoService;
import com.api.pagamento.service.UsuarioService;
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
    public ResponseEntity<Pagamento> pagamento(@PathVariable Long usuarioId, @RequestBody Pagamento pagamento){
        return ResponseEntity.ok(pagamentoService.realizarPagamento(usuarioId,pagamento));
        // comunicação assincrona com api estoque
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }
}
