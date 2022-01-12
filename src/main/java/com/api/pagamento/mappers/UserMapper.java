package com.api.pagamento.mappers;

import com.api.pagamento.dto.UsuarioDto;
import com.api.pagamento.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UsuarioDto> usuarioToUsuarioDtos(List<Usuario> usuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
