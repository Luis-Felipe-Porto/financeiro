package com.api.financeiro.service;

import com.api.financeiro.config.feign.AcademicoClient;
import com.api.financeiro.config.rabbitmq.enums.RabbitMQConstantes;
import com.api.financeiro.config.rabbitmq.service.RabbitMQService;
import com.api.financeiro.dto.InformacaoCartaoDto;
import com.api.financeiro.dto.PagamentoClienteDto;
import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.exception.UserNotFoundException;
import com.api.financeiro.mappers.impl.PagamentoMapperCustom;
import com.api.financeiro.repository.DadosClientePagamentoRepository;
import com.api.financeiro.repository.PagamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    private final DadosClientePagamentoRepository dadosClientePagamentoRepository;

    private final PagamentoMapperCustom pagamentoMapperCustom;

    private final AcademicoClient academicoClient;

    public PagamentoService(PagamentoRepository pagamentoRepository, DadosClientePagamentoRepository dadosClientePagamentoRepository,
                            PagamentoMapperCustom pagamentoMapperCustom, AcademicoClient academicoClient) {
        this.pagamentoRepository = pagamentoRepository;
        this.dadosClientePagamentoRepository = dadosClientePagamentoRepository;
        this.pagamentoMapperCustom = pagamentoMapperCustom;
        this.academicoClient = academicoClient;
    }
    @Transactional
    public PagamentoDto realizarPagamento(@Valid DadosClientePagamento dadosClientePagamento) throws UserNotFoundException {
        dadosClientePagamentoRepository.save(dadosClientePagamento);
        Pagamento pagamento = pagamentoMapperCustom.dadosClienteToPagamento(dadosClientePagamento);
        pagamentoRepository.save(pagamento);
        /**
         * Altera Status de Matricula do Aluno
         * - chamar mircrosservice academico para liberar matricula
         * **/
        academicoClient.updateMatricula(dadosClientePagamento.getDocumentoCliente());
        return new PagamentoDto(pagamento.getId(),pagamento.getValor(),pagamento.getDescricao());
    }
    public List<PagamentoClienteDto> pagamentoAgendados(Integer quantidade){
        Pageable pageable = Pageable.ofSize(quantidade);
        Page<Pagamento> pagamentos = pagamentoRepository.findAllByPagamentoEfetuadoFalse(pageable);
        return pagamentos.map(pagamentoMapperCustom::pagamentoToClienteDto)
                .stream().toList();
    }
    public PagamentoDto salvarPagamentoEfetuado(PagamentoClienteDto pagamentoClienteDto){
        Optional<Pagamento> pagamentoCliente = pagamentoRepository.findById(pagamentoClienteDto.pagamentoDto().id());

        Pagamento pagamentoRealizado = pagamentoCliente.map(pagamento -> {
            pagamento.pagmentoEfetuado();
            return pagamentoRepository.save(pagamento);
        }).orElseThrow(() -> new RuntimeException("ERRO AO REALIZAR PAGAMENTO"));
        return pagamentoMapperCustom.pagamentoToPagamentoDto(pagamentoRealizado);
    }
}
