package com.mx.springframework.test.service.impl;


import com.mx.springframework.jdbc.support.JdbcTemplate;
import com.mx.springframework.stereotype.Component;
import com.mx.springframework.test.service.JdbcService;
import com.mx.springframework.tx.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Statement;

@Component
public class JdbcServiceImpl implements JdbcService {

    private Statement statement;

    public JdbcServiceImpl() {
    }

    public JdbcServiceImpl(Statement statement) {
        this.statement = statement;
    }

    @Override
    public void saveDataWithTranslation() throws SQLException {
        statement.execute("insert into teacher(teacher_name) values ('赵老师')");

        statement.execute("insert into user(id, username) values(1006, '小李')");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveData(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("insert into teacher(teacher_name) values ('李老师')");
        jdbcTemplate.execute("insert into user(id, username) values(1006, '小李')");
    }
}
