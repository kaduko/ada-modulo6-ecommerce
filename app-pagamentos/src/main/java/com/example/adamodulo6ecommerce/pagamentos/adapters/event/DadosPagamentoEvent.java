package com.example.adamodulo6ecommerce.pagamentos.adapters.event;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;


public record DadosPagamentoEvent(@JsonProperty("numero_cartao") String numeroCartao,
                                  @JsonProperty("tipo_pagamento") TipoPagamento tipoPagamento,
                                  @JsonProperty("nome_titular") String nomeTitular,
                                  @JsonProperty("data_validade") String dataValidade,
                                  @JsonProperty("codigo_seguranca") String codigoSeguranca) {
}
