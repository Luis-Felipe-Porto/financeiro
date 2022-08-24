package com.api.financeiro.dto;

import java.io.Serializable;

public record InformacaoCartaoDto (
        String nomeResponsavelCartao,
        Double numeroCartao,
        Integer mesCartaoExpiracao,
        Integer anoExpiracaoCartao,
        Integer codigoDeSeguranca) implements Serializable {
}
