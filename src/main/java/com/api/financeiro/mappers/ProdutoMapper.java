package com.api.financeiro.mappers;

import com.api.financeiro.dto.ProdutoDto;
import com.api.financeiro.entity.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    List<ProdutoDto> produtosToProdutoDtos(List<Produto> produtos);
    ProdutoDto produtoToProdutoDto(Produto produto);
    Produto produtoDtoToProduto(ProdutoDto produtoDto);
}
