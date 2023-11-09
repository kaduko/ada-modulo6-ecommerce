package com.example.adamodulo6ecommerce.estoque.adapters.out.repository;

import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    @Modifying
    @Query( value = "update PRODUTO set QUANTIDADE_DISPONIVEL = QUANTIDADE_DISPONIVEL - :quantidadeReservada where id = :produtoId", nativeQuery = true)
    void diminuiEstoque(@Param("produtoId") String produtoId, @Param("quantidadeReservada") Integer quantidadeReservada);
}