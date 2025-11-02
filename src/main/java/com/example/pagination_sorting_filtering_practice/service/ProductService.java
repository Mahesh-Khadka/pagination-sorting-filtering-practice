package com.example.pagination_sorting_filtering_practice.service;

import com.example.pagination_sorting_filtering_practice.entity.Product;
import com.example.pagination_sorting_filtering_practice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Add product
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    //Pagination + Sorting
    public Page<Product> getAllProduct(int page, int size, String sortBy, String order){
        Sort sort = order.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }

    //Filter by Category
    public Page<Product> getProductsByCategory(String category, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategory(category, pageable);
    }

    //Filter By PRice Range
    public Page<Product> getProductsByPriceRange(double minPrice, double maxPrice, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    }
}

