package com.example.adamodulo6ecommerce.pagamentos.adapters.event;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.StatusVenda;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PagamentoEfetuadoEvent(String id,
                                     String idPedido,
                                     String valorTotal) {
}
