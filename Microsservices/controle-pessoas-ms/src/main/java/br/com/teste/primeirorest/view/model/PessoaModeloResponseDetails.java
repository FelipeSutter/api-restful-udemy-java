package br.com.teste.primeirorest.view.model;

import java.util.List;

import br.com.teste.primeirorest.compartilhado.AnimalDto;

public class PessoaModeloResponseDetails extends PessoaModeloResponse {
    private List<AnimalDto> animais;

    public List<AnimalDto> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDto> animais) {
        this.animais = animais;
    }
}
