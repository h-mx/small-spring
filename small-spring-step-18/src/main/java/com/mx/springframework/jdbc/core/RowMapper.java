package com.mx.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * sql行转换
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
