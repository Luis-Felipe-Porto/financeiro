package com.api.pagamento.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar status 200 ao comparar um produto")
    public void test_endpoint_comprar_produto() throws Exception{
//            mockMvc.perform(post("/v1/pagamentos/cadastrar/"))
//                    .andExpect(status().is(200));
    }

}