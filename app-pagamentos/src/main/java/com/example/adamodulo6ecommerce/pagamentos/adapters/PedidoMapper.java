package com.example.adamodulo6ecommerce.pagamentos.adapters;

import com.example.adamodulo6ecommerce.pagamentos.adapters.event.EstornoEfetuadoEvent;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.PagamentoEfetuadoEvent;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.ProdutoEsgotadoEvent;
import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.PedidoCriadoEvent;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {
    Pedido toDomain(PedidoCriadoEvent pedidoCriadoEvent);
    Pedido toDomain(ProdutoEsgotadoEvent produtoEsgotadoEvent);
    PagamentoEfetuadoEvent toPayEvent(Pedido pedido);
    EstornoEfetuadoEvent toRefundEvent(Pedido pedido);
}
