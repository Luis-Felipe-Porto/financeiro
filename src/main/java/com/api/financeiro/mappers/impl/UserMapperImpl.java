package com.api.financeiro.mappers.impl;

import com.api.financeiro.dto.UsuarioDto;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.mappers.UserMapper;


public class UserMapperImpl implements UserMapper {


    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),usuario.getNome());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.nome());
    }
}
