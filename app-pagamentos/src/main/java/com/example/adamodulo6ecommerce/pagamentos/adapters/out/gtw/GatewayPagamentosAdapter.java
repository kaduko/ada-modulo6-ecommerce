package com.example.adamodulo6ecommerce.pagamentos.adapters.out.gtw;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.application.domain.StatusVenda;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.out.GatewayPagamentosPort;
import com.example.adamodulo6ecommerce.pagamentos.adapters.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class GatewayPagamentosAdapter implements GatewayPagamentosPort {

    public static final int MAX = 5000;
    public static final int MIN_PAY = 1000;
    public static final int MIN_REFUND = 3000;
    private final Random random;

    @Autowired
    private final PedidoMapper pedidoMapper;

    @Override
    public Pedido pay(Pedido pedido) throws InterruptedException {
        //simula pagamento
        Thread.sleep(random.nextInt(MAX - MIN_PAY) + MIN_PAY);

        return pedido;
    }

    @Override
    public Pedido refund(Pedido pedido) throws InterruptedException {
        //simula reembolso
        Thread.sleep(random.nextInt(MAX - MIN_REFUND) + MIN_REFUND);

        return pedido;
    }
}
