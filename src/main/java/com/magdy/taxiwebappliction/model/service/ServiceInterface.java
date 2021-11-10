package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.Connection.ConnectionBuilder;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

// interface should be generic
public interface ServiceInterface<T> {

    Connection connection = ConnectionBuilder.getConnection();

    T save(T t) throws DaoException, ServiceException;

    List<T> saveAll(List<T> list) throws DaoException, ServiceException;

    T selectById(long id) throws ServiceException;

    List<T> selectAll() throws ServiceException;

    T update(T t) throws ServiceException;

    boolean deleteById(long id) throws ServiceException;


}
