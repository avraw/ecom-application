package com.app.ecom.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;

import lombok.Data;

@Service
@Data
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();   
        updateProductFromRequest(product, productRequest);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setCategory(productRequest.getCategory());
        product.setImgUrl(productRequest.getImgUrl());
    }

    private ProductResponse mapToProductResponse(Product savedProduct) {

        ProductResponse response = new ProductResponse();

        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setDescription(savedProduct.getDescription());
        response.setPrice(savedProduct.getPrice());
        response.setStock(savedProduct.getStock());
        response.setCategory(savedProduct.getCategory());
        response.setImgUrl(savedProduct.getImgUrl());
        response.setActive(savedProduct.isActive());
    
        return response;
    }

    public Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {


        return productRepository.findById(id).map(x -> {
            updateProductFromRequest(x, productRequest);
            Product updatedProduct = productRepository.save(x);
            return mapToProductResponse(updatedProduct);
        
        });
    }

    public List<ProductResponse> getAllProducts() {
       return productRepository.findByIsActiveTrue().stream()
               .map(this::mapToProductResponse)
               .toList();

    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ProductResponse> getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToProductResponse);
    }

    public List<ProductResponse> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword).stream()
                .map(this::mapToProductResponse)
                .toList();
    }



  

}
