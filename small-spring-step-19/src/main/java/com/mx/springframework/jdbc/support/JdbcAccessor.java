package com.mx.springframework.jdbc.support;

import com.mx.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public abstract class JdbcAccessor implements InitializingBean {

    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() {
        if (null == getDataSource()) {
            throw new IllegalArgumentException("Property 'datasource' is required");
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected DataSource obtainDataSource() {
        return getDataSource();
    }
}
