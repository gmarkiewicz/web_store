package com.markiewiczgrzegorz.DAO;

import com.markiewiczgrzegorz.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public void deleteUser(Integer id);
    public void deleteAll();
    public void updateUser(User user);
    public void addUser(User user);
}
