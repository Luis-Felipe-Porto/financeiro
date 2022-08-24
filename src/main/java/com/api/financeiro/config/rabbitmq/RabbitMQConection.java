package com.api.financeiro.config.rabbitmq;


import com.api.financeiro.config.rabbitmq.enums.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection {
    private String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true,false,false);
    }

    private DirectExchange trocaDireta(){
        return new DirectExchange(NOME_EXCHANGE);
    }
    /*
        Precisamos de um relaciomento para poder relacionar um exchange
        a uma fila
     */
    private Binding relacionamento(Queue fila ,DirectExchange troca){
        return new Binding(fila.getName(),Binding.DestinationType.QUEUE,troca.getName(), fila.getName(), null);
    }
    @PostConstruct
    private void adiciona(){
        Queue filaFinanceiro = this.fila(RabbitMQConstantes.FILA_FINANCEIRO.getValue());

        DirectExchange troca = this.trocaDireta();

        Binding ligacaoMarketing = this.relacionamento(filaFinanceiro, troca);

        this.amqpAdmin.declareQueue(filaFinanceiro);

        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoMarketing);
    }
}
