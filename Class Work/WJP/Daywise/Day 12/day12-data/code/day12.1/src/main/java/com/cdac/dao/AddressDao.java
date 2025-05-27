package com.cdac.dao;

import com.cdac.entities.Address;

public interface AddressDao {

	String assignUserAddress(Long userId, Address adr);

}
