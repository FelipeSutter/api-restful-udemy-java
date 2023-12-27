package br.com.teste.primeirorest.view.model;

public class PessoaModeloResponse {
    protected Integer id;
    protected String nome;
    protected String sobrenome;

    // #region Get / Set
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    // #endregion

    public String getNomeCompleto() {
        return String.format("%s %s", nome, sobrenome);
    }
}
