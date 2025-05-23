package com.cdac.tester;

import java.sql.Date;
import java.util.Scanner;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

public class TestLayeredApplication {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            UserDaoImpl dao = new UserDaoImpl();

            System.out.println("Options:\n1. Sign In\n2. Register Voter\n3. Change Password\n4. Delete Voter");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter email and password:");
                    User user = dao.signIn(sc.next(), sc.next());
                    System.out.println(user != null ? "Welcome, " + user.getFirstName() : "Invalid login!");
                    break;

                case 2:
                    System.out.println("Enter fn, ln, email, password, dob(yyyy-mm-dd):");
                    User newUser = new User();
                    newUser.setFirstName(sc.next());
                    newUser.setLastName(sc.next());
                    newUser.setEmail(sc.next());
                    newUser.setPassword(sc.next());
                    newUser.setDob(Date.valueOf(sc.next()));
                    String result = dao.registerVoter(newUser);
                    System.out.println(result);
                    break;

                case 3:
                    System.out.println("Enter email, old password, new password:");
                    System.out.println(dao.changePassword(sc.next(), sc.next(), sc.next()));
                    break;

                case 4:
                    System.out.println("Enter voter ID to delete:");
                    System.out.println(dao.deleteUser(sc.nextInt()));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            dao.cleanUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
