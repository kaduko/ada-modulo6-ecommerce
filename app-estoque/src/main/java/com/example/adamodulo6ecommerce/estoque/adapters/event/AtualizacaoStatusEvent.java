package com.example.adamodulo6ecommerce.estoque.adapters.event;

import com.example.adamodulo6ecommerce.estoque.application.domain.StatusVenda;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AtualizacaoStatusEvent(@JsonProperty("status_venda") StatusVenda status, String motivo) {
}