package com.example.pagination_sorting_filtering_practice.repository;

import com.example.pagination_sorting_filtering_practice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategory(String category, Pageable pageable);
    Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);
}
