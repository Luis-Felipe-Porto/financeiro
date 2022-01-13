package com.api.pagamento.mappers.impl;

import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.dto.UsuarioDto;
import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.mappers.UserMapper;


public class UserMapperImpl implements UserMapper {


    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getNome());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.nome());
    }
}
