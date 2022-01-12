package com.api.pagamento.controller;

import com.api.pagamento.entity.Usuario;
import com.api.pagamento.mappers.UserMapper;
import com.api.pagamento.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/v1/pagamentos")
@Controller
public record UsuarioController(UsuarioService usuarioService, UserMapper userMapper) {

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<Usuario> comprar(@RequestBody @Valid Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }
}
