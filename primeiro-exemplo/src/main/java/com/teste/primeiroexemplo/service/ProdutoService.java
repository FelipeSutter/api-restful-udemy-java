package com.teste.primeiroexemplo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.exception.ResourceNotFoundException;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;
import com.teste.primeiroexemplo.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    /**
     * Método que retorna uma lista de produtos.
     * 
     * @return Lista de produtos.
     */
    public List<ProdutoDTO> obterTodos() {
        // Acha todos os produtos
        List<Produto> produtos = repository.findAll();

        // Primeiro é declarado o stream, assim possibilitando fazer um arranjamento com
        // map, reduce ou qualquer outro. Após isso é feito o map e transformado o
        // produto em um modelMapper. No final é retornado uma collection de lista
        return produtos
                .stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Retorna um produto com base no id
     * 
     * @param id do produto que será encontrado
     * @return retorna um produto caso seja encontrado. Optional
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {

        // Procura um produto com esse id, é um optional pois pode ou não existir.
        Optional<Produto> produto = repository.findById(id);

        // Se estiver vazio lança uma exception
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto com o id " + id + " não encontrado.");
        }

        // Converte o produto em dto e retorna um Optional por conta do retorno da
        // função.
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);

    }

    /**
     * Método que adiciona um produto.
     * 
     * @param produto que será adicionado
     * @return Retorna um produto.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {

        // Primeiro setta o id como nulo
        produtoDto.setId(null);

        // Declara e converte o produtoDto em um produto
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);

        // Salva o produto no banco de dados
        produto = repository.save(produto);

        // Pega o valor do id de produto e setta no produtoDto e retorna o dto
        produtoDto.setId(produto.getId());

        return produtoDto;
    }

    /**
     * Remove um produto caso o id passado no parâmetro exista.
     * 
     * @param id que será deletado do banco
     */
    public void deletar(Integer id) {
        // Verificar se o id existe
        Optional<Produto> produto = repository.findById(id);

        if (produto.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Não foi possível deletar o produto com o id " + id + " pois ele não existe.");
        }

        repository.deleteById(id);

    }

    /**
     * Método que atualiza o produto na lista
     * 
     * @param produto que será atualizado.
     * @param id      do produto específico que será atualizado.
     * @return retorna o produto após atualizá-lo dentro da lista.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {

        // Verificar se esse produto existe antes de atualizar
        Optional<Produto> produtoExiste = repository.findById(id);
        if (produtoExiste.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Não foi possível atualizar o produto com o id " + id + " pois ele não existe.");
        }

        // Passar o id para o dto
        produtoDto.setId(id);
        // Criar um mapper
        ModelMapper mapper = new ModelMapper();
        // Converter o dto para entidade
        Produto produto = mapper.map(produtoDto, Produto.class);
        // Salvar o produto e retornar atualizado
        produto = repository.save(produto);

        return produtoDto;

    }

}
