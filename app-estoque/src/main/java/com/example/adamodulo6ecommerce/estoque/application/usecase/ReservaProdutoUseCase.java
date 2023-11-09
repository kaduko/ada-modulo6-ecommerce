package com.example.adamodulo6ecommerce.estoque.application.usecase;

import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;
import com.example.adamodulo6ecommerce.estoque.application.ports.in.ReservaProdutoInputPort;
import com.example.adamodulo6ecommerce.estoque.application.ports.out.ReservaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaProdutoUseCase implements ReservaProdutoInputPort {

    @Autowired
    private ReservaRepositoryPort reservaRepositoryPort;


    @Override
    public Reserva reservar(Reserva reserva) {

        if(reserva.getProdutos().isEmpty()) throw new RuntimeException("Reserva sem produtos");
        reserva.getProdutos().forEach(produto -> {
            var produtoRecuperado = reservaRepositoryPort.buscarProduto(produto.getId());

            if(produtoRecuperado.getQuantidadeDisponivel() < produto.getQuantidadeDisponivel())
                throw new RuntimeException("Quantidade indisponível");
        });
        return reservaRepositoryPort.criarReserva(reserva);
    }
}