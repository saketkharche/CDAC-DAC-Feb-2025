package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Category;
import com.cdac.entities.Product;

public interface CategoryDao {
    void save(Category category);
    void addProducts(Long categoryId, List<Product> products);
    Category getById(Long id);
}