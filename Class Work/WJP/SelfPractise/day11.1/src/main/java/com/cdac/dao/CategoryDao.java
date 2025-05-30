// src/main/java/com/cdac/dao/CategoryDao.java

package com.cdac.dao;

import com.cdac.entities.*;

public interface CategoryDao {
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    CategoryDao getCategoryByName(String categoryName);
    void deleteCategory(Long id);
	void save(Category category);
}