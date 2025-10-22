package com.app.ecom.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private String imgUrl;
    private boolean isActive;
}
