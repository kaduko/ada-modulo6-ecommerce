package com.example.adamodulo6ecommerce.estoque.application.ports.in;


import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;

public interface ReservaProdutoInputPort {
    Reserva reservar(Reserva reserva);
}