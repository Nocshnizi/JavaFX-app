package com.example.laba4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/lab4multi";
        String user = "root";
        String password = "";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connacted to db");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return conn;
    }

    public void saveUserData(String name) {
        String sql = "INSERT INTO users(name) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Saved!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
