package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.ClientService;
import com.magdy.taxiwebappliction.service.ServiceException;

import java.util.List;
import java.util.logging.Logger;

public class ClientServiceImpl extends BaseService implements ClientService {

    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private Client client = new Client();

    private static final Logger logger = Logger.getLogger(ClientServiceImpl.class.getName());

    @Override
    public Client save(Client client) throws ServiceException {
        logger.info("SAVE_CLIENT");
        try {
            return clientDaoImpl.save(client);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Client> saveAll(List<Client> list) throws ServiceException {
        logger.info("SAVE_ALL_CLIENT");
        try {
            return clientDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client selectById(long id) throws ServiceException {
        logger.info("GET_ALL_CLIENT_BY_ID");
        try {
            return clientDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Client> selectAll() throws ServiceException {
        logger.info("GET_ALL_CLIENT");
        try {
            return clientDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client update(Client client) throws ServiceException {
        logger.info("UPDATE_CLIENT");
        try {
            return clientDaoImpl.update(client);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_CLIENT");
        try {
            return clientDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Client login(String username, String password) throws ServiceException {
        logger.info("LOGIN PASS");
        try {

            return clientDaoImpl.login(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
