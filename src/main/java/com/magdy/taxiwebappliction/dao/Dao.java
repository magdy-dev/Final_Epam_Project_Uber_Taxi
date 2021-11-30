package com.magdy.taxiwebappliction.dao;

import java.util.List;

// interface should be generic
public interface Dao<T> {


    T save(T t) throws DaoException;

    List<T> saveAll(List<T> list) throws DaoException;

    T selectById(long id) throws DaoException;

    List<T> selectAll() throws DaoException;

    T update(T t) throws DaoException;

    boolean deleteById(long id) throws DaoException;

}
