package com.api.financeiro.config.rabbitmq.enums;

public enum RabbitMQConstantes {
    FILA_MARKETING("MARKETING"),
    FILA_CURSO("MARKETING"),
    FILA_FINANCEIRO("FINANCEIRO");

    private String value;

    RabbitMQConstantes(String rabbitmq) {
        value = rabbitmq;
    }

    public String getValue() {
        return value;
    }
}
