package com.api.pagamento.mappers.impl;

import com.api.pagamento.dto.PagamentoDto;
import com.api.pagamento.entity.Pagamento;
import com.api.pagamento.mappers.PagamentoMapper;
import org.springframework.stereotype.Component;

import java.util.List;


public class PagamentoMapperImpl implements PagamentoMapper {


    @Override
    public List<PagamentoDto> pagamentosToPagamentoDtos(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(pagamento -> new PagamentoDto(pagamento.getId(),pagamento.getValor(),pagamento.getDescricao())).toList();
    }
    @Override
    public PagamentoDto pagamentoToPagamentoDto(Pagamento pagamento) {
        return new PagamentoDto(pagamento.getId(),pagamento.getValor(),pagamento.getDescricao());
    }
    @Override
    public Pagamento pagamentoDtoToPagamento(PagamentoDto pagamentoDto) {
        return new Pagamento(pagamentoDto.valor(),pagamentoDto.descricao());
    }
}
