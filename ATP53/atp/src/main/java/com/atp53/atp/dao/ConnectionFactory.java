package com.atp53.atp.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setJdbcUrl("jdbc:postgresql://localhost/postgres");
        pool.setUser("postgres");
        pool.setPassword("123456");
        pool.setMaxPoolSize(10);
        this.dataSource = pool;
    }

    public Connection getConnection() throws SQLException{        
        return this.dataSource.getConnection();
    }
}
