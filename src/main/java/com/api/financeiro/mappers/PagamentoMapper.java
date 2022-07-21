package com.api.financeiro.mappers;

import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.Pagamento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    List<PagamentoDto> pagamentosToPagamentoDtos(List<Pagamento> pagamento);
    PagamentoDto pagamentoToPagamentoDto(Pagamento pagamento);
    Pagamento pagamentoDtoToPagamento(PagamentoDto pagamentoDto);
}
