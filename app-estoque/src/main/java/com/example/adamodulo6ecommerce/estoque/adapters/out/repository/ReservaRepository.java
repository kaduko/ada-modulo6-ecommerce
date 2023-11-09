package com.example.adamodulo6ecommerce.estoque.adapters.out.repository;

import com.example.adamodulo6ecommerce.estoque.adapters.out.repository.entidades.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, String> {
}