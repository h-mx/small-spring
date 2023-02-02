package com.mx.springframework.jdbc.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface PreparedStatementCreator {

    PreparedStatement createPreparedStatement(Connection con) throws SQLException;
}
