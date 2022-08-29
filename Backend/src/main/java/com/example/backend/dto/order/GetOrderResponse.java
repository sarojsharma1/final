package com.example.backend.dto.order;


public interface GetOrderResponse {
    Long getId();
    String getName();
    int getStock();
    int getPrice();
    Long getSupplierId();
    String getSupplierName();
}
