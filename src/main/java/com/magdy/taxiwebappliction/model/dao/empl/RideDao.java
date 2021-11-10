package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.DaoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RideDao implements DaoInterface<Ride> {
    private static final Logger logger = Logger.getLogger(RideDao.class.getName());

    @Override
    public Ride save(Ride ride) throws DaoException {
        logger.info("SAVED_RIDE_SQL");

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO ride (address_id_from ,address_id_to,order_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, ride.getAddressIdFrom().getId());
            preparedStatement.setLong(2, ride.getAddressIdTo().getId());
            preparedStatement.setLong(3, ride.getOrderId().getId());
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
        }
        return ride;
    }

    @Override
    public List<Ride> saveAll(List<Ride> list) throws DaoException {
        logger.info("SAVED_ALL_RIDE");
        for (Ride ride : list) {
            save(ride);
        }
        return list;
    }


    @Override
    public Ride selectById(long id) throws DaoException {
        logger.info("GET_RIDE_BY_ID");
        Ride ride = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select address_id_from ,address_id_to,order_id from ride where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long addressIdFrom = resultSet.getLong("address_id_from ");
                long addressIdTo = resultSet.getLong("address_id_to ");
                long orderId = resultSet.getLong("order_id ");

                ride = new Ride(id, new Address(addressIdFrom), new Address(addressIdTo), new Order(orderId));

            }
        } catch (SQLException e) {
            logger.info("ride can't get ride by id");
            throw new DaoException(e.getMessage());
        }
        return ride;
    }

    @Override
    public List<Ride> selectAll() throws DaoException {
        logger.info("GET_ALL_RIDE_LIST");
        List<Ride> rideList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from ride")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long addressIdFrom = resultSet.getLong("address_id_from ");
                long addressIdTo = resultSet.getLong("address_id_to ");
                long orderId = resultSet.getLong("order_id ");
                long id = resultSet.getLong("id");

                rideList.add(new Ride(id, new Address(addressIdFrom), new Address(addressIdTo), new Order(orderId)));
            }

        } catch (SQLException e) {
            logger.info("ride can't get all ride");
            throw new DaoException(e.getMessage());
        }
        return rideList;
    }

    @Override
    public Ride update(Ride ride) throws DaoException {
        logger.info("UPDATE_RIDE");
        try (PreparedStatement preparedStatement = connection.prepareStatement("update ride set address_id_from=?,address_id_to=?,order_id=? where id=?", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, ride.getAddressIdFrom().getId());
            preparedStatement.setLong(2, ride.getAddressIdTo().getId());
            preparedStatement.setLong(3, ride.getOrderId().getId());
            preparedStatement.setLong(4, ride.getId());
            preparedStatement.executeUpdate();
            return ride;

        } catch (SQLException e) {
            logger.info("ride can't update");
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_RIDE_BY_ID");
        boolean rewDelete;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from ride where id=?")) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.info("ride can't delete");
            throw new DaoException(e.getMessage());
        }
        return rewDelete;
    }
}
