package com.example.backfinal.controller;

import com.example.backfinal.dto.GetProductResponse;
import com.example.backfinal.dto.ProductResponse;
import com.example.backfinal.entity.Product;
import com.example.backfinal.repository.UserRepository;
import com.example.backfinal.service.FileUploadService;
import com.example.backfinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private FileUploadService fileUploadService;

    @Value("${project.image}")
    private String path;

//    @PostMapping("/")
//    public ResponseEntity<ProductResponse> saveProduct(@RequestPart("image") MultipartFile image, @RequestPart("product") Product product) throws IOException {
//        String imageName = fileUploadService.uploadImage(path, image);
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        com.example.backfinal.entity.User loggedInUser = userRepository.findByEmail(user.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException("Supplier not found with username or email:" + user.getUsername()));
//
//        return new ResponseEntity<ProductResponse>(productService.save(product, loggedInUser, imageName), HttpStatus.CREATED);
//
//    }

    @GetMapping("/")
    public List<GetProductResponse> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/bysupplier/{id}")
    public List<GetProductResponse> getAllProductsBySupplierId(@PathVariable("id") long id) {
        return productService.getByProductSupplierId(id);
    }

    @GetMapping("/{id}")
    public ProductResponse getByProductId(@PathVariable("id") long id) {
        return productService.getByProductId(id);
    }
}
