package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.exception.DaoException;

import com.magdy.taxiwebappliction.model.dao.DaoInterface;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AddressDao implements DaoInterface<Address> {


    private static final Logger logger = Logger.getLogger(AddressDao.class.getName());


    @Override
    public Address save(Address address) throws DaoException {
        logger.info("SAVED_ADDRESS_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO Address (town,street,building) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getTown());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getBuilding());
            int rewSaved = preparedStatement.executeUpdate();

            if (rewSaved > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        address.setId(generatedKeys.getLong(1));
                        return address;
                    } else {
                        throw new DaoException("Creating Address failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            logger.info("can't save dao address");
            throw new DaoException(e.getMessage());
        }
        return null;
    }


    @Override
    public List<Address> saveAll(List<Address> list) throws DaoException {
        logger.info("SAVED_ALL_ADDRESS");
        for (Address address : list) {
            logger.info("can't save all dao address");
            save(address);
        }
        return list;
    }


    @Override
    public Address selectById(long id) throws DaoException {
        logger.info("GET_ADDRESS_BY_ID");
        Address address = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,town,street,building from address where id=?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String town = resultSet.getString("town");
                String street = resultSet.getString("street");
                int building = resultSet.getInt("building");
                address = new Address(id, town, street, building);

            }

        } catch (SQLException e) {
            logger.info("can't get by id  dao address");
            throw new DaoException(e.getMessage());
        }
        return address;
    }


    @Override
    public List<Address> selectAll() throws DaoException {
        logger.info("GET_ALL_ADDRESS_LIST");
        List<Address> addressArrayList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from address")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String town = resultSet.getString("town");
                String street = resultSet.getString("street");
                int building = resultSet.getInt("building");
                addressArrayList.add(new Address(id, town, street, building));
            }
        } catch (SQLException e) {
            logger.info("address can't get all dao address");
            throw new DaoException(e.getMessage());
        }
        return addressArrayList;
    }

    @Override
    public Address update(Address address) throws DaoException {
        logger.info("UPDATE_ADDRESS");

        try (PreparedStatement preparedStatement = connection.prepareStatement("update address set town=?,street=?,building=? where id=?", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getTown());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getBuilding());
            preparedStatement.setLong(4, address.getId());

            preparedStatement.executeUpdate();
            return address;
        } catch (SQLException e) {
            logger.info("address can't update dao address");
            throw new DaoException(e.getMessage());

        }

    }


    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_ADDRESS_BY_ID");
        boolean rowDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from address where id=?")) {
            preparedStatement.setLong(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            logger.info(" address can't delete dao address");
            throw new DaoException(e.getMessage());
        }
        return rowDelete;
    }
}
