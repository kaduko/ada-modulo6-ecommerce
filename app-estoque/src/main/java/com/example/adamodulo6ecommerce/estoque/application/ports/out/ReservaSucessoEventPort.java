package com.example.adamodulo6ecommerce.estoque.application.ports.out;

import com.example.adamodulo6ecommerce.estoque.adapters.event.VendaEvent;

public interface ReservaSucessoEventPort {
    void estoqueReservadoComSucesso(VendaEvent vendaEvent);
}