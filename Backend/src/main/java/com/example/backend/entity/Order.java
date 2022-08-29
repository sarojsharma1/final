package com.example.backend.entity;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "orderId", allocationSize = 1)
    @GeneratedValue(generator = "orderId", strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer quantity;
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "customerId", updatable = false, referencedColumnName = "id")
    private User user;

    @OneToOne
    private Product product;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
