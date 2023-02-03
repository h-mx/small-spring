package com.mx.springframework.test.service;


import com.mx.springframework.jdbc.support.JdbcTemplate;

import java.sql.SQLException;

public interface JdbcService {

    void saveDataWithTranslation() throws SQLException;

    void saveData(JdbcTemplate jdbcTemplate) ;
}
