package com.api.financeiro.dto;

public record PagamentoClienteDto(PagamentoDto pagamentoDto,
                                  InformacaoCartaoDto informacaoCartaoDto,
                                  String email,
                                  Double valorCompra) {
}
