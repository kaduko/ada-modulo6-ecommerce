package com.example.adamodulo6ecommerce.pagamentos.adapters.in;

import com.example.adamodulo6ecommerce.pagamentos.adapters.PedidoMapper;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.PedidoCriadoEvent;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.ProdutoEsgotadoEvent;
import com.example.adamodulo6ecommerce.pagamentos.adapters.event.ProdutoEvent;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.in.TransacaoInputPort;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "multiGroup", topics = "multitype")
public class ConsumerKafka {

    private final TransacaoInputPort transacaoInputPort;
    private final PedidoMapper pedidoMapper;

    public ConsumerKafka(TransacaoInputPort transacaoInputPort, PedidoMapper pedidoMapper) {
        this.transacaoInputPort = transacaoInputPort;
        this.pedidoMapper = pedidoMapper;
    }

    @KafkaHandler
    public void pedidoCriado(PedidoCriadoEvent pedidoCriadoEvent) throws InterruptedException {
        transacaoInputPort.pagar(pedidoMapper.toDomain(pedidoCriadoEvent));
        System.out.println("Pagamento efetuado com sucesso: " + pedidoCriadoEvent.id());
    }

    @KafkaHandler
    public void produtoEsgotado(ProdutoEsgotadoEvent produtoEvent) throws InterruptedException {
        transacaoInputPort.reembolsar(pedidoMapper.toDomain(produtoEvent));
        System.out.println("Estorno efetuado com sucesso: " + produtoEvent.id());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("ENI Evento Nao Identificado: " + object);
    }
}
