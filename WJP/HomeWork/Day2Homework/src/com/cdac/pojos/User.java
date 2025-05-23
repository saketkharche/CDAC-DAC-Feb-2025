package com.cdac.pojos;

import java.sql.Date;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dob;
    private boolean status;  // active or not
    private String role;

    public User() { }

    public User(int id, String firstName, String lastName, String email, String password, Date dob, boolean status, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.status = status;
        this.role = role;
    }

    public User(String firstName, String lastName, String email, String password, Date dob, boolean status, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.status = status;
        this.role = role;
    }

    // Getters and setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
