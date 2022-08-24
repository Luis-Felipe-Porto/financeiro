package com.api.financeiro.mappers.impl;

import com.api.financeiro.dto.InformacaoCartaoDto;
import com.api.financeiro.dto.PagamentoClienteDto;
import com.api.financeiro.dto.PagamentoDto;
import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.InformacoesCartao;
import com.api.financeiro.entity.Pagamento;
import com.api.financeiro.mappers.PagamentoMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoMapperCustom implements PagamentoMapper {


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
        Pagamento pagamento = new Pagamento(clientePagamento.getValorCompra(),
                clientePagamento.getValorCompra().toString());
        pagamento.setDadosClientePagamento(clientePagamento);
        return pagamento;
    }
    public PagamentoClienteDto pagamentoToClienteDto(Pagamento pagamento){
        PagamentoDto pagamentoDto = this.pagamentoToPagamentoDto(pagamento);
        return new PagamentoClienteDto(pagamentoDto,
                informacaoCartaoToInformacaoCartaoDto(pagamento.getDadosClientePagamento().getInformacoesCartao()),
                pagamento.getDadosClientePagamento().getEmail(),
                pagamento.getDadosClientePagamento().getValorCompra());
    }
    private InformacaoCartaoDto informacaoCartaoToInformacaoCartaoDto(InformacoesCartao informacoesCartao){
        return new InformacaoCartaoDto(
                informacoesCartao.getNomeResponsavelCartao(),
                informacoesCartao.getNumeroCartao(),
                informacoesCartao.getMesCartaoExpiracao(),
                informacoesCartao.getAnoExpiracaoCartao(),
                informacoesCartao.getCodigoDeSeguranca());
    }


}
