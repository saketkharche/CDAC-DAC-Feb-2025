package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContainer {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean-config.xml")) {

			System.out.println("SC up n running !");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
