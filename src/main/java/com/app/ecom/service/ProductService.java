package com.app.ecom.service;


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



  

}
