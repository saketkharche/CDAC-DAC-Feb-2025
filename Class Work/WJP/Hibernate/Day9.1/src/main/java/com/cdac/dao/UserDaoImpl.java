package com.cdac.dao;

import static com.cdac.utils.Hibernateutils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entites.User;

public class UserDaoImpl implements UserDao {

	@Override
	public String signup(User user) {
		// user transient
		String mesg = "Sign up failed!!!!!!";
		// TODO Auto-generated method stub
		// get Hibernate Session form sessionfactory
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);
		Transaction tx = session.beginTransaction();
		System.out.println(session.isOpen() + " " + session.isConnected());
		try {
			session.persist(user);
			tx.commit();
			mesg = "User singed up!" + user.getUserId();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
				// re throw the eception to caller
				throw e;
			}
		}
		// user Detached(form l1 cache ,but the corresponding rec exist in db)
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		User user = null;
		// 1 get session from session factory
		Session session = getFactory().getCurrentSession();
		// 2 Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			user = session.get(User.class, userId);// select
			/*
			 * Hiberante check if entity already exist in l1 cache with givne id
			 *
			 * 
			 */
			// user = session.get(User.class, userId);
			// user = session.get(User.class, userId);
			// user = session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			return user;
		}
		return user;

	}

}
