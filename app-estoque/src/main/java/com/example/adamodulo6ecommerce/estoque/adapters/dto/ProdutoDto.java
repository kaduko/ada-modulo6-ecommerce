package com.example.adamodulo6ecommerce.estoque.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoDto(String id, @JsonProperty("quantidade_disponivel") Integer quantidadeDisponivel) {

}