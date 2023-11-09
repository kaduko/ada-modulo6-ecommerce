package com.example.adamodulo6ecommerce.estoque.application.utils;

import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ProdutoEntity;
import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface ProdutoMapper {

    Produto toDomain(ProdutoEntity produtoEntity);

    ProdutoEntity toEntity(Produto produto);
}