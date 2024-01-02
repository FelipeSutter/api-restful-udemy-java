package com.testes.testestdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testes.testestdd.model.Produto;
import com.testes.testestdd.service.ProdutoService;

@WebMvcTest
public class ProdutoControllerTest {

    // MockMvc
    // Mockito
    // Mock

    @Autowired
    private ProdutoController controller;

    @MockBean
    private ProdutoService service;

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
        List<Produto> produtos = new ArrayList<Produto>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos"); // criando a requisição
        when(this.service.obterTodos()).thenReturn(produtos);

        // Act
        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()); // esse método
                                                                                               // envia a
        // requisição
        // Assert
    }

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_obter_por_id() throws Exception {
        // Arrange
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        Optional<Produto> optProduto = Optional.of(produto);

        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos/1"); // criando a requisição
        when(this.service.obterPorId(1)).thenReturn(optProduto);

        // Act
        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.id")
                .value(1)); // esse método
        // envia a
        // requisição
        // Assert
    }

    @Test
    public void deve_adicionar_o_produto() throws Exception {
        // Arrange
        Produto produto = new Produto();
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        // Transforma o objeto em um json, e todo valor que estiver dentro dele ficará
        // na estrutura de um json
        String json = new ObjectMapper().writeValueAsString(produto);

        var requestBuilder = MockMvcRequestBuilders.post("/api/produtos")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON); // criando a requisição

        // setta o id depois de fazer o post
        produto.setId(1);

        when(this.service.adicionar(produto)).thenReturn(produto);

        // Act
        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isCreated()); // esse método
        // envia a
        // requisição
        // Assert
    }

}
