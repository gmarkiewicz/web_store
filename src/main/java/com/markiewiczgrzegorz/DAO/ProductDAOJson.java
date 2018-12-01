package com.markiewiczgrzegorz.DAO;

import com.google.gson.Gson;
import com.markiewiczgrzegorz.JsonPOJO;
import com.markiewiczgrzegorz.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAOJson implements ProductDAO {
    @Override
    public List<Product> fetchProcudts() {
        List<Product> products = new ArrayList<>();

        Gson gson = new Gson();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader("src/main/webapp/WEB-INF/jsonV1.json"));
            JsonPOJO jsonPOJO = gson.fromJson(br, JsonPOJO.class);

            if(jsonPOJO != null){
                for(Product product : jsonPOJO.getProducts()){
                    products.add(product);
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public void deleteProduct(String name) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateUser(Product product) {

    }
}
