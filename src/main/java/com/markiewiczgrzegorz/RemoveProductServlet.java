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

@WebServlet(urlPatterns = "/Remove", name = "RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductJsonDAO();
        int productId = Integer.valueOf(request.getParameter("Index"));

        productDAO.deleteProduct(productId);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/Products");
        reqDisp.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
