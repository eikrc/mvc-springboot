package com.project.mvc.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mvc.spring.models.Produto;
import com.project.mvc.spring.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto adicionarProduto(Produto produto) {
        // Garante que é uma inserção (o id é gerado pelo banco)
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto dados) {
        return produtoRepository.findById(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setPreco(dados.getPreco());
            return produtoRepository.save(existente);
        });
    }

    public boolean deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            return false;
        }
        produtoRepository.deleteById(id);
        return true;
    }
}
