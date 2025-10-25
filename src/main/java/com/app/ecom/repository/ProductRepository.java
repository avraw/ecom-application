package com.app.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.ecom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByIsActiveTrue();

    @Query("select p from Product p where p.isActive=true and p.stock > 0 and (lower(p.name) like lower(concat('%', :keyword, '%')) or lower(p.description) like lower(concat('%', :keyword, '%')))")
    public List<Product> searchProducts(String keyword);

}
