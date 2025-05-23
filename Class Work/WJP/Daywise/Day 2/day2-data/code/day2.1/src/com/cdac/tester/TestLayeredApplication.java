package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

public class TestLayeredApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1.create dao instace - create dependency
			UserDaoImpl dao = new UserDaoImpl();
			// accept em n password
			System.out.println("Enter em n password");
			// invoke dao's method
			User user = dao.signIn(sc.next(), sc.next());
			if (user != null) {
				System.out.println("Login success");
				System.out.println("Hello ,  " + user.getFirstName() + " " + user.getLastName());
			} else
				System.out.println("Invalid email or password !");
			//clean up
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
