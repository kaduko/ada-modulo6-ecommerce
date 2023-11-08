package com.example.adamodulo6ecommerce.pagamentos.adapters.event;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.StatusVenda;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PedidoCriadoEvent(String id,
                                List<ProdutoEvent> produtos,
                                @JsonProperty("client_id") String clienteId,
                                String dataPedido,
                                String valorTotal,
                                @JsonProperty("dados_pagamento") DadosPagamentoEvent dadosPagamento,
                                @JsonProperty("status_venda") StatusVenda statusVenda) {
}
