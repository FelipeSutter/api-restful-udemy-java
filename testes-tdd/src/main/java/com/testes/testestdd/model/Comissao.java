package com.testes.testestdd.model;

public class Comissao {

    public Double calcular(Double valorVenda) {
        return valorVenda > 1000.0 ? valorVenda * 0.15 : valorVenda * 0.10;
    }

}
