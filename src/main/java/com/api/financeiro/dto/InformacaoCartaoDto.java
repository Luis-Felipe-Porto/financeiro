package com.api.financeiro.dto;

public record InformacaoCartaoDto(
        String nomeResponsavelCartao,
        Double numeroCartao,
        Integer mesCartaoExpiracao,
        Integer anoExpiracaoCartao,
        Integer codigoDeSeguranca) {
}
