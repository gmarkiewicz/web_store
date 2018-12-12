package com.markiewiczgrzegorz;

import com.markiewiczgrzegorz.DAO.UserDAO;
import com.markiewiczgrzegorz.DAO.UserJsonDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = "/Register", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserJsonDAO();
        List<User> users = userDAO.getAllUsers();
        User newUser = new User();

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String pwd = request.getParameter("pwd");

        boolean userExists = false;
        for(User user: users){
            if (user.getUsername().equalsIgnoreCase(username)){
                userExists = true;
                break;
            }
        }

        if(userExists == false) {
            newUser.setId(users.size() + 1);
            newUser.setUsername(username);
            newUser.setName(name);
            newUser.setSurname(surname);
            newUser.setPassword(pwd);
            newUser.setTotalCashSpent(0.0);
            newUser.setRole("user");

            userDAO.addUser(newUser);

            RequestDispatcher reqDips = request.getRequestDispatcher("/index.jsp");
            reqDips.forward(request, response);
        } else {
            RequestDispatcher reqDips = request.getRequestDispatcher("/register.jsp");
            response.getWriter().println("<font color=red>Użytkownik o takiej nazwie już istnieje.</font>");
            reqDips.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
