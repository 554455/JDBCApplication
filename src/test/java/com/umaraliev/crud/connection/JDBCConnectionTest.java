package com.umaraliev.crud.connection;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class JDBCConnectionTest{

    @Test
    public void testGetConnectJDBC() {
        JDBCConnection connection = new JDBCConnection();

        try {
            assertEquals(false, connection.getConnectJDBC().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}