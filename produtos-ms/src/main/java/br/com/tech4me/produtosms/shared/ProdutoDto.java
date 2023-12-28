package br.com.tech4me.produtosms.shared;

import java.util.Date;

public class ProdutoDto {

    private Integer id;

    private String nome;

    private String observação;

    private Date dataCadastro;

    private Double valor;

    private Integer quantidade;

    private Double desconto;

    private Double acréscimo;

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

    public String getObservação() {
        return observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
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

    public Double getAcréscimo() {
        return acréscimo;
    }

    public void setAcréscimo(Double acréscimo) {
        this.acréscimo = acréscimo;
    }

}
