package com.example.adamodulo6ecommerce.pagamentos.application.ports.out;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.application.domain.StatusVenda;

public interface GatewayPagamentosPort {
    Pedido pay(Pedido pedido) throws InterruptedException;
    Pedido refund(Pedido pedido) throws InterruptedException;
}
