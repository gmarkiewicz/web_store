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
import java.util.List;

@WebServlet(urlPatterns = "/Products", name = "ProductsServlet")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductJsonDAO();
        List<Product> productList = productDAO.getAllProducts();

        request.getSession().setAttribute("products", productList);

        RequestDispatcher reqDisp = request.getRequestDispatcher("store.jsp");
        reqDisp.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
