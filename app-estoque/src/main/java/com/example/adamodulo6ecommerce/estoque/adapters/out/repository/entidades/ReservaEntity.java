package com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades;


import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="reserva")
@Data
@NoArgsConstructor
public class ReservaEntity {

    public ReservaEntity(Reserva reserva) {
        this.vendaId = reserva.getVendaId();
        this.produtos = reserva.getProdutos().stream().map(ProdutoReservaEntity::new).collect(Collectors.toList());
        this.dataReserva = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String vendaId;

    private LocalDate dataReserva;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva" , fetch = FetchType.EAGER)
    private List<ProdutoReservaEntity> produtos;

    public void preparaInsert(){
        this.produtos.forEach(produtoReservaEntity -> produtoReservaEntity.setReserva(this));
    }
}