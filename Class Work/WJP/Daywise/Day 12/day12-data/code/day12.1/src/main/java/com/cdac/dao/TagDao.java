package com.cdac.dao;

import com.cdac.entities.Tag;

public interface TagDao {
	String addTag(Tag newTag);
	String linkRestaurant(Long tagId, Long restaurantId);
}
