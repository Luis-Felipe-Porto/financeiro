package com.api.financeiro.dto;

import java.io.Serializable;

public record PagamentoClienteDto(PagamentoDto pagamentoDto,
                                  InformacaoCartaoDto informacaoCartaoDto,
                                  String email,
                                  Double valorCompra) implements Serializable {
}
