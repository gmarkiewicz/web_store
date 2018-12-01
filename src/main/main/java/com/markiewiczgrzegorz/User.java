package com.markiewiczgrzegorz;


public class User {
    public enum Role{
        ADMIN,
        USER
    }
    private Integer id;
    private String userName;
    private String password;
    private Double totalCashSpend;
    private String name;
    private String surname;
    private Role role;

    public User() {
    }

    public User(Integer id, String userName, String password, Double totalCashSpend, String name, String surname, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.totalCashSpend = totalCashSpend;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getTotalCashSpend() {
        return totalCashSpend;
    }

    public void setTotalCashSpend(Double totalCashSpend) {
        this.totalCashSpend = totalCashSpend;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}


