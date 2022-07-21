package com.api.financeiro.service;

import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.entity.Usuario;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.mappers.PagamentoMapper;
import com.api.financeiro.repository.PagamentoRepository;
import com.api.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

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
