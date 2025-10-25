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

    public void addToCart(String userId, CartItemRequest cartItemRequest) {
        // Convert CartItemRequest to CartItem entity
        CartItem cartItem = new CartItem();
        cartItem.setUserId(userId);
        cartItem.setProductId(cartItemRequest.getProductId());
        cartItem.setQuantity(cartItemRequest.getQuantity());

        // Save CartItem to the repository
        cartRepository.save(cartItem);
    }
    
}
