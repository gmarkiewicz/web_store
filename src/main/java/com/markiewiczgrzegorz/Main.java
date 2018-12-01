package com.markiewiczgrzegorz;

import com.markiewiczgrzegorz.DAO.ProductDAOJson;
import com.markiewiczgrzegorz.DAO.UserDAOJson;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        ProductDAOJson productDAOJson = new ProductDAOJson();
        products = productDAOJson.fetchProcudts();

        UserDAOJson userDAOJson = new UserDAOJson();
        User user = userDAOJson.getUserById(2);

        for(Product product : products){
            System.out.println("ID: " + product.getId() + "\n Name: " + product.getName()
            + "\n Description: " + product.getDescription() + "\n Price" + product.getPrice()
            + "\n Quantity: " + product.getQuantity());
        }


        System.out.println("id: " + user.getId() + "\nUsername: " + user.getUsername()
        + "\nPassword: " + user.getPassword() + "\nTotal cash spend: " + user.getTotalCashSpend()
        + "\nName: " + user.getName() + "\nSurname: " + user.getSurname() + "\nRole: " + user.getRole());
    }
}
