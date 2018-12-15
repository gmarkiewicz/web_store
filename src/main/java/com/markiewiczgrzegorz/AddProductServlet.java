package com.markiewiczgrzegorz;

import com.markiewiczgrzegorz.DAO.ProductDAO;
import com.markiewiczgrzegorz.DAO.ProductJsonDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddProduct", name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductJsonDAO();
        Product newProduct = new Product();

        int productId = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.valueOf(request.getParameter("quantity"));

        newProduct.setId(productId);
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);

        productDAO.updateProduct(newProduct);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/Products");
        reqDisp.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
