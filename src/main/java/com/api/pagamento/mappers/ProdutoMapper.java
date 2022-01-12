package com.api.pagamento.mappers;

import com.api.pagamento.dto.ProdutoDto;
import com.api.pagamento.entity.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    List<ProdutoDto> produtosToProdutoDtos(List<Produto> produtos);
    ProdutoDto produtoToProdutoDto(Produto produto);
    Produto produtoDtoToProduto(ProdutoDto produtoDto);
}
