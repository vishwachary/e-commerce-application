package com.ecom.product.controller;

import com.ecom.product.dto.ProductPurchaseRequest;
import com.ecom.product.dto.ProductPurchaseResponse;
import com.ecom.product.dto.ProductResponse;
import com.ecom.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/welcome")
    public String welcome() {
        return "Welcome to Product Service";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> allProducts = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @PostMapping("/products/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }


}
