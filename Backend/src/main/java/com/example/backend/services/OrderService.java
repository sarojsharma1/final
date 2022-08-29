package com.example.backend.services;
import com.example.backend.dto.order.GetOrderResponse;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public List<GetOrderResponse> getAllOrders()
    {
        return orderRepository.getAllOrders();
    }

}
