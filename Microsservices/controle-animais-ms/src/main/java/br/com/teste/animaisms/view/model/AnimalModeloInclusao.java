package br.com.teste.animaisms.view.model;

public class AnimalModeloInclusao {
    private Integer dono;
    private String nome;
    private Integer idade;
    private String raca;

    // #region Get / Set
    public Integer getDono() {
        return dono;
    }

    public void setDono(Integer dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    // #endregion
}
