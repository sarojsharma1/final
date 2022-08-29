package com.example.backfinal.service;
import com.example.backfinal.dto.GetProductResponse;
import com.example.backfinal.dto.ProductResponse;
import com.example.backfinal.entity.Product;
import com.example.backfinal.entity.User;
import com.example.backfinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse save(Product product, User user, String image) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setStock(product.getStock());
        newProduct.setImage(image);
        newProduct.setUser(user);
        Product createdProduct = productRepository.save(newProduct);
        return getProductResponse(createdProduct);
    }

    public List<GetProductResponse> findAll() {
        return productRepository.findAllBy();
    }

    public ProductResponse getByProductId(long id){
        Product product = productRepository.findById(id).
                orElseThrow(() -> new Error("Product not found with id "+id));
        return getProductResponse(product);
    }

    public List<GetProductResponse> getByProductSupplierId(long id){
        return productRepository.findAllBySupplierId(id);
    }

    private ProductResponse getProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setStock(product.getStock());
        productResponse.setImage(product.getImage());
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());
        productResponse.setSupplierId(product.getUser().getId());
        productResponse.setSupplierName(product.getUser().getFullName());

        return productResponse;
    }

}
