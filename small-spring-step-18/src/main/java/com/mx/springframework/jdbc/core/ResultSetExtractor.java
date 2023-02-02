package com.mx.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface ResultSetExtractor<T> {

    T extractData(ResultSet rs) throws SQLException;
}
