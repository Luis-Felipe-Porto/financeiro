package com.api.financeiro.dto;

import java.io.Serializable;

public record UsuarioDto(Long id, String nome) implements Serializable {
}
