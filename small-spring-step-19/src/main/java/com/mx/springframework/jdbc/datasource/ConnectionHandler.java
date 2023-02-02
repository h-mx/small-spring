package com.mx.springframework.jdbc.datasource;

import java.sql.Connection;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface ConnectionHandler {

    Connection getConnection();

    default void releaseConnection(Connection connection) {

    }
}
