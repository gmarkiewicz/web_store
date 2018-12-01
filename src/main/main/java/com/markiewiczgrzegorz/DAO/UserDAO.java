package com.markiewiczgrzegorz.DAO;

import com.markiewiczgrzegorz.User;

import java.util.List;

public interface UserDAO {

    public List<User> searchAll();
    public User serachByName(String name);
    public void deleteUser(String name);
    public void deleteAll();
    public void updateUser(User user);
}
