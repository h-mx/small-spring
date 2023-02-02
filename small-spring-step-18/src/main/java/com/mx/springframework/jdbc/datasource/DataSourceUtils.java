package com.mx.springframework.jdbc.datasource;

import com.mx.springframework.jdbc.CannotGetJdbcConnectionException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/2
 */
public abstract class DataSourceUtils {

    public static Connection getConnection(DataSource dataSource) {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException e) {
            throw new CannotGetJdbcConnectionException("Failed to obtain JDBC Connection", e);
        }
    }

    public static Connection doGetConnection(DataSource dataSource) throws SQLException {
        Connection connection = fetchConnection(dataSource);
        // TODO
        ConnectionHolder holderToUse = new ConnectionHolder(connection);
        return connection;
    }

    private static Connection fetchConnection(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new IllegalArgumentException("DataSource return null from getConnection():" + dataSource);
        }
        return connection;
    }

    public static void releaseConnection(Connection connection, DataSource dataSource) {
        try {
            doReleaseConnection(connection, dataSource);
        } catch (SQLException ex) {
//            logger.debug("Could not close JDBC Connection", ex);
        } catch (Throwable ex) {
//            logger.debug("Unexpected exception on closing JDBC Connection", ex);
        }
    }

    public static void doReleaseConnection(Connection connection, DataSource dataSource) throws SQLException {
        if (connection == null) return;
        doCloseConnection(connection, dataSource);
    }

    public static void doCloseConnection(Connection con, DataSource dataSource) throws SQLException {
        con.close();
    }
}
