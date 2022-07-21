package com.api.financeiro.controller;

import com.api.financeiro.dto.UsuarioDto;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.mappers.UserMapper;
import com.api.financeiro.service.UsuarioService;
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
    public ResponseEntity<UsuarioDto> comprar(@RequestBody @Valid Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }
}
