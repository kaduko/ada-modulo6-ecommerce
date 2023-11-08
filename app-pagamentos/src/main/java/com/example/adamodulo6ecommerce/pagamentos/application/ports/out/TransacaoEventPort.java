package com.example.adamodulo6ecommerce.pagamentos.application.ports.out;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;

public interface TransacaoEventPort {
    void pagamentoEfetuado(Pedido pedido);
    void estornoEfetuado(Pedido pedido);
}
