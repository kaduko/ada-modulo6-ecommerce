package com.example.adamodulo6ecommerce.estoque.adapters.in;

import com.example.adamodulo6ecommerce.estoque.adapters.event.VendaEvent;
import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;
import com.example.adamodulo6ecommerce.estoque.application.ports.in.ReservaProdutoInputPort;
import com.example.adamodulo6ecommerce.estoque.application.ports.out.ReservaSucessoEventPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsumerVendaKafka {

    @Autowired
    private ReservaProdutoInputPort reservaProdutoInputPort;

    @Autowired
    private ReservaSucessoEventPort reservaSucessoEventPort;


    @KafkaListener(topics = "venda-criada", groupId = "estoque")
    public void consumirVenda(VendaEvent vendaEvent) {

        var produtos = montaListaProduto(vendaEvent);

        Reserva reserva = new Reserva(vendaEvent.id(), produtos);
        reservaProdutoInputPort.reservar(reserva);
        System.out.println("Venda criada: " + vendaEvent.id());

        reservaSucessoEventPort.estoqueReservadoComSucesso(vendaEvent);

    }

    private static List<Produto> montaListaProduto(VendaEvent vendaEvent) {
        return vendaEvent.produtos().stream().map(produto -> new Produto(produto.id(), Integer.valueOf(produto.quantidade()))).collect(Collectors.toList());
    }


}