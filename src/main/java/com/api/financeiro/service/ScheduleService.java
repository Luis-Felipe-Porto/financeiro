package com.api.financeiro.service;

import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.InformacoesCartao;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.repository.DadosClientePagamentoRepository;
import com.api.financeiro.repository.PagamentoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private static final String CRON_LATE_LOANS = "* */2 * * * ?";
    private final PagamentoRepository pagamentoRepository;

    private final DadosClientePagamentoRepository dadosClientePagamentoRepository;

    public ScheduleService(PagamentoRepository pagamentoRepository, DadosClientePagamentoRepository dadosClientePagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.dadosClientePagamentoRepository = dadosClientePagamentoRepository;
    }

    @Scheduled(cron = CRON_LATE_LOANS)
    public void realizaPagamento(){
        List<Pagamento> pagamentosPendentes = pagamentoRepository.findAll();
        List<DadosClientePagamento> dadosCliente = pagamentosPendentes.stream()
                .map(Pagamento::getDadosClientePagamento)
                .toList();

        dadosCliente.forEach(dadosClientePagamento -> {
            InformacoesCartao informacoesCartao = dadosClientePagamento.getInformacoesCartao();
            dadosClientePagamentoRepository.pagar(dadosClientePagamento,informacoesCartao);
        });
        System.out.println("--------- Executando pagamentos ---------");
    }
}
