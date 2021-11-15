package com.magdy.taxiwebappliction.dao.impl;


import com.magdy.taxiwebappliction.dao.Dao;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.OrderDao;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import org.apache.logging.log4j.LogManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    private static final String INSERT_ORDER = "INSERT  INTO taxi_order (data,client_id,driver_id) VALUES (?,?,?)";
    private static final String SELECT_ORDER = "select data,client_id,driver_id from taxi_order where id=?";
    private static final String SELECT_ALL_ORDER = "select * from taxi_order";
    private static final String UPDATE_ORDER = "update taxi_order set data=?,client_id=?,driver_id=? where id=?";
    private static final String DELETE_ORDER = "delete from taxi_order where id=?";


    @Override
    public Order save(Order order) throws DaoException {
        logger.info("SAVED_ORDER_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getData());
            preparedStatement.setLong(2, order.getClient().getId());
            preparedStatement.setLong(3, order.getDriver().getId());

            int rewSaved = preparedStatement.executeUpdate();
            if (rewSaved > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        order.setId(generatedKeys.getLong(1));
                        return order;
                    }

                }
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> saveAll(List<Order> list) throws DaoException {
        logger.info("SAVED_ALL_ORDER");

        for (Order order : list) {
            save(order);
        }
        return list;
    }

    @Override
    public Order selectById(long id) throws DaoException {
        logger.info("GET_ORDER_BY_ID");
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                long driverId = resultSet.getLong("driver_id");
                long clintId = resultSet.getLong("client_id");

                order = new Order(id, data, new Client(clintId), new Driver(driverId));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> selectAll() throws DaoException {
        logger.info("GET_ALL_ORDER_LIST");
        List<Order> orderList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER)) {

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String data = resultSet.getString("data");
                long driverId = resultSet.getLong("driver_id");
                long clintId = resultSet.getLong("client_id");

                orderList.add(new Order(id, data, new Client(clintId), new Driver(driverId)));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return orderList;
    }

    @Override
    public Order update(Order order) throws DaoException {
        logger.info("UPDATE_ORDER");
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getData());
            preparedStatement.setLong(2, order.getClient().getId());
            preparedStatement.setLong(3, order.getDriver().getId());
            preparedStatement.setLong(4, order.getId());
            preparedStatement.executeUpdate();

            return order;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_ORDER_BY_ID");
        boolean rewDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER)) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return rewDelete;
    }
}
