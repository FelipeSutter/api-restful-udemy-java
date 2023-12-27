package br.com.teste.primeirorest.http;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.teste.primeirorest.compartilhado.AnimalDto;

/*
    Essa interface vai ser utilizada para se comunicar com outro microsserviço. 
    Nesse caso o microsservice é o controle-animais-ms, e dentro dela vão ser criados métodos que 
    utilizarão recursos tanto desse microsservice quanto o de animais.
*/

@FeignClient(name = "controle-animais-ms")
public interface AnimaisFeignClient {

    // Quando acontecer uma requisição para esse endpoint em animais, o id do dono
    // passará para o método de obterAnimais
    // recebendo as informações dos animais daquele dono em específico.
    @GetMapping(path = "/api/animais/{dono}/lista")
    List<AnimalDto> obterAnimais(@PathVariable Integer dono);

}
