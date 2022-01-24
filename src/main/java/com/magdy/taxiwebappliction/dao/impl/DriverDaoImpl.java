package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.Dao;
import com.magdy.taxiwebappliction.dao.DriverDao;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl extends BaseDao implements DriverDao {

    private static final Logger log= (Logger) LogManager.getLogger();
    private static final String INSERT_DRIVER = "INSERT  INTO driver (name,last_Name,car_Number,email,password,phone_Number) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_DRIVER = "select * from driver where id=?";
    private static final String SELECT_ALL_DRIVER = "select * from driver";
    private static final String UPDATE_DRIVER = "update driver set name=?,last_Name=?,car_Number=?,email=?,password=?,phone_Number=? where id=?";
    private static final String DELETE_DRIVER = "delete from driver where id=?";
    private static final String LOGIN_RIDE = "select * from driver where email=? and password=?";


    @Override
    public Driver save(Driver driver) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("SAVED_DRIVER_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRIVER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setString(3, driver.getCarNumber());
            preparedStatement.setString(4, driver.getEmail());
            preparedStatement.setString(5, driver.getPassword());
            preparedStatement.setString(6, driver.getPhoneNumber());

            int rewSaved = preparedStatement.executeUpdate();

            if (rewSaved > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        driver.setId(generatedKeys.getLong(1));
                        return driver;
                    }

                }
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }finally {
            pool.returnConnection(connection);
        }
        return driver;
    }


    @Override
    public List<Driver> saveAll(List<Driver> list) throws DaoException {
        log.info("SAVED_ALL_DRIVER");
        for (Driver driver : list) {
            save(driver);
        }
        return list;
    }


    @Override
    public Driver selectById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_DRIVER_BY_ID");
        Driver driver = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DRIVER)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String carNumber = resultSet.getString("car_Number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_Number");
                driver = new Driver(id, name, lastName, carNumber, email, password, phoneNumber);
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }finally {
            pool.returnConnection(connection);
        }
        return driver;
    }

    @Override
    public List<Driver> selectAll() throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ALL_DRIVER_LIST");
        List<Driver> driverList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String carNumber = resultSet.getString("car_Number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_Number");
                driverList.add(new Driver(id, name, lastName, carNumber, email, password, phoneNumber));
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }finally {
            pool.returnConnection(connection);
        }
        return driverList;
    }

    @Override
    public Driver update(Driver driver) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("UPDATE_DRIVER");
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DRIVER, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setString(3, driver.getCarNumber());
            preparedStatement.setString(4, driver.getEmail());
            preparedStatement.setString(5, driver.getPassword());
            preparedStatement.setString(6, driver.getPhoneNumber());
            preparedStatement.setLong(7, driver.getId());

            preparedStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            log.info("driver can't update");
            throw new DaoException(e.getMessage());
        }finally {
            pool.returnConnection(connection);
        }


    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("DELETE_DRIVER_BY_ID");
        boolean rewDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER)) {
            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());

        }finally {
            pool.returnConnection(connection);
        }
        return rewDelete;
    }

    public Driver login(String username, String password) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_CLIENT_BY_userName,Password");
        Driver driver = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_RIDE)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String carNumber = resultSet.getString("car_Number");
                String phoneNumber = resultSet.getString("phone_Number");
                driver = new Driver(id, name, lastName, carNumber, username, password, phoneNumber);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }finally {
            pool.returnConnection(connection);
        }
        return driver;
    }
}
