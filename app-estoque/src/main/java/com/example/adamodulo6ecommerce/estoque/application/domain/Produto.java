package com.example.adamodulo6ecommerce.estoque.application.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Produto {

    private String id;
    private Integer quantidadeDisponivel;

    public Produto(String id, Integer quantidadeReservada) {
        this.id = id;
        this.quantidadeDisponivel = quantidadeReservada;
    }
}
