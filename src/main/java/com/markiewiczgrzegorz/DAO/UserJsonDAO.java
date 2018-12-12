package com.markiewiczgrzegorz.DAO;

import com.google.gson.Gson;
import com.markiewiczgrzegorz.ContextConfiguration;
import com.markiewiczgrzegorz.DataFromJson;
import com.markiewiczgrzegorz.User;


import java.io.*;
import java.util.List;

public class UserJsonDAO implements UserDAO {
    public static final String JsonPath = "/WEB-INF/jsonV1.json";
    private ContextConfiguration config = ContextConfiguration.getInstance();
    private InputStream input = config.getContext().getResourceAsStream(JsonPath);
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
    private Gson gson = new Gson();
    private DataFromJson dataFromJson = gson.fromJson(bufferedReader, DataFromJson.class);
    private List<User> users = dataFromJson.getUsers();

    public UserJsonDAO() throws IOException{
    }

    @Override
    public List<User> getAllUsers() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public User getUserById(Integer id) {
        User user = null;
        for (User jsonUser : users) {
            if (jsonUser.getId().equals(id)) {
                user = jsonUser;
            }
        }
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void addUser(User user){
        users.add(user);
        dataFromJson.setUsers(users);
        String path = config.getContext().getRealPath(JsonPath);

        try{
        FileWriter writeToServer = new FileWriter(path);
        gson.toJson(dataFromJson, writeToServer);
        writeToServer.flush();
        writeToServer.close();
        bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
