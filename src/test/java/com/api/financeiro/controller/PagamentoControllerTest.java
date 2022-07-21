package com.api.financeiro.controller;

import com.api.financeiro.service.PagamentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
class PagamentoControllerTest {
    @MockBean
    private PagamentoService pagamentoService;
    private MockMvc mockMvc;

    @DisplayName("Deve retornar um status 200 ao realizar um pagamento")
    @Test
    public void test_endpoint_pagamento()throws Exception{
//        Long id = 10L;
//        mockMvc.perform(post("/v1/pagamentos/"+id+"/pagar"))
//                .andExpect(status().is(200));
    }
}