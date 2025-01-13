package com.example.demo2.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/mat_bang?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "2004";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database");
        }
    }

}
