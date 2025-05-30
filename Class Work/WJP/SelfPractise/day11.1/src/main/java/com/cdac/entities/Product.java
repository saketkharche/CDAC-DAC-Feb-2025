// src/main/java/com/cdac/entities/Product.java

package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products", uniqueConstraints = {
    jakarta.persistence.UniqueConstraint(columnNames = { "name" })
})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    private Double price;
    private Integer quantity;

    // Many-to-One side of the relationship
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Constructor
    public Product(String name, String description, LocalDate manufactureDate, Double price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.quantity = quantity;
    }
}