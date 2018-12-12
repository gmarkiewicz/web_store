package com.markiewiczgrzegorz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataFromJson {

    @SerializedName("users")
    @Expose
    private List<User> users = null;

    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
