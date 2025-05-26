package com.cdac.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		/*
		 * Create SF
		 * 1. Create Configuration class instance using def ctor
		 * 2. public Configuration configure() throws HibernateException
		 *  - rets loaded configuration from hibernate.cfg.xml
		 *  3. Build SF
		 *  public SessionFactory buildSessionFactory()
		 */
		factory=new Configuration() //empty config
				    .configure() //loaded config
				    .buildSessionFactory();
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
