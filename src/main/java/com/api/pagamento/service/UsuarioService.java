package com.api.pagamento.service;

import com.api.pagamento.dto.UsuarioDto;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.mappers.UserMapper;
import com.api.pagamento.mappers.impl.UserMapperImpl;
import com.api.pagamento.repository.UsuarioRepository;
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
