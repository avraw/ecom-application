package com.app.ecom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    
    private final CartService cartService;
    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestHeader("X-User-Id") String userId, @RequestBody CartItemRequest cartItemRequest) {
        cartService.addToCart(userId, cartItemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
