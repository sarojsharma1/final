package com.example.backend.entity;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name = "id",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id")
    private long id;
    private String name;
    private int stock;
    private int price;

    @ManyToOne
    @JoinColumn(name = "supplierId", updatable = false, referencedColumnName = "id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

