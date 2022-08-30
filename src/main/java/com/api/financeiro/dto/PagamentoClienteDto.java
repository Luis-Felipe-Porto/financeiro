package com.api.financeiro.dto;

import java.io.Serializable;

public record PagamentoClienteDto(Long idCliente,
                                  PagamentoDto pagamentoDto,
                                  InformacaoCartaoDto informacaoCartaoDto,
                                  String email,
                                  Double valorCompra) implements Serializable {
}
