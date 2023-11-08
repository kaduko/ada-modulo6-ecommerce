package com.example.adamodulo6ecommerce.pagamentos.application.ports.in;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.application.domain.Produto;

public interface TransacaoInputPort {
    Pedido pagar(Pedido pedido) throws InterruptedException;
    Pedido reembolsar(Pedido pedido) throws InterruptedException;
}
