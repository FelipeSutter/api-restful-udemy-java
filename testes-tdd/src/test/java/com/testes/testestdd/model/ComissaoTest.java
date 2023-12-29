package com.testes.testestdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Colocar essa anotação para dizer que é uma classe de teste
@SpringBootTest
public class ComissaoTest {

    // Para cada caso de teste é criado um método e também se coloca uma anotação
    // indicando que é um teste
    @Test
    public void deve_calcular_100_reais_de_comissao_para_venda_de_1000_com_10_por_cento() {
        // Arrange
        Comissao comissao = new Comissao();
        Double valorVenda = 1000.0;
        Double valorComissao = 100.0;

        // Act
        Double valorCalculado = comissao.calcular(valorVenda);
        // Assert
        // o primeiro parâmetro é o valor que a gente espera que aconteça, o segundo é o
        // valor devido.
        Assertions.assertEquals(valorComissao, valorCalculado);
    }

    @Test
    public void deve_calcular_300_reais_de_comissao_para_venda_de_2000_com_15_por_cento() {
        // Arrange
        Comissao comissao = new Comissao();
        Double valorVenda = 2000.0;
        Double valorComissao = 300.0;

        // Act
        Double valorCalculado = comissao.calcular(valorVenda);
        // Assert
        // o primeiro parâmetro é o valor que a gente espera que aconteça, o segundo é o
        // valor devido.
        Assertions.assertEquals(valorComissao, valorCalculado);
    }

}
