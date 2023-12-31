package br.com.tech4me.produtosms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String observacao;

    private Date dataCadastro;

    private Double valor;

    private Integer quantidade;

    private Double desconto;

    private Double acrescimo;

    private Double valorTotal;

    public Produto() {

    }

    public Produto(Integer id, String nome, String observacao, Double valor, Integer quantidade,
            Double desconto, Double acrescimo) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.dataCadastro = new Date();
        this.valor = valor;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.valorTotal = ((valor + (valor * acrescimo / 100)) - (valor * desconto / 100)) * quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
