package com.api.financeiro.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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