package com.example.adamodulo6ecommerce.estoque.adapters.in;

import com.example.adamodulo6ecommerce.estoque.adapters.dto.ReservaDto;
import com.example.adamodulo6ecommerce.estoque.application.ports.in.ReservaProdutoInputPort;
import com.example.adamodulo6ecommerce.estoque.application.utils.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaProdutoInputPort reservaProdutoInputPort;

    @Autowired
    private ReservaMapper reservaMapper;

    @PostMapping
    public ReservaDto reservar(@RequestBody ReservaDto reservaDto) {
        var reservaCriada = reservaProdutoInputPort.reservar(reservaMapper.toDomain(reservaDto));
        return reservaMapper.toDto(reservaCriada);
    }
}