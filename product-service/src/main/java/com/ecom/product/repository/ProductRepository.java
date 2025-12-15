package com.ecom.product.repository;


import com.ecom.product.entity.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByIdInOrderById(List<@NotNull(message = "Product is mandatory") Integer> productIds);
}
