package com.example.adamodulo6ecommerce.pagamentos.application.usecases;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.application.domain.StatusVenda;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.in.TransacaoInputPort;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.out.TransacaoEventPort;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.out.GatewayPagamentosPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class TransacaoUseCase implements TransacaoInputPort {

    private final TransacaoEventPort transacaoEventPort;

    private final GatewayPagamentosPort gatewayPagamentosPort;

    public TransacaoUseCase(@Qualifier("vendaCriadaAdapter") TransacaoEventPort transacaoEventPort, GatewayPagamentosPort gatewayPagamentosPort) {
        this.transacaoEventPort = transacaoEventPort;
        this.gatewayPagamentosPort = gatewayPagamentosPort;
    }

    public Pedido pagar(Pedido pedido) throws InterruptedException {
        var pedidoPago = gatewayPagamentosPort.pay(pedido);
        pedidoPago.setStatusVenda(StatusVenda.APROVADO);
        transacaoEventPort.pagamentoEfetuado(pedidoPago);
        return pedidoPago;
    }

    @Override
    public Pedido reembolsar(Pedido pedido) throws InterruptedException {
        var pedidoCancelado = gatewayPagamentosPort.refund(pedido);
        pedidoCancelado.setStatusVenda(StatusVenda.CANCELADO);
        transacaoEventPort.estornoEfetuado(pedidoCancelado);
        return pedidoCancelado;
    }
}
