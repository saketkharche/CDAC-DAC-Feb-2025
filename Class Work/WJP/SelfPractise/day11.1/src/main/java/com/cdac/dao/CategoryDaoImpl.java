// src/main/java/com/cdac/dao/CategoryDaoImpl.java

package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Category;
import com.cdac.utils.HibernateUtils;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public Category saveCategory(Category category) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(category); // or session.save(category)
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Category category = null;

        try {
            category = session.get(Category.class, id);
        } finally {
            session.close();
        }

        return category;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Category category = null;

        try {
            String hql = "FROM Category WHERE categoryName = :categoryName";
            category = session.createQuery(hql, Category.class)
                    .setParameter("categoryName", categoryName)
                    .uniqueResult();
        } finally {
            session.close();
        }

        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Category category = session.get(Category.class, id);

            if (category != null) {
                session.delete(category);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}