package com.api.financeiro.repository;

import com.api.financeiro.entity.DadosClientePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosClientePagamentoRepository extends JpaRepository<DadosClientePagamento, Long> {
}
