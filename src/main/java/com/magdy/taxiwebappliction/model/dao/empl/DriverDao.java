package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.DaoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DriverDao implements DaoInterface<Driver> {

    private static final Logger logger = Logger.getLogger(DriverDao.class.getName());

    @Override
    public Driver save(Driver driver) throws DaoException {
        logger.info("SAVED_DRIVER_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO driver (name,last_Name,car_Number,email,password,phone_Number) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
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
            logger.info("driver can't save  dao driver");
            throw new DaoException(e.getMessage());
        }
        return driver;
    }


    @Override
    public List<Driver> saveAll(List<Driver> list) throws DaoException {
        logger.info("SAVED_ALL_DRIVER");
        for (Driver driver : list) {
            save(driver);
        }
        return list;
    }


    @Override
    public Driver selectById(long id) throws DaoException {
        logger.info("GET_DRIVER_BY_ID");
        Driver driver = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name,last_Name,car_Number,email,password,phone_Number from driver where id=?")) {
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
            logger.info("driver can't get  dao driver by id");
            throw new DaoException(e.getMessage());
        }
        return driver;
    }

    @Override
    public List<Driver> selectAll() throws DaoException {
        logger.info("GET_ALL_DRIVER_LIST");
        List<Driver> driverList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from driver")) {
            ResultSet resultSet = preparedStatement.getResultSet();
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
            logger.info("driver can't get all dao driver");
            throw new DaoException(e.getMessage());
        }
        return driverList;
    }

    @Override
    public Driver update(Driver driver) throws DaoException {
        logger.info("UPDATE_DRIVER");
        try (PreparedStatement preparedStatement = connection.prepareStatement("update driver set name=?,last_Name=?,car_Number=?,email=?,password=?,phone_Number=? where id=?", Statement.RETURN_GENERATED_KEYS)) {

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
            logger.info("driver can't update");
            throw new DaoException(e.getMessage());
        }


    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_DRIVER_BY_ID");
        boolean rewDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from driver where id=?")) {
            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.info("driver can't delete  dao driver");
            throw new DaoException(e.getMessage());

        }
        return rewDelete;
    }
}
