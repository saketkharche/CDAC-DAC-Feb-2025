package com.cdac.tester;

import java.sql.Date;
import java.util.Scanner;

import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

public class TestLayeredApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            UserDaoImpl dao = new UserDaoImpl();

            while(true) {
                System.out.println("\nChoose an option:\n1. Register voter\n2. Change password\n3. Delete voter\n4. Login\n5. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch(choice) {
                    case 1: // Register voter
                        System.out.println("Enter first name:");
                        String fn = sc.nextLine();

                        System.out.println("Enter last name:");
                        String ln = sc.nextLine();

                        System.out.println("Enter email:");
                        String email = sc.nextLine();

                        System.out.println("Enter password:");
                        String pwd = sc.nextLine();

                        System.out.println("Enter DOB (YYYY-MM-DD):");
                        String dobStr = sc.nextLine();
                        Date dob = null;
                        try {
                            dob = Date.valueOf(dobStr);
                            // Optional: Validate age > 21 years here
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid date format. Setting DOB as null.");
                        }

                        // By default active and role "Voter"
                        User newUser = new User(fn, ln, email, pwd, dob, true, "Voter");
                        String regMsg = dao.registerUser(newUser);
                        System.out.println(regMsg);
                        break;

                    case 2: // Change password
                        System.out.println("Enter your email:");
                        String e = sc.nextLine();
                        System.out.println("Enter old password:");
                        String oldPwd = sc.nextLine();
                        System.out.println("Enter new password:");
                        String newPwd = sc.nextLine();

                        String changePwdMsg = dao.changePassword(e, oldPwd, newPwd);
                        System.out.println(changePwdMsg);
                        break;

                    case 3: // Delete voter
                        System.out.println("Enter voter ID to delete:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        String delMsg = dao.deleteUser(id);
                        System.out.println(delMsg);
                        break;

                    case 4: // Login
                        System.out.println("Enter email:");
                        String loginEmail = sc.nextLine();
                        System.out.println("Enter password:");
                        String loginPwd = sc.nextLine();

                        User user = dao.signIn(loginEmail, loginPwd);
                        if(user != null) {
                            System.out.println("Login success");
                            System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName());
                        } else {
                            System.out.println("Invalid email or password!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        dao.cleanUp();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option! Try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
