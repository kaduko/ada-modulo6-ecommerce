package com.example.adamodulo6ecommerce.estoque.application.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Pedido {

    @Setter
    private String id;
    private String clienteId;
    private List<Produto> produtos;
    private BigDecimal valorTotal;
    private LocalDate dataVenda;
    private DadosPagamento dadosPagamento;
    @Setter
    private StatusVenda statusVenda;

    public Pedido(String clienteId, List<Produto> produtos, DadosPagamento dadosPagamento) {
        this.clienteId = clienteId;
        this.produtos = produtos;
        this.dataVenda = LocalDate.now();
        this.valorTotal = montaValorTotal();
        this.dadosPagamento = dadosPagamento;
        this.statusVenda = StatusVenda.PENDENTE;
    }

    private BigDecimal montaValorTotal() {
        return this.produtos.stream().map(produto -> produto.getValor().multiply(BigDecimal.valueOf(produto.getQuantidade()))).
                reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}