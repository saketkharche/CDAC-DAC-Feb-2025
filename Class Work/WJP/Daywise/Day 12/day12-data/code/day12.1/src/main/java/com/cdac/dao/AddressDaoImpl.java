package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Address;
import com.cdac.entities.User;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignUserAddress(Long userId, Address adr) {
		String mesg="address linking failed !!!!!";
		//1. Get Session from SessionFactory
		Session session=getFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			//3. Get User from its id
			User user=session.get(User.class, userId);
			//4 null chking
			if(user != null)
			{
				//user : persistent , establish User ---> Address (uni dir)
				user.setMyAddress(adr);
				//session.persist(adr); - NOT required since CascadeType.ALL
				mesg="address assigned !";				
			}
			tx.commit();/* session.flush -> detects changes in User entity
			-> insert adr rec n update users table with adr_id
			*/
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw exc to the caller
			throw e;
		}
	
		return mesg;
	}

}
