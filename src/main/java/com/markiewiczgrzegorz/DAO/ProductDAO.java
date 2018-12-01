package com.markiewiczgrzegorz.DAO;

import com.markiewiczgrzegorz.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> fetchProcudts();
    public Product getById(Integer id);
    public void deleteProduct(String name);
    public void deleteAll();
    public void updateUser(Product product);
}
