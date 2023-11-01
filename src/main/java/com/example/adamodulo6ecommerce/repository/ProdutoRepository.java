package com.example.adamodulo6ecommerce.repository;

import com.example.adamodulo6ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}