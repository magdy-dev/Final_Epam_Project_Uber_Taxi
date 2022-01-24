package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.ClientDao;
import com.magdy.taxiwebappliction.dao.Dao;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends BaseDao implements ClientDao {
    private static final Logger log = (Logger) LogManager.getLogger();

    private static final String INSERT_CLIENT = "INSERT  INTO client (name,last_Name,email,password,phone_Number) VALUES (?,?,?,?,?)";
    private static final String SELECT_RIDE = "select id,name,last_Name,email,password,phone_Number from client where id=?";
    private static final String SELECT_ALL_RIDE = "select * from client";
    private static final String UPDATE_RIDE = "update client set name=?,last_Name=?,email=?,password=?,phone_Number=? where id=?";
    private static final String DELETE_RIDE = "delete from client where id=?";
    private static final String LOGIN_RIDE = "select * from client where email=? and password=?";


    @Override
    public Client save(Client client) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("SAVED_CLIENT_QSL");
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPassword());
            preparedStatement.setString(5, client.getPhoneNumber());
            int rewSave = preparedStatement.executeUpdate();
            if (rewSave > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        client.setId(generatedKeys.getLong(1));
                        return client;
                    } else {
                        throw new DaoException("Creating user failed, no ID obtained.");
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
    public List<Client> saveAll(List<Client> list) throws DaoException {
        log.info("SAVED_ALL_CLIENT_SQL");
        for (Client client : list) {
            save(client);
        }

        return list;
    }


    @Override
    public Client selectById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_CLIENT_BY_ID");
        Client client = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RIDE)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_Name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_Number");
                client = new Client(id, name, lastName, email, password, phoneNumber);
            }

        } catch (SQLException e) {

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return client;
    }

    @Override
    public List<Client> selectAll() throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ALL_CLIENT_SQL");
        List<Client> clientList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RIDE)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_Name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_Number");
                clientList.add(new Client(id, name, lastName, email, password, phoneNumber));
            }

        } catch (SQLException e) {

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return clientList;
    }


    @Override
    public Client update(Client client) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("UPDATE_CLIENT_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RIDE)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPassword());
            preparedStatement.setString(5, client.getPhoneNumber());
            preparedStatement.setLong(6, client.getId());

            preparedStatement.executeUpdate();
            return client;
        } catch (SQLException e) {

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
    }


    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("DELETE_CLINT_SQL");
        boolean rewDelete = false;
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

    public Client login(String username, String password) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_CLIENT_BY_userName,Password");
        Client client = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_RIDE)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_Name");
                String phoneNumber = resultSet.getString("phone_Number");
                long id = resultSet.getLong("id");
                client = new Client(id, name, lastName, username, password, phoneNumber);
            }

        } catch (SQLException e) {

            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return client;
    }
}
