package com.example.adamodulo6ecommerce.pagamentos.adapters.event;

import java.util.List;

public record EstornoEfetuadoEvent(String id,
                                   String idPedido,
                                   List<ProdutoEvent> produtos,
                                   String valorTotal) {
}
