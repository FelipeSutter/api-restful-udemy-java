package com.testes.testestdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

    @Test
    public void deve_calcular_valor_total_produto() {
        // Arrange
        Produto produto = new Produto();
        produto.setQuantidade(10);
        produto.setDesconto(10.0);
        produto.setAcrescimo(0.0);
        produto.setValor(10.0);

        Double valorEsperado = 90.0;

        // Act
        Double resultado = produto.calcularValorTotal();
        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

}
