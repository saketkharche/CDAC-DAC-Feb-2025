package com.voting.pojos;

public class User {
    private int id;
    private String email, password, name;
    private boolean status;

    public User(int id, String email, String password, String name, boolean status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.status = status;
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public boolean getStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }
}
