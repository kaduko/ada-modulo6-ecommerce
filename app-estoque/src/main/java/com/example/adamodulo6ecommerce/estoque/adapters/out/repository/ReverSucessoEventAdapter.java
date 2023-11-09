package com.example.adamodulo6ecommerce.estoque.adapters.out.repository;

import com.example.adamodulo6ecommerce.estoque.adapters.event.VendaEvent;
import com.example.adamodulo6ecommerce.estoque.application.ports.out.ReservaSucessoEventPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReverSucessoEventAdapter implements ReservaSucessoEventPort {

    @Autowired
    private KafkaTemplate<String, VendaEvent> kafkaTemplate;

    @Override
    public void estoqueReservadoComSucesso(VendaEvent vendaEvent){
        kafkaTemplate.send("estoque-sucesso", vendaEvent);
    }

}