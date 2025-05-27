package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Restaurant;
import com.cdac.entities.Tag;
import static com.cdac.utils.HibernateUtils.getFactory;

public class TagDaoImpl implements TagDao {

	@Override
	public String addTag(Tag newTag) {
		String mesg = "adding new tag failed !!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newTag);
			tx.commit();
			mesg = "added new tag with ID " + newTag.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String linkRestaurant(Long tagId, Long restaurantId) {
		String mesg = "Linking tag to restaurant failed !!!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get tag from its id
			Tag tag = session.get(Tag.class, tagId);
			// 4. get restaurant from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			// 5 - null checking
			if (tag != null && restaurant != null) {
				//tag -   restaurant (Tag *----->* Restaurant)
				tag.getRestaurants().add(restaurant);
				mesg="added restaurant to the tag ....";
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
