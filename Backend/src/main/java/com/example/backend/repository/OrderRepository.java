package com.example.backend.repository;
import com.example.backend.dto.order.GetOrderResponse;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository {
    @Query(value = "select product.*,o.id, o.quantity, o.total_price as totalPrice, o.created_at as orderDate, o.customer_id as customerId,o.status, u.full_name as customerName from orders o inner join users u on o.customer_id=u.id inner join (select p.id as productId, p.name as productName,p.price as productPrice, p.supplier_id as supplierId, u.full_name as supplierName from products p inner join users u on p.supplier_id=u.id ) as product on o.product_id=product.productId", nativeQuery = true)
    List<GetOrderResponse> getAllOrders();
}
