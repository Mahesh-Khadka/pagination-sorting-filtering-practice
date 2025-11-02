package com.example.pagination_sorting_filtering_practice.controller;

import com.example.pagination_sorting_filtering_practice.entity.Product;
import com.example.pagination_sorting_filtering_practice.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue ="5" ) int size,
                                        @RequestParam(defaultValue = "id") String sortBy,
                                        @RequestParam(defaultValue = "asc")String order ){
        return productService.getAllProduct(page, size, sortBy, order);
    }

    @GetMapping("/category")
    public Page<Product> getProductsByCategory(@RequestParam  String category,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size){
        return productService.getProductsByCategory(category, page, size);
    }

    @GetMapping("/Price")
    public Page<Product>getProductsByPriceRange(@RequestParam double minPrice,
                                                @RequestParam double maxPrice,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "5") int size){
        return productService.getProductsByPriceRange(minPrice, maxPrice, page, size);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
