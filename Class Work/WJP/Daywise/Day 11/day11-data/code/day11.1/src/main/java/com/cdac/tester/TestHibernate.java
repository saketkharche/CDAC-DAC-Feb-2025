package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("hibernate up n running !");

		} // sf.close() -> clean DBCP

	}

}
