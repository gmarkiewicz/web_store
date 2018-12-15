package com.markiewiczgrzegorz.DAO;

import com.google.gson.Gson;
import com.markiewiczgrzegorz.ContextConfiguration;
import com.markiewiczgrzegorz.DataFromJson;
import com.markiewiczgrzegorz.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJsonDAO implements ProductDAO {
    private static final String JsonPath = "/WEB-INF/jsonV1.json";
    private ContextConfiguration config = ContextConfiguration.getInstance();
    private InputStream input = config.getContext().getResourceAsStream(JsonPath);
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
    private Gson gson = new Gson();
    private DataFromJson dataFromJson = gson.fromJson(bufferedReader, DataFromJson.class);
    private List<Product> products = dataFromJson.getProducts();

    public ProductJsonDAO() throws IOException{
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(Integer id) {
        Product product = null;
            for(Product jsonProduct : products){
                if(jsonProduct.getId().equals(id)){
                    product = jsonProduct;
                    break;
                }
            }
        return product;
    }

    @Override
    public void deleteProduct(Integer id) {
        for(int i = 0; i < products.size(); i++) {
            Product jsonProduct = products.get(i);
            if (jsonProduct.getId().equals(id)) {
                products.remove(i);
                break;
            }
        }
        for(int i = 0; i < products.size(); i++){
            products.get(i).setId(i +1);
        }
        updateJson(products);
    }

    @Override
    public void deleteAll() {
        products.clear();
        updateJson(products);
    }

    @Override
    public void updateProduct(Product product) {
        boolean productExcist = false;
        int index = 0;
        for(int i = 0; i < products.size(); i++) {
            Product jsonProduct = products.get(i);
            if (jsonProduct.getId().equals(product.getId())) {
                productExcist = true;
                index = i;
                break;
            }
        }
        if(productExcist){
            products.set(index ,product);
        }else{
            products.add(product);
        }
        updateJson(products);
    }

    private void updateJson(List<Product> products) {
        dataFromJson.setProducts(products);
        String path = config.getContext().getRealPath(JsonPath);

        try{
            FileWriter writeToServer = new FileWriter(path);
            gson.toJson(dataFromJson, writeToServer);
            writeToServer.flush();
            writeToServer.close();
            input.close();
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
