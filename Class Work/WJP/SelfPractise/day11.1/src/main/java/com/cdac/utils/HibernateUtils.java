package com.cdac.utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	/*
	 * to ensure singleton instance of the SF(SessionFactory)
	 * , create it from static init block
	 */
	static {
		System.out.println("in static init block");
		/*
		 * Create empty Configuration object .
		 * Populate it with hibernate properties using : configure()
		 * Build SF from it.		 * 
		 */
		factory=new Configuration() //empty config
				.configure() // config populated with props
				.buildSessionFactory();
		
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
}
