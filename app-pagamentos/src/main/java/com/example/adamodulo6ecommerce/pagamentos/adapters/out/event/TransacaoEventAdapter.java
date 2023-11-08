package com.example.adamodulo6ecommerce.pagamentos.adapters.out.event;

import com.example.adamodulo6ecommerce.pagamentos.application.domain.Pedido;
import com.example.adamodulo6ecommerce.pagamentos.application.ports.out.TransacaoEventPort;
import com.example.adamodulo6ecommerce.pagamentos.adapters.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vendaCriadaEventAdapter")
public class TransacaoEventAdapter implements TransacaoEventPort {

    @Value(value = "${multi.type.topic.name}")
    private String multiTypeTopicName;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public void pagamentoEfetuado(Pedido pedido) {
        kafkaTemplate.send(multiTypeTopicName, pedidoMapper.toPayEvent(pedido));
    }

    @Override
    public void estornoEfetuado(Pedido pedido) {
        kafkaTemplate.send(multiTypeTopicName, pedidoMapper.toRefundEvent(pedido));
    }
}
