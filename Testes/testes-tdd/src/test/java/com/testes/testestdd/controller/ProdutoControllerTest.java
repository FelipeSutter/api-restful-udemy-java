package com.testes.testestdd.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.testes.testestdd.model.Produto;

@WebMvcTest
public class ProdutoControllerTest {

    // MockMvc
    // Mockito
    // Mock

    @Autowired
    private ProdutoController controller;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // Será executado antes de qualquer caso de teste por conta da anotação.
        // Esse cara vai simular uma requisição do controller instanciado acima
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_obter_todos() throws Exception {
        // Arrange
        // List<Produto> produtos = new ArrayList<Produto>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos"); // criando a requisição

        // Act
        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()); // esse método
                                                                                               // envia a
        // requisição
        // Assert
    }

}
