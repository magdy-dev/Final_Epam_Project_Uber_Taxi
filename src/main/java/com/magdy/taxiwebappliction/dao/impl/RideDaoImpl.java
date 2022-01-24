package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.RideDao;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideDaoImpl extends BaseDao implements RideDao {
    private static final Logger log = (Logger) LogManager.getLogger();
    private static final String INSERT_RIDE = "INSERT  INTO ride (address_id_from ,address_id_to,order_id) VALUES (?,?,?)";
    private static final String SELECT_RIDE = "select address_id_from ,address_id_to,order_id from ride where id=?";
    private static final String SELECT_ALL_RIDE = "select * from ride";
    private static final String UPDATE_RIDE = "update ride set address_id_from=?,address_id_to=?,order_id=? where id=?";
    private static final String DELETE_RIDE = "delete from ride where id=?";


    @Override
    public Ride save(Ride ride) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("SAVED_RIDE_SQL");

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RIDE, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, ride.getAddressFrom().getId());
            preparedStatement.setLong(2, ride.getAddressTo().getId());
            preparedStatement.setLong(3, ride.getOrder().getId());
            int rewSaved = preparedStatement.executeUpdate();
            if (rewSaved > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ride.setId(generatedKeys.getLong(1));
                        return ride;
                    }

                }
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return ride;
    }

    @Override
    public List<Ride> saveAll(List<Ride> list) throws DaoException {
        log.info("SAVED_ALL_RIDE");
        for (Ride ride : list) {
            save(ride);
        }
        return list;
    }


    @Override
    public Ride selectById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_RIDE_BY_ID");
        Ride ride = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RIDE)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long addressIdFrom = resultSet.getLong("address_id_from");
                long addressIdTo = resultSet.getLong("address_id_to");
                long orderId = resultSet.getLong("order_id");

                ride = new Ride(id, new Address(addressIdFrom), new Address(addressIdTo), new Order(orderId));

            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return ride;
    }

    @Override
    public List<Ride> selectAll() throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ALL_RIDE_LIST");
        List<Ride> rideList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RIDE)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long addressIdFrom = resultSet.getLong("address_id_from");
                long addressIdTo = resultSet.getLong("address_id_to");
                long orderId = resultSet.getLong("order_id");
                long id = resultSet.getLong("id");

                rideList.add(new Ride(id, new Address(addressIdFrom), new Address(addressIdTo), new Order(orderId)));
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return rideList;
    }

    @Override
    public Ride update(Ride ride) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("UPDATE_RIDE");
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RIDE, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, ride.getAddressFrom().getId());
            preparedStatement.setLong(2, ride.getAddressTo().getId());
            preparedStatement.setLong(3, ride.getOrder().getId());
            preparedStatement.setLong(4, ride.getId());
            preparedStatement.executeUpdate();
            return ride;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("DELETE_RIDE_BY_ID");
        boolean rewDelete;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RIDE)) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return rewDelete;
    }
}
