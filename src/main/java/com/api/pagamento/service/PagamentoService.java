package com.api.pagamento.service;

import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.entity.Usuario;
import com.api.pagamento.repository.PagamentoRepository;
import com.api.pagamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, UsuarioRepository usuarioRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Pagamento realizarPagamento(Long usuarioId, Pagamento pagamento){
        Optional<Usuario> cliente = usuarioRepository.findById(usuarioId);
        if(cliente.isPresent()){
            cliente.get().realizarPagamento(pagamento);
            pagamentoRepository.save(pagamento);
        }
        return pagamento;
    }
}
