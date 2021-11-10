package com.magdy.taxiwebappliction.model.dao;

import com.magdy.taxiwebappliction.Connection.ConnectionBuilder;
import com.magdy.taxiwebappliction.exception.DaoException;

import java.sql.Connection;
import java.util.List;
// interface should be generic
public interface DaoInterface<T> {

    Connection connection = ConnectionBuilder.getConnection();

    T save(T t) throws  DaoException;

    List<T> saveAll(List<T> list) throws DaoException;

    T selectById(long id) throws  DaoException;

    List<T> selectAll() throws  DaoException;

    T update(T t) throws  DaoException;

    boolean deleteById(long id) throws  DaoException;

}
