package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.DriverDao;
import com.magdy.taxiwebappliction.dao.OwnerDao;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Owner;
import org.apache.logging.log4j.LogManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerDaoImpl extends BaseDao implements OwnerDao {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(OwnerDaoImpl.class);
    private static final String LOGIN_RIDE = "select * from owner where userName=? and password=?";


    public Owner login(String username, String password) throws DaoException {

        logger.info("GET_CLIENT_BY_userName,Password");
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_RIDE)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                return new Owner(id, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return null;
    }

    @Override
    public Owner save(Owner owner) throws DaoException {
        throw new DaoException("");
    }

    @Override
    public List<Owner> saveAll(List<Owner> list) throws DaoException {
        return null;
    }

    @Override
    public Owner selectById(long id) throws DaoException {
        throw new DaoException("");
    }

    @Override
    public List<Owner> selectAll() throws DaoException {
        throw new DaoException("");
    }

    @Override
    public Owner update(Owner owner) throws DaoException {
        throw new DaoException("");
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        throw new DaoException("");
    }
}
