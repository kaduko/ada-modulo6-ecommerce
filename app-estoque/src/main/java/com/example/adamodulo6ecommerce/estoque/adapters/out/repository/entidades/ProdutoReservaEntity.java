package com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades;

import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name="produto_reserva")
@Data
@NoArgsConstructor
public class ProdutoReservaEntity {

    public ProdutoReservaEntity(Produto produto) {
        this.produtoId = produto.getId();
        this.quantidadeReservada = produto.getQuantidadeDisponivel();
    }

    @EmbeddedId
    private ProdutoReservaID id;

    @Column(name="produto_id", insertable = false, updatable = false)
    private String produtoId;

    @ManyToOne
    @JoinColumn(name="reserva_id", insertable = false, updatable = false)
    private ReservaEntity reserva;

    private Integer quantidadeReservada;

    @PrePersist
    private void montaPK(){
        this.id = new ProdutoReservaID(this.produtoId, this.reserva.getId());
    }


    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ProdutoReservaID implements Serializable {

        @Column(name="produto_id")
        private String produtoId;

        @Column(name="reserva_id")
        private String reservaId;
    }



}