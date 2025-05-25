package com.cdac.dao;

import static com.cdac.utils.Hibernateutils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entites.User;

public class UserDaoImpl implements UserDao {
	String mesg;

	@Override
	public String signup(User user) {
		// TODO Auto-generated method stub
		// get Hibernate Session form sessionfactory
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);
		Transaction tx = session.beginTransaction();
		System.out.println(session.isOpen() + " " + session.isConnected());
		try {
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
		return mesg;
	}

}
