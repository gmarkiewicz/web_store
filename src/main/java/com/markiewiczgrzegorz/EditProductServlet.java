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

@WebServlet(urlPatterns = "/EditProduct", name = "EditProductServlet")
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductJsonDAO();
        Product newProduct = new Product();

        int productId = Integer.valueOf(request.getParameter("id"));
        String productName = request.getParameter("name");
        String productDescription = request.getParameter("description");
        double productPrice = Double.valueOf(request.getParameter("price"));
        int productQuantity = Integer.valueOf(request.getParameter("quantity"));

        newProduct.setId(productId);
        newProduct.setName(productName);
        newProduct.setDescription(productDescription);
        newProduct.setPrice(productPrice);
        newProduct.setQuantity(productQuantity);

        productDAO.updateProduct(newProduct);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/Products");
        reqDisp.include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
