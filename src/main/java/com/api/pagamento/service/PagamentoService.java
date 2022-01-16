package com.api.pagamento.service;

import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.exception.UserNotFoundException;
import com.api.pagamento.mappers.PagamentoMapper;
import com.api.pagamento.repository.PagamentoRepository;
import com.api.pagamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PagamentoMapper pagamentoMapper;

    public PagamentoService(PagamentoRepository pagamentoRepository, UsuarioRepository usuarioRepository, PagamentoMapper pagamentoMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.pagamentoMapper = pagamentoMapper;
    }
    @Transactional
    public PagamentoDto realizarPagamento(Long usuarioId,@Valid Pagamento pagamento) throws UserNotFoundException {
        Usuario cliente = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
        cliente.realizarPagamento(pagamento);
        pagamentoRepository.save(pagamento);

        return new PagamentoDto(pagamento.getId(),pagamento.getValor(),pagamento.getDescricao());
    }
}
