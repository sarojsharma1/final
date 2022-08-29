package com.example.backend.services;
import com.example.backend.dto.product.GetProductResponse;
import com.example.backend.dto.product.ProductResponse;
import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    public List<GetProductResponse> findAll()
    {
        return productRepository.findAllBy();
    }

    public ProductResponse getProductById(long id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new Error("Product not found!!!"));
        return getProductResponse(product);
    }

    public List<GetProductResponse> getProductBySupplierId(long id){
        return productRepository.findAllBySupplierId(id);
    }

    public Product getProductDataById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new Error("Product not found with id " + id));
    }

    private ProductResponse getProductResponse(Product product) {
       ProductResponse productResponse = new ProductResponse();
       productResponse.setId(product.getId());
       productResponse.setName(product.getName());
       productResponse.setPrice(product.getPrice());
       productResponse.setStock(product.getStock());
       productResponse.setSupplierId(product.getUser().getId());
       productResponse.setSupplierName(product.getUser().getFullName());
       return productResponse;
   }
}
