package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.AddressDao;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressDaoImpl extends BaseDao implements AddressDao {


    private static final Logger log = (Logger) LogManager.getLogger();
    private static final String INSERT_ADDRESS = "INSERT  INTO Address (town,street,building) VALUES (?,?,?)";
    private static final String SELECT_ADDRESS = "select id,town,street,building from address where id=?";
    private static final String SELECT_ALL_ADDRESS = "select * from address";
    private static final String UPDATE_ADDRESS = "update address set town=?,street=?,building=? where id=?";
    private static final String DELETE_ADDRESS = "delete from address where id=?";


    @Override
    public Address save(Address address) throws DaoException {
        log.info("SAVED_ADDRESS_SQL");
        Connection connection = pool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS)) {
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

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return null;
    }


    @Override
    public List<Address> saveAll(List<Address> list) throws DaoException {
        log.info("SAVED_ALL_ADDRESS");
        for (Address address : list) {

            save(address);
        }
        return list;
    }


    @Override
    public Address selectById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ADDRESS_BY_ID");
        Address address = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String town = resultSet.getString("town");
                String street = resultSet.getString("street");
                int building = resultSet.getInt("building");
                address = new Address(id, town, street, building);

            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());

        } finally {
            pool.returnConnection(connection);
        }
        return address;
    }


    @Override
    public List<Address> selectAll() throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ALL_ADDRESS_LIST");
        List<Address> addressArrayList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String town = resultSet.getString("town");
                String street = resultSet.getString("street");
                int building = resultSet.getInt("building");
                addressArrayList.add(new Address(id, town, street, building));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return addressArrayList;
    }

    @Override
    public Address update(Address address) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("UPDATE_ADDRESS");

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getTown());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getBuilding());
            preparedStatement.setLong(4, address.getId());

            preparedStatement.executeUpdate();
            return address;
        } catch (SQLException e) {

            throw new DaoException(e.getMessage());

        } finally {
            pool.returnConnection(connection);
        }

    }


    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("DELETE_ADDRESS_BY_ID");
        boolean rowDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS)) {
            preparedStatement.setLong(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return rowDelete;
    }
}
