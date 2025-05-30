package com.cdac.tester;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.cdac.dao.CategoryDao;
import com.cdac.dao.CategoryDaoImpl;
import com.cdac.entities.Product;

public class AddProductsToExistingCategory {
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("High performance laptop");
        p1.setManufactureDate(LocalDate.of(2024, 1, 1));
        p1.setPrice(999.99);
        p1.setQuantity(10);

        Product p2 = new Product();
        p2.setName("Smartphone");
        p2.setDescription("Latest smartphone");
        p2.setManufactureDate(LocalDate.of(2024, 2, 1));
        p2.setPrice(699.99);
        p2.setQuantity(20);

        List<Product> productList = Arrays.asList(p1, p2);

        CategoryDao dao = new CategoryDaoImpl();
        dao.addProducts(1L, productList); // assuming category ID is 1

        System.out.println("✅ Products added to category!");
    }
}