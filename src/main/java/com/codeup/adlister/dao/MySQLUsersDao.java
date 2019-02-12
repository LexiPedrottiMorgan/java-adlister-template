package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.List;


public class MySQLUsersDao implements Users {
    private Connection connection = null;


    public MySQLUsersDao(Config config) {
        try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username){
        String queryString = "SELECT * FROM users WHERE name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(queryString);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createUserFromResults(rs);
        } catch(SQLException e) {
            throw new RuntimeException("Error: Could not locate user ' " + username + " ' ", e);
        } catch(RuntimeException e) {
            throw new RuntimeException("Error: could not locate user ' " + username + " ' ", e);
        }
    }


    @Override
    public Long insert(User user) {
        String queryString = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch(SQLException e){
            throw new RuntimeException("Error creating new user.", e);
        }

    }



    private User createUserFromResults(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getLong(1));
            user.setUsername(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPassword(rs.getString(4));
        }catch(SQLException e){
            throw new RuntimeException("Error creating user", e);
        }
        return user;
    }

//  closes the class
}
