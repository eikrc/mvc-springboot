package com.project.mvc.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.mvc.spring.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos de CRUD (save, findById, findAll, deleteById...) já vêm prontos.
    // Métodos de consulta personalizados podem ser adicionados aqui, se necessário.
}
