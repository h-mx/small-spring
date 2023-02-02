package com.mx.springframework.jdbc.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface PreparedStatementCallback<T> {

    T doInPreparedStatement(PreparedStatement ps) throws SQLException;
}
