package com.markiewiczgrzegorz;

import com.markiewiczgrzegorz.DAO.UserDAO;
import com.markiewiczgrzegorz.DAO.UserJsonDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/Login", name = "StoreLoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pwd");

        UserDAO userJsonDAO = new UserJsonDAO();
        List<User> users = userJsonDAO.getAllUsers();


        Boolean loggedIn = false;
        for (User user : users) {
            String loginDB = user.getUsername();
            String passwordDB = user.getPassword();

            if (user != null && login.equals(loginDB)
                    && password != null && password.equals(passwordDB)) {
                createCookie(response, user);

                request.getSession().setAttribute("userRole", user.getRole());
                response.sendRedirect("/Products");
                loggedIn = true;
            }
        }

        if(loggedIn == false){
            RequestDispatcher reqDisp = request.getServletContext().getRequestDispatcher("/index.jsp");
            response.getWriter().println("<font color=red>Jesteś niezalogowany lub blędne dane</font>");
            reqDisp.include(request, response);
        }
    }

    private void createCookie(HttpServletResponse response, User user) {
        Cookie loginCookie = new Cookie("login", user.getName());
        loginCookie.setMaxAge(30 * 60);
        response.addCookie(loginCookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
