package com.app.ecom.service;

import org.springframework.stereotype.Service;

import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public boolean addToCart(String userId, CartItemRequest cartItemRequest) {
        // Convert CartItemRequest to CartItem entity
        Optional<Product> productOpt = productRepository.findById(cartItemRequest.getProductId());
        if (!productOpt.isPresent()) {
            return false; // Product not found
        }
        Product product = productOpt.get();

        if (product.getStock() < cartItemRequest.getQuantity()) {
            return false; // Not enough stock
        }

        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            return false; // User not found
        }

        User user = userOpt.get();
    
}
