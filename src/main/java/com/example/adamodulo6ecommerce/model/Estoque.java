package com.example.adamodulo6ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estoque")
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade_minima")
    private Integer quantidadeMinima;

    @Column(name = "quantidade_maxima")
    private Integer quantidadeMaxima;

    @Column(name="data_atualizacao")
    private String dataAtualizacao;

}