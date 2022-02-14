package com.umaraliev.crud.utils;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class JDBCUtilsTest {

    @Test
    public void testGetConnectJDBC() {
        JDBCUtils connection = new JDBCUtils();

        try {
            assertEquals(false, connection.getConnectJDBC().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
