package com.cdac.tester;

import com.cdac.dao.CategoryDao;
import com.cdac.dao.CategoryDaoImpl;
import com.cdac.entities.Category;

public class AddNewCategory {
    public static void main(String[] args) {
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("All electronic items");

        CategoryDao dao = new CategoryDaoImpl();
        dao.save(category);

        System.out.println("✅ Category added successfully!");
    }
}