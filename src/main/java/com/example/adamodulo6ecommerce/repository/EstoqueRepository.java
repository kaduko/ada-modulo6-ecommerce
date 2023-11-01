package com.example.adamodulo6ecommerce.repository;

import com.example.adamodulo6ecommerce.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
