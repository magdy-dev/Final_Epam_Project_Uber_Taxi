package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.DaoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClientDao implements DaoInterface<Client> {

    private static final Logger logger = Logger.getLogger(ClientDao.class.getName());

    @Override
    public Client save(Client client) throws DaoException {
        logger.info("SAVED_CLIENT_QSL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO client (name,last_Name,email,password,phone_Number) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
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
            logger.info("client can't save dao client");
            throw new DaoException(e.getMessage());
        }
        return null;
    }


    @Override
    public List<Client> saveAll(List<Client> list) throws DaoException {
        logger.info("SAVED_ALL_CLIENT_SQL");
        for (Client client : list) {
            save(client);
        }

        return list;
    }


    @Override
    public Client selectById(long id) throws DaoException {
        logger.info("GET_CLIENT_BY_ID");
        Client client = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name,last_Name,email,password,phone_Number from client where id=?")) {
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
            logger.info(" client can't get by id dao client");
            throw new DaoException(e.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> selectAll() throws DaoException {
        logger.info("GET_ALL_CLIENT_SQL");
        List<Client> clientList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from client")) {

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
            logger.info("client can't get all dao client");
            throw new DaoException(e.getMessage());
        }
        return clientList;
    }


    @Override
    public Client update(Client client) throws DaoException {
        logger.info("UPDATE_CLIENT_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("update client set name=?,last_Name=?,email=?,password=?,phone_Number=? where id=?")) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPassword());
            preparedStatement.setString(5, client.getPhoneNumber());
            preparedStatement.setLong(6, client.getId());

            preparedStatement.executeUpdate();
            return client;
        } catch (SQLException e) {
            logger.info("client can't update dao client");
            throw new DaoException(e.getMessage());
        }
    }


    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_CLINT_SQL");
        boolean rewDelete = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from client where id=?")) {
            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;


        } catch (SQLException e) {
            logger.info("client can't delete  dao client");
            throw new DaoException(e.getMessage());
        }
        return rewDelete;
    }
}
