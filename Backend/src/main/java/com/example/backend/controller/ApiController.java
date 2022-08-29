package com.example.backend.controller;
import com.example.backend.dto.order.GetOrderResponse;
import com.example.backend.dto.order.OrderRequest;
import com.example.backend.dto.order.OrderResponse;
import com.example.backend.dto.product.GetProductResponse;
import com.example.backend.dto.product.ProductResponse;
import com.example.backend.services.OrderService;
import com.example.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("product/")
    public List<GetProductResponse> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("product/{id}")
    public ProductResponse getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping("product/supplier/{id}")
    public List<GetProductResponse> getAllProductsBySupplierId(@PathVariable long id) {
        return productService.getProductBySupplierId(id);
    }

    @GetMapping("/")
    public List<GetOrderResponse> getAllOrders()
    {
        return orderService.getAllOrders();
    }
}