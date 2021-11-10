package com.magdy.taxiwebappliction.model.dao.empl;


import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.DaoInterface;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderDao implements DaoInterface<Order> {

    private static final Logger logger = Logger.getLogger(OrderDao.class.getName());


    @Override
    public Order save(Order order) throws DaoException {
        logger.info("SAVED_ORDER_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO taxi_order (data,client_id,driver_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
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
            logger.info("can't save  dao order");
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
        try (PreparedStatement preparedStatement = connection.prepareStatement("select data,client_id,driver_id from taxi_order where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                long driverId = resultSet.getLong("driver_id");
                long clintId = resultSet.getLong("client_id");

                order = new Order(id, data, new Client(clintId), new Driver(driverId));
            }
        } catch (SQLException e) {
            logger.info("order can't get  dao order by id");
            throw new DaoException(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> selectAll() throws DaoException {
        logger.info("GET_ALL_ORDER_LIST");
        List<Order> orderList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from taxi_order")) {

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String data = resultSet.getString("data");
                long driverId = resultSet.getLong("driver_id");
                long clintId = resultSet.getLong("client_id");

                orderList.add(new Order(id, data, new Client(clintId), new Driver(driverId)));
            }
        } catch (SQLException e) {
            logger.info("order can't get all dao order list");
            throw new DaoException(e.getMessage());
        }
        return orderList;
    }

    @Override
    public Order update(Order order) throws DaoException {
        logger.info("UPDATE_ORDER");
        try (PreparedStatement preparedStatement = connection.prepareStatement("update taxi_order set data=?,client_id=?,driver_id=? where id=?", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getData());
            preparedStatement.setLong(2, order.getClient().getId());
            preparedStatement.setLong(3, order.getDriver().getId());
            preparedStatement.setLong(4, order.getId());
            preparedStatement.executeUpdate();

            return order;
        } catch (SQLException e) {
            logger.info("order can't update dao order ");
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_ORDER_BY_ID");
        boolean rewDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from taxi_order where id=?")) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.info("order can't delete dao order ");
            throw new DaoException(e.getMessage());
        }
        return rewDelete;
    }
}
