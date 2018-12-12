package com.markiewiczgrzegorz.DAO;

import com.google.gson.Gson;
import com.markiewiczgrzegorz.DataFromJson;
import com.markiewiczgrzegorz.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJsonDAO implements ProductDAO {
    @Override
    public List<Product> fetchProcudts() {
        List<Product> products = new ArrayList<>();

        Gson gson = new Gson();
        BufferedReader br;

        try{
            br = new BufferedReader(new FileReader("src/main/webapp/WEB-INF/jsonV1.json"));
            DataFromJson dataFromJson = gson.fromJson(br, DataFromJson.class);

            if(dataFromJson != null){
                for(Product product : dataFromJson.getProducts()){
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
    public void deleteProduct(Integer id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateUser(Product product) {

    }
}
