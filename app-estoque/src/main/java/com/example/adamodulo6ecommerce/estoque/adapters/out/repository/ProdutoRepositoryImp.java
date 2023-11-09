package com.example.adamodulo6ecommerce.estoque.adapters.out.repository;

import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ReservaEntity;
import com.example.adamodulo6ecommerce.estoque.application.domain.Produto;
import com.example.adamodulo6ecommerce.estoque.application.domain.Reserva;
import com.example.adamodulo6ecommerce.estoque.application.ports.out.ReservaRepositoryPort;
import com.example.adamodulo6ecommerce.estoque.application.utils.ProdutoMapper;
import com.example.adamodulo6ecommerce.estoque.application.utils.ReservaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepositoryImp implements ReservaRepositoryPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public Produto buscarProduto(String idProduto) {
        var produtoentity = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produtoMapper.toDomain(produtoentity);
    }

    @Override
    @Transactional
    public Reserva criarReserva(Reserva reserva) {
        var reservaEntity = new ReservaEntity(reserva);
        reservaEntity.preparaInsert();
        var reservaSalva = reservaRepository.save(reservaEntity);

        reservaEntity.getProdutos().forEach(produto ->{
            produtoRepository.diminuiEstoque(produto.getProdutoId(), produto.getQuantidadeReservada());
        });

        return reservaMapper.toDomain(reservaSalva);
    }
}