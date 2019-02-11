package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: ensure the submitted information is valid
        if (request.getSession().getAttribute("user") == null || request.getSession().getAttribute("password") == null) {
            response.sendRedirect("/register");
            return;
        }
        // TODO: create a new user based off of the submitted information
          User user = new User(
                  request.getParameter("username"),
                  request.getParameter("password"),
                  request.getParameter("email")
          );

          DaoFactory.getUsersDao().insert(user);
          request.getSession().setAttribute("user", user);
        // TODO: if a user was successfully created, send them to their profile
          response.sendRedirect("/profile");
    }
}
