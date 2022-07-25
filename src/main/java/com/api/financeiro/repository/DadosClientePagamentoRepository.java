package com.api.financeiro.repository;

import com.api.financeiro.entity.DadosClientePagamento;
import com.api.financeiro.entity.InformacoesCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosClientePagamentoRepository extends JpaRepository<DadosClientePagamento, Long> {

    @Query("select c from DadosClientePagamento c")
    void pagar(DadosClientePagamento dadosClientePagamento, InformacoesCartao informacoesCartao);
}
