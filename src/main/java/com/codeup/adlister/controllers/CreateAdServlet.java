package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: Don't allow ad creation unless a user is logged in
        // Need to check the session to see if there is a user logged in, if they are not, redirect to /login
        // https://www.baeldung.com/java-request-getsession
        // Calling getSession(false) retrieves the current session, and if one doesn't exist yet, returns null.
        HttpSession session = request.getSession(false);
        if (session.getAttribute("user") != null) {
            // Cast as (User) as session returns generic Object. Created user based on attribute, to be used to assign user id to ad
            User user = (User) session.getAttribute("user");
            Ad ad = new Ad(
                    // TODO: When a new ad is created, assign the user id of the logged in user to the ad
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");
        } else {
            response.sendRedirect("/login");
        }
    }
}
