package com.api.financeiro.dto;

import java.io.Serializable;

public record PagamentoDto(Long id, Double valor, String descricao) implements Serializable {

}
