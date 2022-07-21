package com.api.financeiro.service;

import com.api.financeiro.dto.UsuarioDto;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.mappers.UserMapper;
import com.api.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UserMapper userMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UserMapper userMapper) {
        this.usuarioRepository = usuarioRepository;
        this.userMapper = userMapper;
    }
    @Transactional
    public UsuarioDto salvar(@Valid Usuario usuario){
        Usuario usuarioSaved = usuarioRepository.save(usuario);
        return new UsuarioDto(usuarioSaved.getId(),usuario.getNome());
    }
}
