package com.example.adamodulo6ecommerce.estoque.application.utils;

import com.example.adamodulo6ecommerce.estoque.adapters.dto.ReservaDto;
import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ProdutoReservaEntity;
import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ReservaEntity;
import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ReservaMapper {

    @Mapping(source="produtos", target="produtos", qualifiedByName = "mapProdutosEntity")
    Reserva toDomain(ReservaEntity reservaEntity);

    @Named("mapProdutosEntity")
    default List<Produto> mapProdutosEntity(List<ProdutoReservaEntity> produtos) {
        return produtos.
                stream().
                map(produtoEntity -> new Produto(produtoEntity.getProdutoId(), produtoEntity.getQuantidadeReservada()))
                .collect(Collectors.toList());
    }

    Reserva toDomain(ReservaDto reservaDto);

    ReservaDto toDto(Reserva reserva);
}