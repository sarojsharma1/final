package com.example.backend.dto.product;

public interface GetProductResponse {
        Long getId();
        String getName();
        int getStock();
        int getPrice();
        Long getSupplierId();
        String getSupplierName();
}
