package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.connection.ConnectionBuilder;

import java.sql.Connection;

public abstract class BaseDao {
    protected Connection connection = ConnectionBuilder.getConnection();

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
