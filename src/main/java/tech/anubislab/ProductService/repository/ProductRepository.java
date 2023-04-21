package tech.anubislab.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.anubislab.ProductService.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
