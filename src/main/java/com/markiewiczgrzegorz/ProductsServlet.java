package com.markiewiczgrzegorz;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@WebServlet(urlPatterns = "/Products", name = "ProductsServlet")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/jsonV1.json");
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));

        DataFromJson dataFromJson = gson.fromJson(bufferedReader, DataFromJson.class);
        List<Product> productList = dataFromJson.getProducts();

        request.getSession().setAttribute("products", productList);

        RequestDispatcher reqDisp = request.getRequestDispatcher("store.jsp");
        reqDisp.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
