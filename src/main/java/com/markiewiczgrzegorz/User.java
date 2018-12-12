package com.markiewiczgrzegorz;


public class User {
    private Integer id;
    private String username;
    private String password;
    private Double totalCashSpent;
    private String name;
    private String surname;
    private String role;

    public User() {
    }

    public User(Integer id, String userName, String password, Double totalCashSpent, String name,
                String surname, String role) {
        this.id = id;
        this.username = userName;
        this.password = password;
        this.totalCashSpent = totalCashSpent;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getTotalCashSpent() {
        return totalCashSpent;
    }

    public void setTotalCashSpent(Double totalCashSpent) {
        this.totalCashSpent = totalCashSpent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\nUsername: " + getUsername() + "\nPassword: " + getPassword()
                + "\nTotal cash spent: " + getTotalCashSpent() + "\nName: " + getName() + "\nSurname: "
                + getSurname() + "\nRole: " + getRole();
    }
}


