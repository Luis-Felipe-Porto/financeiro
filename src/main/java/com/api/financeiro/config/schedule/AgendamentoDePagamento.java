package com.api.financeiro.config.schedule;

import com.api.financeiro.config.rabbitmq.enums.RabbitMQConstantes;
import com.api.financeiro.config.rabbitmq.service.RabbitMQService;
import com.api.financeiro.dto.PagamentoClienteDto;
import com.api.financeiro.service.PagamentoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AgendamentoDePagamento {

    private static final String CRON_LATE_LOANS = "0 */1 * ? * *";
    @Value("${application.quantidade-pagamento}")
    private static Integer QTD_PAGAMENTO=50;

    private PagamentoService pagamentoService;
    private RabbitMQService rabbitMQService;

    public AgendamentoDePagamento(PagamentoService pagamentoService, RabbitMQService rabbitMQService) {
        this.pagamentoService = pagamentoService;
        this.rabbitMQService = rabbitMQService;
    }

    @Scheduled(cron = CRON_LATE_LOANS)
    public void realizarAgendamentoDePagamento(){
        List<PagamentoClienteDto> pagamentoClienteDtos = pagamentoService.pagamentoAgendados(QTD_PAGAMENTO);

        pagamentoClienteDtos.forEach(pagamentoClienteDto -> {
            rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_FINANCEIRO.getValue(),pagamentoClienteDto);
        });
        System.out.println("Pagamento ------- Agendado");
    }
}
