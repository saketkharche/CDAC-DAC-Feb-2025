package com.cdac.dao;

import com.cdac.entities.User;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		String mesg="Sign up failed!!!!!!!!";
		// 1. Get Hibernate Session from SessionFactory
		/*
		 * API of org.hibernate.SessionFactory 
		 * public Session getCurrentSession() throws HibExc
		 * - Hibernate's SF chks if there is already existing Session
		 * - no , creates the Session obj n rets it.
		 * - yes - rets existing session to the caller.
		 */
		Session session=getFactory().getCurrentSession();
		Session session2=getFactory().getCurrentSession();
		System.out.println(session==session2);//t
		/*
		 * 2. Begin a Transaction
		 * Session API
		 * public Transaction beginTransaction() throws HibExc
		 */
		Transaction tx=session.beginTransaction();
		System.out.println(session.isOpen()+" "+session.isConnected());//t t
		try {
			/*
			 * Session API
			 * public void persist(Object transientObj)  throws HibExc
			 */
			session.persist(user);
			//=> success
			tx.commit();
			mesg="User signed up !"+user.getUserId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw the exception to caller - so that caller knows about it !
			throw e;
		}
		return mesg;
	}

}
