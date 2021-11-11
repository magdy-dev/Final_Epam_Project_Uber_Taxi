package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.ClientDao;

import java.util.List;
import java.util.logging.Logger;

public class ClientService implements ServiceInterface<Client> {

    private ClientDao clientDao = new ClientDao();
    private Client client = new Client();

    private static final Logger logger = Logger.getLogger(ClientService.class.getName());

    @Override
    public Client save(Client client) throws ServiceException {
        logger.info("SAVE_CLIENT");
        try {
            return clientDao.save(client);
        } catch (DaoException e) {
            logger.info("can't save Service client");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Client> saveAll(List<Client> list) throws ServiceException {
        logger.info("SAVE_ALL_CLIENT");
        try {
            return clientDao.saveAll(list);
        } catch (DaoException e) {
            logger.info("can't save all Service client");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client selectById(long id) throws ServiceException {
        logger.info("GET_ALL_CLIENT_BY_ID");
        try {
            return clientDao.selectById(id);
        } catch (DaoException e) {
            logger.info("can't get by id Service client");
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Client> selectAll() throws ServiceException {
        logger.info("GET_ALL_CLIENT");
        try {
            return clientDao.selectAll();
        } catch (DaoException e) {
            logger.info("can't get all Service client");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client update(Client client) throws ServiceException {
        logger.info("UPDATE_CLIENT");
        try {
            return clientDao.update(client);
        } catch (DaoException e) {
            logger.info("can't update Service client");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_CLIENT");
        try {
            return clientDao.deleteById(id);
        } catch (DaoException e) {
            logger.info("can't delete  Service client");
            throw new ServiceException(e.getMessage());
        }

    }

    public Client login(String username, String password) throws ServiceException {
        logger.info("LOGIN PASS");
        try {

            return clientDao.login(username,password);
        } catch (DaoException e) {
            logger.info("can't login  Service client");
            throw new ServiceException(e.getMessage());
        }
    }
}
