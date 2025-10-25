package com.app.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByIsActiveTrue();

}
