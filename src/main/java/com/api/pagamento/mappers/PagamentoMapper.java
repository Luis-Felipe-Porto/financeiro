package com.api.pagamento.mappers;

import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.entity.Pagamento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    List<PagamentoDto> pagamentosToPagamentoDtos(List<Pagamento> pagamento);
    PagamentoDto pagamentoToPagamentoDto(Pagamento pagamento);
    Pagamento pagamentoDtoToPagamento(PagamentoDto pagamentoDto);
}
