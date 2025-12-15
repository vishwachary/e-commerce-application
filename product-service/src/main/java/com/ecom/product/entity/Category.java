package com.ecom.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    @SequenceGenerator(
            name = "category_seq_gen",
            sequenceName = "category_seq",
            allocationSize = 50
    )
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.REMOVE)
    private List<Product> products;
}
