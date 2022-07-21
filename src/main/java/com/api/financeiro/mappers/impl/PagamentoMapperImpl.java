package com.api.financeiro.mappers.impl;

import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.mappers.PagamentoMapper;

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

    @Override
    public Pagamento dadosClienteToPagamento(DadosClientePagamento clientePagamento) {

        return new Pagamento(clientePagamento.getValorCompra(),
                clientePagamento.getValorCompra().toString(),
                clientePagamento);
    }


}
