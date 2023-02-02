package com.mx.springframework.jdbc.datasource;

import cn.hutool.core.lang.Assert;

import java.sql.Connection;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public class ConnectionHolder {

    private ConnectionHandler connectionHandler;

    private Connection currentConnection;

    public ConnectionHolder(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public ConnectionHolder(Connection connection) {
        this.connectionHandler = new SimpleConnectionHandler(connection);
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    protected boolean hasConnection() {
        return this.connectionHandler != null;
    }

    protected void setConnection(Connection connection) {
        // 释放当前连接
        if (this.currentConnection != null) {
            if (this.connectionHandler != null) {
                this.connectionHandler.releaseConnection(this.currentConnection);
            }
            this.currentConnection = null;
        }
        // 设置连接
        if (connection != null) {
            this.currentConnection = connection;
        }
    }

    protected Connection getConnection() {
        Assert.notNull(this.connectionHandler, "Active connection is required.");
        if (this.currentConnection == null){
            this.currentConnection = this.connectionHandler.getConnection();
        }
        return currentConnection;
    }
}
