package com.api.financeiro.config.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void enviaMensagem(String nomeFila,Object mensagem){
        this.rabbitTemplate.convertAndSend(nomeFila,mensagem);
    }
}
