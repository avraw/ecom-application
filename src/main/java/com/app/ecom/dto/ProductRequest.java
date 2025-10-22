package com.app.ecom.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private String imgUrl;
}
