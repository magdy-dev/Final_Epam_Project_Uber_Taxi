package com.magdy.taxiwebappliction.service;

import java.sql.Connection;

public class BaseService {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
