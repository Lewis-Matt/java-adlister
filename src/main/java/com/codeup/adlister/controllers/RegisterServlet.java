package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        User user = new User(
                2, // How to set this w/o hardcoding??? Create a separate constructor w/o ID?
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password")
        );
        // Use Dao factory to create a new getUsersDao to insert user object into db
        DaoFactory.getUsersDao().insert(user);
        // TODO: if a user was successfully created, send them to their profile
        response.sendRedirect("/login");
    }
}
