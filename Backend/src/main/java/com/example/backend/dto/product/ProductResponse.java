package com.example.backend.dto.product;

public class ProductResponse {
    private long id;
    private String name;
    private int stock;
    private int price;
    private long supplierId;
    private String supplierName;

    public ProductResponse()
    {}

    public ProductResponse(long id, String name, int stock, int price, long supplierId, String supplierName) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
