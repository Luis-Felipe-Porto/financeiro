package com.api.financeiro.dto;

import java.io.Serializable;

public record ProdutoDto(Long id, Double valor, String nome) implements Serializable {
}
