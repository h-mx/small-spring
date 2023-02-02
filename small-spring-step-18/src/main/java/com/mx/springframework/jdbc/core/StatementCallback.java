package com.mx.springframework.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface StatementCallback<T> {

    T doInStatement(Statement statement) throws SQLException;
}
