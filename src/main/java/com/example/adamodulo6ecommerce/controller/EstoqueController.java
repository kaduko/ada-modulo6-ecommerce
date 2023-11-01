package com.example.adamodulo6ecommerce.controller;

import com.example.adamodulo6ecommerce.model.Estoque;
import com.example.adamodulo6ecommerce.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueRepository repository;

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Estoque>>> getAllProducts() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok((List<Estoque>) repository.findAll()));
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Estoque>> getProductById(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Estoque product = repository.findById(id).orElse(null);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Estoque>> createProduct(@RequestBody Estoque estoque) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(repository.save(estoque)));
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Estoque>> updateProduct(@PathVariable Long id, @RequestBody Estoque updatedEstoque) {
        return CompletableFuture.supplyAsync(() -> {
            Estoque existingEstoque = repository.findById(id).orElse(null);
            if (existingEstoque != null) {
               //precisa ver a dinamica esperada
                return ResponseEntity.ok(repository.save(existingEstoque));
            } else {
                return ResponseEntity.notFound().build();
            }
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteProduct(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Estoque existingEstoque = repository.findById(id).orElse(null);
            if (existingEstoque != null) {
                repository.delete(existingEstoque);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        });
    }
}
