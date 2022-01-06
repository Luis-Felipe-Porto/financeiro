package com.api.pagamento.controller;

import com.api.pagamento.entity.Usuario;
import com.api.pagamento.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public record UsuarioController(UsuarioService usuarioService) {

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> comprar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }
}
