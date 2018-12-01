package com.markiewiczgrzegorz.DAO;

import com.google.gson.Gson;
import com.markiewiczgrzegorz.JsonPOJO;
import com.markiewiczgrzegorz.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJson implements UserDAO {
    private File path = new File("src/main/webapp/WEB-INF/jsonV1.json");
    private BufferedReader br = null;
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> fetchUsers() {


        Gson gson = new Gson();

        try{
            br = new BufferedReader(new FileReader(path));
            JsonPOJO jsonPOJO = gson.fromJson(br, JsonPOJO.class);

            if(jsonPOJO != null){
                for(User user : jsonPOJO.getUsers()){
                    users.add(user);
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Gson gson = new Gson();
        User user = null;

        try{
            br = new BufferedReader(new FileReader(path));
            JsonPOJO jsonPOJO = gson.fromJson(br, JsonPOJO.class);

            if(jsonPOJO != null){
                for(User userFromJson : jsonPOJO.getUsers()){
                    if(userFromJson.getId().equals(id)){
                        user = userFromJson;
                    }
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(String name) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateUser(User user) {

    }
}
