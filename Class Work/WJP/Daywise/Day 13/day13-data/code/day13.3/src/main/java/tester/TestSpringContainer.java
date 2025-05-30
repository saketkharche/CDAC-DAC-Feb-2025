package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {

			System.out.println("SC up n running !");
			/*
			 * Task - call B.L method of PublicSchool bean - manageAcademics Method of
			 * o.s.beans.factory.BeanFactory <---- ApplicationContext <----
			 * ClassPathXmlApplicationContext public <T> T getBean(String beanId,Class<T>
			 * beanClass) throws BeansException
			 */
			PublicSchool school = 
					ctx.getBean("public_school", PublicSchool.class); // 1st demand
				// invoke B.L
			school.manageAcademics();
			school.organizeSportsEvent();

		} // JVM - ctx.close() -> shut SC ->
			// SC does not call destroy-method -> bean marked for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
