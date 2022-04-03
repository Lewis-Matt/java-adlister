package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    // Constructor - used only in DaoFactory
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        // Initialize User object that will hold the user that is returned from the search
        User user = null;
        try {
            // prepared statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // (placeholder position, value)
            stmt.setString(1, username);
            // Run the query
            ResultSet resultSet = stmt.executeQuery();
            // Move through the results
            resultSet.next();
            // Store the user info in a User object - javabean Model
            user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password"));
        } catch (SQLException e) {
            System.out.println("User not found.");
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        try {
            // Prepared statement
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Set the value of each placeholder
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            // Move through the results
            resultSet.next();
            // Return the first entry - what was inserted
            return resultSet.getLong(1);
        } catch (SQLException e) {
// Note that, in a try-catch, if you have a return statement in the 'try' block, you cannot just use `printStackTrace()` in the catch block. The problem is the exception isn't really handled properly nor is it allowed to escape. It won't stop the thread execution and will continue after the try block as in normal condition (thus requiring a return). You need to either try to recover from the exception (in the case that it is recoverable), or throw RuntimeException.
            throw new RuntimeException("Could not create user.");
        }
    }
}
