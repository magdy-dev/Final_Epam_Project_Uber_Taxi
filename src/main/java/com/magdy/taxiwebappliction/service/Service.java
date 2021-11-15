package com.magdy.taxiwebappliction.service;


import com.magdy.taxiwebappliction.dao.DaoException;

import java.util.List;

// interface should be generic
public interface Service<T> {



    T save(T t) throws DaoException, ServiceException;

    List<T> saveAll(List<T> list) throws DaoException, ServiceException;

    T selectById(long id) throws ServiceException;

    List<T> selectAll() throws ServiceException;

    T update(T t) throws ServiceException;

    boolean deleteById(long id) throws ServiceException;


}
