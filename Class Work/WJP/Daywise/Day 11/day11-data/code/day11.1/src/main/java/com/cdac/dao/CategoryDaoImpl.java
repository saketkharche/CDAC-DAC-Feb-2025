package com.cdac.dao;

import java.util.List;

import org.hibernate.Session;

import com.cdac.entities.Category;
import com.cdac.entities.Product;
import com.cdac.utils.HibernateUtils;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void save(Category category) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        session.persist(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addProducts(Long categoryId, List<Product> products) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        Category category = session.get(Category.class, categoryId);
        if (category != null) {
            for (Product p : products) {
                p.setCategory(category);
                category.addProduct(p);
            }
            session.merge(category);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Category getById(Long id) {
        Session session = HibernateUtils.getFactory().openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }
}