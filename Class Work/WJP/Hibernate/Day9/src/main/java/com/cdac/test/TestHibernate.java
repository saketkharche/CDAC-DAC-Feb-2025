package com.cdac.test;
import static com.cdac.utils.Hibernateutils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			System.out.println("Hibernate up n running!");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
