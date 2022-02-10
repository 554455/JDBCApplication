package com.umaraliev.crud.connection;

import java.sql.*;

public class JDBCConnection {


    // JDBC Driver and database url

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud_application";


    // User and Password

    static final String USER = "root";
    static final String PASSWORD = "root";

    // Connection database


    public Connection getConnectJDBC()  {


        System.out.println("Registering JDBC driver...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Creating database connection...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
