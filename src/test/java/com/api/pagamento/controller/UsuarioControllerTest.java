package com.api.pagamento.controller;

import com.api.pagamento.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
@WebMvcTest
@AutoConfigureMockMvc
class UsuarioControllerTest {
    static String PAGAMENTO_API = "/api/books";
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private UsuarioService usuarioService;

//    @DisplayName("Deve retornar um status 200 ao cadastrar um usuario")
//    @Test
//    public void test_endpoint_cadastar_usuario()throws Exception{
////        mockMvc.perform(post("/v1/pagamentos/cadastrar-usuario/"))
////                .andExpect(status().is(200));
//
//    }
}