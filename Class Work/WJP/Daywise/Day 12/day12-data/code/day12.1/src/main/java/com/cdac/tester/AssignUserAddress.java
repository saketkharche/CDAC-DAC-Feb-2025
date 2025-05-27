package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.AddressDao;
import com.cdac.dao.AddressDaoImpl;
import com.cdac.entities.Address;

public class AssignUserAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			AddressDao dao=new AddressDaoImpl();
			System.out.println("Enter user id");
			Long userId = sc.nextLong();
			System.out.println(
					"Enter adr details - adrLine1,  adrLine2,  city,  state,  country,  zipCode , phone");
			Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println(dao.assignUserAddress(userId,adr));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
