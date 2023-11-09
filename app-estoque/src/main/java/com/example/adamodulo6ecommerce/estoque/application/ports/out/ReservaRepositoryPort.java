package com.example.adamodulo6ecommerce.estoque.application.ports.out;

import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;

public interface ReservaRepositoryPort {

    Produto buscarProduto(String idProduto);
    Reserva criarReserva(Reserva reserva);
}