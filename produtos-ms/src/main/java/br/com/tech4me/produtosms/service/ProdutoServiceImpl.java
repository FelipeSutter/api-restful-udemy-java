package br.com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.produtosms.model.Produto;
import br.com.tech4me.produtosms.repository.ProdutoRepository;
import br.com.tech4me.produtosms.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        return salvarProduto(produto);
    }

    @Override
    public List<ProdutoDto> obterTodos() {

        List<Produto> produtos = repository.findAll();

        return produtos.stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<ProdutoDto> obterPorId(Integer id) {

        Optional<Produto> produto = repository.findById(id);

        if (produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }

        return Optional.empty();

    }

    @Override
    public void deletarProduto(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ProdutoDto atualizarProduto(Integer id, ProdutoDto produto) {
        produto.setId(id);
        return salvarProduto(produto);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        Produto produtoEntidade = new Produto(produto.getId(), produto.getNome(), produto.getObservacao(),
                produto.getValor(), produto.getQuantidade(), produto.getDesconto(), produto.getAcrescimo());

        produtoEntidade = repository.save(produtoEntidade);

        return new ModelMapper().map(produtoEntidade, ProdutoDto.class);
    }

}
