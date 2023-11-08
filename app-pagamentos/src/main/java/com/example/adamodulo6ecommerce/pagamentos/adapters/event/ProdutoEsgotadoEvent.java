package com.example.adamodulo6ecommerce.pagamentos.adapters.event;

public record ProdutoEsgotadoEvent(String idPedido,
                                   String id,
                                   String nome,
                                   String valor,
                                   String quantidade) {
}
