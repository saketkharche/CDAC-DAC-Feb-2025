package com.cdac.dao;

import com.cdac.entities.User;
import com.cdac.entities.UserRole;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		// user - transient
		String mesg = "Sign up failed!!!!!!!!";
		// 1. Get Hibernate Session from SessionFactory
		/*
		 * API of org.hibernate.SessionFactory public Session getCurrentSession() throws
		 * HibExc - Hibernate's SF chks if there is already existing Session - no ,
		 * creates the Session obj n rets it. - yes - rets existing session to the
		 * caller.
		 */
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);// t
		/*
		 * 2. Begin a Transaction Session API public Transaction beginTransaction()
		 * throws HibExc
		 */
		Transaction tx = session.beginTransaction();
		System.out.println(session.isOpen() + " " + session.isConnected());// t t
		try {
			/*
			 * Session API public void persist(Object transientObj) throws HibExc
			 */
			session.persist(user);// user : PERSISTENT - exists in L1 cache
			// not yet in db
			// => success
			tx.commit();
			/*
			 * Internals - tx.commit 1. session.flush() - triggers auto dirty checking -
			 * Hibernate checks the state of L1 cache with DB - new entity in L1 cache -
			 * insert - existing entity but with updated state - update - entity marked for
			 * removal - delete - no change - no DML quries ! 2. session.close() - L1 cache
			 * is destroyed(removed) from heap - Pooled out DB cn rets to DBCP (inc re
			 * usability -> inc scalability)
			 */
			mesg = "User signed up !" + user.getUserId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			/*
			 * Internals - session.close() -> pooled out DB cn rets to the DBCP n L1 cache
			 * is destroyed
			 * 
			 */
			// re throw the exception to caller - so that caller knows about it !
			throw e;
		}
		// user - DETACHED (from L1 cache , but corresponding rec exists in db)
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user = null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userId);// select
			/*
			 * Hibernate checks if entity already exists in L1 cache with given id ? - if
			 * not - select query -> RST processing -> rets null | persistent entity
			 */
//			user=session.get(User.class, userId);
//			user=session.get(User.class, userId);
//			user=session.get(User.class, userId);//reading from cache 
			/*
			 * in case of valid id - user - PERSISTENT(exists in L1 cache n DB)
			 */
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}
		return user;// user - Detached from L1 cache
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		String jpql = "select u from User u";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();// select
			// users - list of persistent entities
			tx.commit();// flush - DML - no , close
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return users;// users - list of DETACHED entities
	}

	@Override
	public List<User> getSelectedUsers(LocalDate start, LocalDate end1, UserRole role) {
		List<User> users = null;
		String jpql = "select u from User u where u.dob between :begin and :end and u.userRole=:rl";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("begin", start).setParameter("end", end1)
					.setParameter("rl", role).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}
		return users;
	}

	@Override
	public User userSignIn(String email1, String password1) {
		User user = null;
		String jpql = "select u from User u where u.email =:em and u.password=:pass";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email1).setParameter("pass", password1)
					.getSingleResult();// select
			// user - PERSISTENT | throws NoResultExc
			user.setPassword("1234567890");// modifying state of persistent entity
			tx.commit();/*
						 * Hibernate perform auto dirty checking upon commit session.flush() -> dirty
						 * checking -> update session.close() -> L1 cache destroyed , n db cn rets to
						 * the DBCP
						 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// session.close()
			// re throw exc to the caller
			throw e;
		}
		// user - DETACHED
		user.setPassword("asdfghjkl;");// modifying state of DETACHED entity -> no update query !
		return user;
	}

	@Override
	public List<String> getSelectedUsersFirstNames(UserRole role1) {
		List<String> firstNames = null;
		String jpql = "select u.firstName from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			firstNames = session.createQuery(jpql, String.class).setParameter("role", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return firstNames;
	}

	@Override
	public List<User> getSelectedUsersDetails(UserRole role1) {
		List<User> users = null;
		String jpql = "select new com.cdac.entities.User(u.firstName,u.lastName,u.dob) from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("role", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return users;
	}

	@Override
	public String updateUserDetails(LocalDate date1, double discount) {
		String mesg = "Updation failed !!!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		String jpql = "update User u set u.subscriptionAmount=u.subscriptionAmount-:disc where u.dob < :date";
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createMutationQuery(jpql).setParameter("disc", discount)
					.setParameter("date", date1).executeUpdate();
			tx.commit();
			mesg = "Updated " + updateCount + " no of users.....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg = "Deletion failed !!!!!!!!";
		User user = null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. Get User : persistent state , by id
			user = session.get(User.class, userId);
			if (user != null) {
				// user : persistent
				session.remove(user);// user : REMOVED (not yet removed from L1 cache n db , its simply marked for
										// removal!)
				mesg = "deleted user details ....";
			}

			tx.commit();/*
						 * session.flush -> dirty chking -> removed entity -> DML - delete session.close
						 * -> entity(L1) cache is destroyed , db cn rets to DBCP
						 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}
		// user - TRANSIENT
		return mesg;
	} // after method rets , user -marked for GC (doesn't exist !)

	@Override
	public String saveImage(Long userId, String path) throws IOException {
		String mesg = "saving image failed !!!!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3 . Get user from its id
			User user = session.get(User.class, userId);
			if (user != null) {
				// user - PERSISTENT
				// 4. Create java.io.File class instance wrapping path
				File file = new File(path);
				// 5. validate if file exists n its readable
				if (file.isFile() && file.canRead()) {
					// => existing readable file
					byte[] imgData = FileUtils.readFileToByteArray(file);
					// 6. simply call setter - setImage
					user.setImage(imgData);// modifying the state of persistent entity
					mesg = "image stored in db";
				}
			}
			tx.commit();/*
						 * session.flush -> dirty chking -> DML -update , session.close
						 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String restoreImage(String email, String path) throws IOException {
		String mesg = "Restoring image failed !!!!!";
		String jpql = "select u from User u where u.email=:em";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get User from its email (find by email)
			User user = session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.getSingleResult();
			// If control continues => user : persistent
			// 4. get image
			byte[] imgData = user.getImage();
			if (imgData != null) {
				// 5 write byte[] -> image file
				FileUtils.writeByteArrayToFile(new File(path), imgData);
				mesg = "image restored from db -> file";
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

}
